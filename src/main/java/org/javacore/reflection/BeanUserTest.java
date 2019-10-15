package org.javacore.reflection;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Date 18/9/3 上午10:48
 * @Auther znq
 * @ClassName BeanUserTest
 **/
public class BeanUserTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        User user = (User) context.getBean("user");
        user.setId(1);
        user.setName("znq");
        Course course = new Course();
        List<User> users = Lists.newArrayList();
        users.add(user);
        users.add(user);
        course.setId(1);
        course.setName("数学");
        course.setUsers(users);
        Course target = new Course();
        BeanUtils.copyProperties(course,target);
        users.remove(0);
        System.out.println(course);
        System.out.println(target);
    }
}
