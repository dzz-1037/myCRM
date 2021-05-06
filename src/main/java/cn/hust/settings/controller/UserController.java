package cn.hust.settings.controller;

import cn.hust.settings.domain.Student;
import cn.hust.settings.domain.User;
import cn.hust.settings.service.UserService;
import cn.hust.settings.service.impl.UserServiceImpl;
import cn.hust.utils.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DaiZheng
 * @email 543717592@qq.com
 * @date 2021/5/4 0004上午 9:13
 */
@Controller
@RequestMapping(value = "/settings/user")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping(value = {"/login.do"})
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request, String loginAct, String loginPwd){
        System.out.println("验证登录信息...");
        //转化为密文
        loginPwd= MD5Util.getMD5(loginPwd);
        String ip = request.getRemoteAddr();
        System.out.println(ip);
        Map<String,Object> map = new HashMap<>();
        try {
            System.out.println(loginAct);
            User loginUser = userService.login(loginAct, loginPwd, ip);
            System.out.println(loginUser);
            map.put("success",true);
            request.getSession().setAttribute("user",loginUser);
        }catch (Exception e){
            e.printStackTrace();
            String message = e.getMessage();
            System.out.println("---------------"+message);
            map.put("success",false);
            map.put("msg",message);
        }
        return map;
    }
}