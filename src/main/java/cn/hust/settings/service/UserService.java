package cn.hust.settings.service;

import cn.hust.exception.LoginException;
import cn.hust.settings.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author DaiZheng
 * @email 543717592@qq.com
 * @date 2021/5/4 0004上午 9:10
 */
public interface UserService {
    List<User> selectUsers();
    User login(String loginAct, String loginPwd,String ip) throws LoginException;
}
