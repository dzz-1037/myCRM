package cn.hust.workbench.dao;

import cn.hust.workbench.domain.Activity;

import java.util.List;
import java.util.Map;

/**
 * @author DaiZheng
 * @email 543717592@qq.com
 * @date 2021/5/4 0004下午 4:10
 */
public interface ActivityDao {
    int save(Activity activity);
    List<Activity> selectAllActivities();

    List<Activity> getActivityByCondition(Map<String, Object> map);

    int getTotalByCondition(Map<String, Object> map);

    int delete(String[] id);
}
