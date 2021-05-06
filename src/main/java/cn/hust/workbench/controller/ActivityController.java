package cn.hust.workbench.controller;

import cn.hust.settings.domain.User;
import cn.hust.settings.service.UserService;
import cn.hust.utils.DateTimeUtil;
import cn.hust.utils.UUIDUtil;
import cn.hust.vo.PageHelpVO;
import cn.hust.workbench.domain.Activity;
import cn.hust.workbench.service.ActivityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author DaiZheng
 * @email 543717592@qq.com
 * @date 2021/5/4 0004上午 9:13
 */
@Controller
@RequestMapping(value = "/workbench/activity")
public class ActivityController {
    @Resource
    private UserService userService;
    @Resource
    private ActivityService activityService;

    @RequestMapping(value = {"/getUserList.do"})
    @ResponseBody
    public List<User> getUserList(HttpServletRequest request, String loginAct, String loginPwd) {
        List<User> users = userService.selectUsers();
        return users;
    }

    @RequestMapping(value = {"/save.do"})
    @ResponseBody
    public boolean save(HttpServletRequest request, Activity activity) {
        activity.setId(UUIDUtil.getUUID());
        activity.setCreateTime(DateTimeUtil.getSysTime());
        User user = (User) request.getSession().getAttribute("user");
        activity.setCreateBy(user.getName());
        boolean flag = activityService.save(activity);
        System.out.println(flag + "-------");
        return true;
    }

    @RequestMapping(value = {"/pageList.do"})
    @ResponseBody
    public PageHelpVO pageList(HttpServletRequest request,
                               String pageNo,
                               String pageSize,//每页展现的记录数
                               String name,
                               String owner,
                               String startDate,
                               String endDate) {
        System.out.println("---------------进行分页---------------");
        //计算sql中  limit x , y 中的 x
        int pageNum = Integer.parseInt(pageNo);
        int pageSizes = Integer.parseInt(pageSize);
        int x = (pageNum - 1) * pageSizes;//表示从x+1条记录开始，展现y条  y <= pageSize
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("owner", owner);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("x", x);
        map.put("pageSize", pageSizes);
        System.out.println("map---->" + map);
        PageHelpVO pageHelpVO = activityService.pageList(map);
        System.out.println("返回结果---->" + pageHelpVO);
        return pageHelpVO;
    }

    @RequestMapping(value = {"/delete.do"})
    @ResponseBody
    public boolean delete(HttpServletRequest request, String ids) {
        System.out.println("--进行删除模块-----");
        boolean flag = true;
        String[] id = ids.split(" ");
        System.out.println(Arrays.toString(id));
        //先删除备注，返回收到影响的行数
        flag = activityService.delete(id);
        //删除市场活动·
        return flag;
    }
}