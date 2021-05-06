package cn.hust;

import org.junit.Test;

import java.util.UUID;

/**
 * @author DaiZheng
 * @email 543717592@qq.com
 * @date 2021/5/3 0003下午 3:27
 */
public class Test2 {
    @Test
    public void test01(){
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        System.out.println(s);
        System.out.println(s.length());
        String s1 = s.replaceAll("-", "");
        System.out.println(s1);
    }
}
