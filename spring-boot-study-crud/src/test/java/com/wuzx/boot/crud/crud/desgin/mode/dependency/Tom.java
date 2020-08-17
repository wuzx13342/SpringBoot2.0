package com.wuzx.boot.crud.crud.desgin.mode.dependency;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.dependency
 * @ClassName: Tom
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-25 16:54
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */

/**
 * 依赖注入 依赖倒置原则
 */
public class Tom{
    public void study(ICourse course) {
        course.study();
    }
    public static void main(String[] args) {
        Tom tom =new Tom();
        tom.study(new JavaCourse());
        tom.study(new PythonCourse());

    }
}
