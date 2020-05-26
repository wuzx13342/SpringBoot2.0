package com.wuzx.boot.crud.desgin.mode.dependency;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.dependency
 * @ClassName: Course
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-25 17:01
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class Course {

  public void study(String courseName){
        if("1".equals(courseName)){
            System.out.println("111111");
        }else{
            System.out.println("2222222");
        }
    }

    public static void main(String[] args) {
        Course course =new Course();
        course.study("1");
        course.study("2");
    }
}
