package myspring.di.annot;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// = <bean id="helloBean" class="myspring.di.annot.HelloBean" />
@Component("helloBean")
public class HelloBean {
	// 전략2 setter injection
	// = <property name="name value="어노테이션" />
	@Value("${myname21}")
	String name;
	
	// 전략2 setter injection
	// Resource는 생성자에 적용 X, 변수로는 가능
	// <property name="printer" ref="stringPrinter" />
	@Autowired
//	@Qualifier("${myprinter21}")
	@Resource(name="${myprinter21}")
	PrinterBean printer;	// @Qualifier가 없으면, printer라는 변수명과 같은 bean을 가져옴
	
	@Value("#{'${mynames21}'.split(',')}")
	//@Value("Java,SpringFW,SpringBoot") 
	List<String> names;

	public HelloBean() {
		System.out.println(this.getClass().getName() + "의 생성자가 호출됨");
	}
	
	// 전략 2 constructor injection
//	@Autowired
//	public HelloBean(@Value("생성자 어노테이션") String name, 
//			@Qualifier("stringPrinterBean") PrinterBean printer) {
//		System.out.println(this.getClass().getName() + "Overloaded 생성자가 호출됨");
//		this.name = name;
//		this.printer = printer;
//	}
	
	public List<String> getNames() {
		return this.names;
	}

//	public void setNames(List<String> list) {
//		this.names = list;
//	}

//	public void setName(String name) {
//		System.out.println(this.getClass().getName() + "setName() 호출됨" + name);
//		this.name = name;
//	}

//	public void setPrinter(PrinterBean printer) {
//		System.out.println(this.getClass().getName() + "setPrinter() 호출됨" 
//	+ printer.getClass().getName());
//		this.printer = printer;
//	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());	// StringPrinter의 printer() 메소드를 호출
	}

}
