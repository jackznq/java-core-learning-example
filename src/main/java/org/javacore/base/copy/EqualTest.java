package org.javacore.base.copy;

import java.util.HashSet;

public class EqualTest {
    public static void main(String[] args) {
        Person p1 = new Person(10, "张三");
        Person p2 = new Person(10, "张三");
        System.out.println(
            "p1.equals(p2)= " + p1.equals(p2) + ", p1.hashcode= " + p1.hashCode() + ", p2.hashcode= " + p2.hashCode() + ",p1==p2= " + (p1 == p2));
        HashSet<Person> set = new HashSet<Person>();
        set.add(p1);
        set.add(p2);
        System.out.println(set);

        String s1 = "s1";
        String s2 = "s1";
        System.out.println(
            "s1.equals(s2)= " + s1.equals(s2) + ", s1.hashcode= " + s1.hashCode() + ", s2.hashcode= " + s2.hashCode() + ",s1==s2= " + (s1 == s2));
        String s3 = new String("s3");
        String s4 = new String("s3");
        System.out.println(
            "s3.equals(s4)= " + s3.equals(s4) + ", s3.hashcode= " + s3.hashCode() + ", s4.hashcode= " + s4.hashCode() + ",s3==s4= " + (s3 == s4));
    }
}

class Person {
    int age;
    String name;

    public Person(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
}
