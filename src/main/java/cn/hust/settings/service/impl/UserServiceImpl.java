package cn.hust.settings.service.impl;

import cn.hust.exception.LoginException;
import cn.hust.settings.dao.UserDao;
import cn.hust.settings.domain.User;
import cn.hust.settings.service.UserService;
import cn.hust.utils.DateTimeUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DaiZheng
 * @email 543717592@qq.com
 * @date 2021/5/4 0004上午 9:10
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public List<User> selectUsers() {
        return userDao.selectUsers();
    }

    @Override
    public User login(String loginAct, String loginPwd,String ip) throws LoginException {
        Map<String ,Object> map= new HashMap<>();
        map.put("loginAct",loginAct);
        map.put("loginPwd",loginPwd);
        User loginUser = userDao.login(map);
        if(loginUser==null){
            throw new LoginException("账号密码错误");
        }
        //验证失效时间
        String expireTime  = loginUser.getExpireTime();
        String currentTime = DateTimeUtil.getSysTime();
        if(expireTime.compareTo(currentTime)<0){
            throw new LoginException("账号失效");

        }
        //判断锁定状态
        if("0".equals(loginUser.getLockState())){
            throw new LoginException("账号已锁定");
        }
        //判断ip
        if(!loginUser.getAllowIps().contains(ip)){
            throw new LoginException("ip受限");
        }
        return loginUser;
    }
}
