package cn.hust.workbench.service;

import cn.hust.vo.PageHelpVO;
import cn.hust.workbench.domain.Activity;

import java.util.List;
import java.util.Map;

/**
 * @author DaiZheng
 * @email 543717592@qq.com
 * @date 2021/5/4 0004下午 4:12
 */
public interface ActivityService {
    boolean save(Activity activity);
    List<Activity> selectAllActivities();
    PageHelpVO pageList(Map<String, Object> map);

    boolean delete(String[] id);
}
