package com.sery.labmon.model;

/**
 * Created by LuDan on 2018/6/21 14:20
 */
public class Student {
    private Integer id;
    private String name;
    private String s_class;
    private String sex;
    private String description;

    public Student(Integer id, String name, String s_class, String sex, String description) {
        this.id = id;
        this.name = name;
        this.s_class = s_class;
        this.sex = sex;
        this.description = description;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getS_class() {
        return s_class;
    }

    public void setS_class(String s_class) {
        this.s_class = s_class;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", s_class='" + s_class + '\'' +
                ", sex='" + sex + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
