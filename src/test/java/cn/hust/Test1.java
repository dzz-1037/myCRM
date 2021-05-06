package cn.hust;

import cn.hust.settings.domain.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author DaiZheng
 * @email 543717592@qq.com
 * @date 2021/5/3 0003下午 3:27
 */
public class Test1 {
    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
        Student stu = (Student) ac.getBean("student");
        System.out.println(stu);
    }
}
