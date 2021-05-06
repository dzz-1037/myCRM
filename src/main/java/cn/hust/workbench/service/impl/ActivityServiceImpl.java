package cn.hust.workbench.service.impl;

import cn.hust.vo.PageHelpVO;
import cn.hust.workbench.dao.ActivityDao;
import cn.hust.workbench.dao.ActivityRemarkDao;
import cn.hust.workbench.domain.Activity;
import cn.hust.workbench.service.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author DaiZheng
 * @email 543717592@qq.com
 * @date 2021/5/4 0004下午 4:13
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Resource
    private ActivityDao activityDao;
    @Resource
    private ActivityRemarkDao activityRemarkDao;

    @Override
    public boolean save(Activity activity) {
        boolean flag = true;
        int count = activityDao.save(activity);
        if (count != 1) {
            flag = false;
        }
        return flag;
    }

    @Override
    public List<Activity> selectAllActivities() {
        return activityDao.selectAllActivities();
    }

    @Override
    public PageHelpVO pageList(Map<String, Object> map) {
        //取得total
        int total = activityDao.getTotalByCondition(map);
        //取dataList
        List<Activity> dataList = activityDao.getActivityByCondition(map);

        PageHelpVO pageHelpVO = new PageHelpVO();
        pageHelpVO.setDataList(dataList);
        pageHelpVO.setTotal(total);
        return pageHelpVO;
    }

    @Override
    public boolean delete(String[] id) {
        boolean flag = true;
        //先删除备注，返回收到影响的行数
        int count = activityRemarkDao.getCountByIds(id);
        //删除备注
        int count1 = activityRemarkDao.deleteByIds(id);
        if (count != count1) {
            flag = false;
        }
        //删除市场活动
        int count3 = activityDao.delete(id);
        if (count3 != id.length) {
            flag = false;
        }
        return flag;
    }


}
