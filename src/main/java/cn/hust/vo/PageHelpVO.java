package cn.hust.vo;

import java.util.List;

/**
 * @author DaiZheng
 * @email 543717592@qq.com
 * @date 2021/5/5 0005上午 10:27
 */
public class PageHelpVO<T> {
    private int total;
    private List<T> dataList;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "PageHelpVO{" +
                "total=" + total +
                ", dataList=" + dataList +
                '}';
    }
}
