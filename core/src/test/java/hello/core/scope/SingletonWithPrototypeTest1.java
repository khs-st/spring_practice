package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonWithPrototypeTest1 {

    //스프링 컨테이너에 프로토타입 빈 직접 요청
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
