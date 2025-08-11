package myspring.di.annot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring_beans.xml")
public class HelloBeanSpringTest {
	@Autowired
	HelloBean hello;	// HelloBean.java와의 변수명과 달라도됨, 타입으로 판단하기 때문
	
	@Autowired
	@Qualifier("stringPrinterBean")
	PrinterBean printer;
	
	//전략2의 constructor injection 설정을 테스트
	@Test @Disabled
	void helloBeanConstructor() {
		assertEquals("Hello 생성자어노테이션", hello.sayHello());
		hello.print();
		assertEquals("Hello 생성자어노테이션", printer.toString());
	}
	
	
	//전략2의 setter injection 설정을 테스트
	@Test // @Disabled
	void helloBean() {
		assertEquals("Hello 어노테이션", hello.sayHello());
		
		hello.print();
		
		assertEquals("Hello 어노테이션", printer.toString());
		
		assertEquals(3, hello.getNames().size());
		
	}
}
