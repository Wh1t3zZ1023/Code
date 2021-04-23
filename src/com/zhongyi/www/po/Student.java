package com.zhongyi.www.po;

public class Student {
    private String stu_id;
    private String stu_name;
    private String stu_spec;
    private String stu_class;
    private String stu_password;

    public Student(String stu_id, String stu_name, String stu_spec, String stu_class, String stu_password) {
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.stu_spec = stu_spec;
        this.stu_class = stu_class;
        this.stu_password = stu_password;
    }

    public Student() {
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_Id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getName() {
        return stu_name;
    }

    public void setName(String name) {
        this.stu_name = name;
    }

    public String getSpec() {
        return stu_spec;
    }

    public void setSpec(String spec) {
        this.stu_spec = spec;
    }

    public String getStuClass() {
        return stu_class;
    }

    public void setClass(String aClass) {
        stu_class = aClass;
    }

    public String getPassword() {
        return stu_password;
    }

    public void setPassword(String password) {
        this.stu_password = password;
    }
}
