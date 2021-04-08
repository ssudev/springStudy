package hello.core.beanFind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면 중복 오류가 발생한다.")
    void findBeanByParentTypeDup(){
        DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면 빈 이름을 지정하면 된다.")
    void findBeanByParentTypeBeanName(){
        DiscountPolicy bean = ac.getBean("rateDiscountPolicy",DiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회.")
    void findBeanBySubType(){
        DiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 전부 조회")
    void findBeanByParent(){
        Map<String, DiscountPolicy> beans = ac.getBeansOfType(DiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 전부 조회 - Object")
    void findBeanByObject(){
        Map<String, Object> beans = ac.getBeansOfType(Object.class);
        for(String key : beans.keySet()){
            System.out.println("key =" + key + "value =" + beans.get(key));
        }
    }


    @Configuration
    static class TestConfig {
        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }
        @Bean
        public DiscountPolicy fixDiscountPolicy(){
            return new FixDiscountPolicy();
        }
    }
}
