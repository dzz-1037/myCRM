package cn.hust.settings.dao;

import cn.hust.settings.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author DaiZheng
 * @email 543717592@qq.com
 * @date 2021/5/4 0004上午 9:06
 */
public interface UserDao {
    List<User> selectUsers();
    User login(Map<String,Object> map);
}
