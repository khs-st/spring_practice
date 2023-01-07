package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "reqeustParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("전체 파라미터 조회 시작");

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "="
                + request.getParameter(paramName)));

        System.out.println("전체 파라미터 조회 종료");
        System.out.println();

        System.out.println("단일 파라미터 조회 - 시작");

        String username = request.getParameter("username");
        String age= request.getParameter("age");
        System.out.println();


        System.out.println("이름이 같은 복수 파라미터 조회");
        //중복된 파라미터일 경우 getParameterValues()를 사용해야 한다.
        //중복일 때 getParameter() 사용 시 첫 번째 값을 반환한다.
        String [] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username = " + name);
        }

        response.getWriter().write("ok");
    }
}
