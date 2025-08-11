package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// 설정 클래스임을 나타내는 어노테이션
@Configuration
// <context:component-scan base-package="myspring.di.annot" />와 동일
@ComponentScan(basePackages = "myspring.di.annot")
//<context:property-placeholder location="classpath:values.properties"/>
@PropertySource(value = "classpath:values.properties")
public class HelloBeanConfig {

}
