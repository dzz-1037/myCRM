package cn.hust.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

//拦截器类，拦截用户的请求
public class MyInterceptor implements HandlerInterceptor {
    /**
     * preHandle:预处理方法
     * <p>
     * 【重要】是整个项目的入口，门户。当preHandle返回true请求可以被处理。
     * preHandle返回false，请求到此方法就截止。
     * <p>
     * 参数：
     * Object handler：被拦截的控制器对象
     * <p>
     * 返回值：Boolean
     * true：:请求是通过了拦截器的验证，可以执行处理器方法。
     * false：请求没有通过拦戳器的验证，请求到达拦截器就截止了。请求没有被处理
     * <p>
     * 特点：
     * 1、在控制器方法前执行.( MyController的doSome)之前先执行的。
     * 用户的请求首先到达此方法
     * 2.在这个方法中可以获取请求的信息，验证请求是否符合要求。
     * 可以验证用户是否登录，验证用户是否有权限访问某个连接地址(url).如果验证失败，可以截断请求，请求不能被处理。
     * 如果验证成功，可以放行请求，此时控制器方法才能执行。
     */
    private long btime = 0;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        btime = System.currentTimeMillis();
        System.out.println("==拦截器MyInterceptor的preHandle方法...==");

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return false;
        }
        //给浏览器一个返回结果
        return true;
    }

    /**
     * postHandle:后处理方法
     * 参数：
     * object handler:被拦截的处理器对象MyController
     * ModelAndView modelAndView：处理器方法的返回值
     * <p>
     * 特点：
     * 1、在处理器方法后执行的
     * 2、能够获取处理器方法的返回值，可以修改ModelAndView中的
     * 数据和视图，可以影响到最后的执行结果。
     * 3、主要是对原来的执行结果做二次修正
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("==拦 截器MyInterceptor的postHandle方法...==");
        //对原来doSome执行结果进行调整
        if (modelAndView != null) {
            //修改数据
            modelAndView.addObject("mydate", new Date());
            //修改视图
            modelAndView.setViewName("other");
        }
    }

    /**
     * afterCompletion，最后执行的方法
     * 参数：
     * object handler:被拦截的处理器对象MyController
     * Exception ex：程序中发生的异常
     * 特点：
     * 1、在请求处理完成后执行的。框架中规定是当你的视图处理完成后，对视图执行了forward。就认为请求处理完成。
     * 2、一般做资源回收工作，程序请求过程中创建了一些对象,在这里可以删除,把占用的内存回收。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("==拦截器MyInterceptor的afterCompletion方法...==");
        btime = System.currentTimeMillis()-btime;
        System.out.println("从preHandler到请求处理完成的时间"+btime);
    }
}
