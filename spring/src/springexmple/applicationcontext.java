package springexmple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class applicationcontext {

	public static void main(String[] args) {
		 ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
	      Student obj = (Student) context.getBean("studentapplicationcontext");
	      obj.displayInfo();
	}

}
