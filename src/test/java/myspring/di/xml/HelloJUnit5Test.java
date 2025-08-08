package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class HelloJUnit5Test {
	ApplicationContext context;
	
	@BeforeEach		// @Test 메소드가 실행되기 전에 반드시 실행됨
	void createContainer() {
		// 1. Container 객체 생성
		context = new GenericXmlApplicationContext("classpath:spring_beans.xml");
	}
	
	// 반드시 어노테이션이 있어야함
	@Test
	void helloBean() {
		// 2. Container가 생성한 Hello 스프링빈을 요청하기 
		Hello helloById = (Hello)(context.getBean("hello"));			// id만 주거나
		Hello helloByType = context.getBean("hello", Hello.class);	// id, class 타입을 같이 줌
		
		// 주소를 비교해서 Singleton 인지 확인하기
		System.out.println(helloById == helloByType);	// true이면, 주소가 같음. 같은 객체가 반환됨
		
		// JUnit의 Assertions.asserSame()사용
		assertSame(helloById, helloByType);	// 연두색이 뜨면, 테스트 케이스가 성공헀고 주소가 같음을 의미
		
		// <property name="name" value="스프링"/> 설정을 테스트
		// 값을 비교함
		assertEquals("Hello 스프링", helloByType.sayHello());
		
		// <property name="printer" ref="stringPrinter"/> 설정을 테스트
		helloByType.print();
		
		// StringPrinter Spring Bean을 요청하기
		Printer printer = context.getBean("stringPrinter", Printer.class);	// 부모타입으로 주고받고 해도 됨
		assertEquals("Hello 스프링", printer.toString());
		
	}

}
