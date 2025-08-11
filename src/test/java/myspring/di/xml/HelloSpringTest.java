package myspring.di.xml;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//static import
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//HelloUnit5Test.java의 createContainer()를 대체함
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring_beans.xml")

public class HelloSpringTest {
	@Autowired
	@Qualifier("helloC")	// 해당 변수에 자동으로 빈을 매핑해줌 (getBean())
	Hello hello;
	
	// 전략1 Constructor Injection, Setter Injection 테스트
	@Test
	void helloBeanByConstructor() {
		System.out.println(hello.sayHello());
		assertEquals("Hello 생성자", hello.sayHello());
		
		hello.print();
		
		assertEquals(3, hello.getNames().size());  		// beans.xml에  value가 3개니까
		
		for(String name: hello.getNames()) {
			System.out.println(name);
		}
	}
}
