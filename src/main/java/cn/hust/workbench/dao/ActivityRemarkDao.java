package cn.hust.workbench.dao;

/**
 * @author DaiZheng
 * @email 543717592@qq.com
 * @date 2021/5/4 0004下午 4:10
 */
public interface ActivityRemarkDao {
    int getCountByIds(String[] id);

    int deleteByIds(String[] id);
}
