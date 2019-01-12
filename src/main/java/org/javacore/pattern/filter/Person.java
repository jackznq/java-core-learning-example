package org.javacore.pattern.filter;

/**
 * className: Person
 * Package: org.javacore.pattern.filter
 * Description:
 * Author:znq
 * Date 19/1/8 下午2:53
 */
public class Person {

    private String name;
    private String gender;
    private String maritalStatus;

    public Person(String name, String gender, String maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }
}
