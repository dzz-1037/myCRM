package cn.hust.settings.controller;

import cn.hust.settings.domain.Student;
import cn.hust.settings.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DaiZheng
 * @email 543717592@qq.com
 * @date 2021/5/3 0003上午 10:02
 */

/**
 * Ajax与json复习
 */
@Controller
public class MyController {
    @RequestMapping(value = {"/some.do"})
    public void doSome(HttpServletResponse response) throws IOException {
        System.out.println("doSome...");
        //{"str1":"aaa","str2":"bbb"}
        String str = "{\"str1\":\"aaa\",\"str2\":\"bbb\"}";
        PrintWriter pw = response.getWriter();
        pw.write(str);
        pw.close();
    }

    @RequestMapping(value = {"/some1.do"},produces ="text/plain;charset=utf-8")
    @ResponseBody
    public String doAjax() throws IOException {
        System.out.println("doSome1...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Heewwwwlo ajax 返回对象：表示数据";
    }

    @RequestMapping(value = {"/some2.do"})
    @ResponseBody
    public Student doJson() throws IOException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
        Student stu = (Student) ac.getBean("student");
        System.out.println(stu);
        return stu;
    }

    @RequestMapping(value = {"/some3.do"})
    @ResponseBody
    public List<Student> doJsonList() throws IOException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
        Student stu = (Student) ac.getBean("student");
        System.out.println(stu);
        Student student = new Student("A11","李四",24);
        List<Student> list  = new ArrayList<>();
        list.add(stu);
        list.add(student);
        return list;
    }
}
