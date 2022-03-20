package test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringDemo implements ApplicationContextAware {

    private String string;

    private TestDemo testDemo;

    public static void main(String[] args) {
        System.out.println(3%2);
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
//                "classpath:*c/test*.xml","classpath:*c/s*/test*.xml");
//        applicationContext.registerShutdownHook();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public TestDemo getTestDemo() {
        return testDemo;
    }

    public void setTestDemo(TestDemo testDemo) {
        this.testDemo = testDemo;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("aaaaaaaaaaaa");
    }
}
