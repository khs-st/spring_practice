package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5  extends HttpServlet {

    private final Map<String,Object> handlerMappinMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();
        iniHandlerAdapters();
    }

    private void initHandlerMappingMap() {
        handlerMappinMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappinMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappinMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        handlerAdapters.add(new ControllerV3HandlerAdapter());

    }

    private void iniHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. 핸들러 처리 할 수있는 핸들러 조회
        Object handler = getHandler(request);

        if(handler == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter adapter = getHandlerAdapter(handler);

        // 2. 핸들러 호출 -> handle 메서드는 ControllerV3HandlerAdapter 에서 컨트롤러 V3로 변환
        ModelView mv = adapter.handle(request,response,handler);
        
        // 6. viewName 가져와서 호출
        String viewName = mv.getViewName();
        MyView view = viewResolver(viewName);
        // 7. render(model) 호출
        view.render(mv.getModel(),request,response);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (MyHandlerAdapter adapter : handlerAdapters) {
            if(adapter.supports(handler)){
                return adapter;
            }
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler = "+handler);
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return handlerMappinMap.get(requestURI);
    }
}
