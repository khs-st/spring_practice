package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonWithPrototypeTest1 {

    //clientBean이 내부에 가지고 있는 프로토타입 빈은 이미 과거에 주입이 끝난 빈이다.
    //주입 시점에 스프링 컨테이너에 요청해서 프로토타입 빈이 새로 생성이 된 것이지,
    //사용 할 때마다 새로 생성되는 것이 아니다
    @Test
    void prototypeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototyeBean.class);
        PrototyeBean prototyeBean1 = ac.getBean(PrototyeBean.class);
        prototyeBean1.addCount();
        Assertions.assertThat(prototyeBean1.getCount()).isEqualTo(1);

        PrototyeBean prototyeBean2 = ac.getBean(PrototyeBean.class);
        prototyeBean2.addCount();
        Assertions.assertThat(prototyeBean2.getCount()).isEqualTo(1);
    }

    @Test
    void singletonClientUsePrototype(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class,PrototyeBean.class);
        ClientBean clientBean1 = ac.getBean(ClientBean.class);

        int count1 = clientBean1.logic();
        System.out.println("clientBean1.logic = "+count1);
        ClientBean clientBean2 = ac.getBean(ClientBean.class);

        int count2 = clientBean2.logic();
        System.out.println("clientBean2.logic = "+count2);
        Assertions.assertThat(count2).isEqualTo(2);
    }

    @Scope("singleton")
    static class ClientBean{
        private final PrototyeBean prtotypeBean;

        @Autowired
        public ClientBean(PrototyeBean prototyeBean){
            this.prtotypeBean=prototyeBean;
        }

        public int logic(){
            prtotypeBean.addCount();
            int count = prtotypeBean.getCount();
            return count;
        }

    }

    @Scope("prototype")
    static class PrototyeBean{
        private int count=0;

        public void addCount(){
            count++;
        }
        public int getCount(){
            return count;
        }

        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init" + this);
        }

        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeBean.destroy"+this);
        }
    }
}
