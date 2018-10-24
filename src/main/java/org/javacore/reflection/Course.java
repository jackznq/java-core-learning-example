package org.javacore.reflection;

import lombok.Data;

import java.util.List;

/**
 * @Date 18/9/3 上午10:58
 * @Auther znq
 * @ClassName Course
 **/
@Data
public class Course {

     private int id;

     private String name;

     private List<User> users;

    @Override
    public String toString() {
        return "Course{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", users=" + users +
            '}';
    }
}
