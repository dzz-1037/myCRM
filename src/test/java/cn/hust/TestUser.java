package cn.hust;

import cn.hust.exception.LoginException;
import cn.hust.settings.domain.User;
import cn.hust.settings.service.UserService;
import cn.hust.utils.DateTimeUtil;
import cn.hust.workbench.domain.Activity;
import cn.hust.workbench.service.ActivityService;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author DaiZheng
 * @email 543717592@qq.com
 * @date 2021/5/3 0003下午 3:27
 */
public class TestUser {
    @Test
    public void test01() throws LoginException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
        ActivityService aI = (ActivityService) ac.getBean("activityServiceImpl");
        System.out.println(aI);
        PageHelper.startPage(2,2);
        for (Activity activity : aI.selectAllActivities()) {
            System.out.println(activity);
        }
    }
}
