package org.javacore.pattern.prototype;

import java.util.Date;

/**
 *  生活中的简历复制，就是类似于代码中的clone
 * Created by znq on 2018/1/25.
 */
public class Resume implements Cloneable{

    private String name;

    private String sex;

    private int age;

    private WorkExperience workExperience;

    public Resume(String name) {
        this.name = name;
        workExperience =new WorkExperience();
    }

    public  void setPersonInfo(int age,String sex){
        this.age = age;
        this.sex = sex;
    }

    public void setWorkExperience(Date date,String company){
        workExperience.setCompany(company);
        workExperience.setWorkDate(date);
    }

    /**
     *  考虑到深拷贝和浅拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Resume clone() throws CloneNotSupportedException {
        Resume o = null;
        try {
            // Object中的clone()识别出你要复制的是哪一个对象。
            o = (Resume) super.clone();
            o.workExperience =(WorkExperience) workExperience.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return o;
    }

    public void display(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Resume{" +
            "name='" + name + '\'' +
            ", sex='" + sex + '\'' +
            ", age=" + age +
            ", workExperience=" + workExperience +
            '}';
    }
}
