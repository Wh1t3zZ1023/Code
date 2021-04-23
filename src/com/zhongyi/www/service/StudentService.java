package com.zhongyi.www.service;

import com.zhongyi.www.dao.StudentDao;
import com.zhongyi.www.dao.StudentDaoImpl;
import com.zhongyi.www.po.Student;
import com.zhongyi.www.view.StuMenu;

import java.util.Scanner;

public class StudentService {
    static Scanner sc = new Scanner(System.in);
    public void stuLogin(String stu_id,String stu_name,String stu_password){
        StudentDao dao = new StudentDaoImpl();
        Student student =new Student();
        student.setStu_Id(stu_id);
        student.setPassword(stu_password);
        dao.login(student);
        if(dao.login(student)!=null){
            System.out.println("登录成功");
            StuMenu.showMenu(stu_id,stu_name);
        }
        else{
            System.out.println("用户名或密码错误");
        }
    }

    public static void stuChangePassWord(String stu_id,String stu_name){
        StudentDao dao = new StudentDaoImpl();
        Student student =new Student();
        System.out.println("请输入新密码");
        String password = sc.nextLine();
        if(password==""||password.length()>10){
            System.exit(0);
        }
        else{
            student.setStu_Id(stu_id);
            student.setPassword(password);
            dao.changePass(student);
            System.out.println("修改密码成功，新密码为："+password);
            StuMenu.showMenu(stu_id,stu_name);
        }
    }

    public static void stuStuCourse(String stu_id,String stu_name){
        StudentDao dao = new StudentDaoImpl();
        System.out.println("_________________________");
        System.out.println("已选课程为：");
        dao.getStuCourse(stu_id);
        StuMenu.showMenu(stu_id,stu_name);
    }

    public static void stuDeleteCourse(String stu_id,String stu_name){
        StudentDao dao = new StudentDaoImpl();
        System.out.println("_________________________");
        System.out.println("想要删除的课程ID为：");
        String c_id=sc.nextLine();
        dao.deleteCourse(stu_id, c_id);
        StuMenu.showMenu(stu_id,stu_name);
    }

    public static void stuAvaCourse(String stu_id,String stu_name){
        StudentDao dao = new StudentDaoImpl();
        System.out.println("_________________________");
        System.out.println("可选课程为：");
        dao.getAvaCourse(stu_id);
        StuMenu.showMenu(stu_id,stu_name);
    }

    public static void stuChooseCourse(String stu_id,String stu_name){
        StudentDao dao = new StudentDaoImpl();
        System.out.println("_________________________");
        System.out.println("想要选择的课程ID为：");
        String c_id=sc.nextLine();
        dao.chooseCourse(stu_id,stu_name,c_id);
        StuMenu.showMenu(stu_id,stu_name);
    }
}

