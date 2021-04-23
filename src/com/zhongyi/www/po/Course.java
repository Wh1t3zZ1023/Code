package com.zhongyi.www.po;

public class Course {
    private String c_id;
    private String c_name;
    private String c_teacher;
    private String c_location;

    public Course(String c_id, String c_name, String c_teacher, String c_location) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_teacher = c_teacher;
        this.c_location = c_location;
    }

    public Course() {
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_teacher() {
        return c_teacher;
    }

    public void setC_teacher(String c_teacher) {
        this.c_teacher = c_teacher;
    }

    public String getC_location() {
        return c_location;
    }

    public void setC_location(String c_location) {
        this.c_location = c_location;
    }
}
