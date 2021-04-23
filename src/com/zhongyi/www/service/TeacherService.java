package com.zhongyi.www.service;

import com.zhongyi.www.dao.TeacherDao;
import com.zhongyi.www.dao.TeacherDaoImpl;
import com.zhongyi.www.po.Course;
import com.zhongyi.www.po.Student;
import com.zhongyi.www.po.Teacher;
import com.zhongyi.www.view.TeacherMenu;

import java.util.Scanner;

public class TeacherService {
    static Scanner sc = new Scanner(System.in);
    //管理员登录
    public void tLogin(String teacher_id,String teacher_password){
        TeacherDao dao = new TeacherDaoImpl();
        Teacher teacher = new Teacher();
        teacher.setTeacher_id(teacher_id);
        teacher.setTeacher_password(teacher_password);
        dao.login(teacher);
        if(dao.login(teacher)!=null){
            System.out.println("登录成功");
            TeacherMenu.ShowMenu();
        }
        else{
            System.out.println("用户名或密码错误");
        }
    }
    //添加课程
    public static void tAddCourse(){
        TeacherDao dao = new TeacherDaoImpl();
        Course course=new Course();
        System.out.println("请输入要填加的课程ID：");
        course.setC_id(sc.nextLine());
        System.out.println("请输入要填加的课程名：");
        course.setC_name(sc.nextLine());
        System.out.println("请输入要填加的课程教师：");
        course.setC_teacher(sc.nextLine());
        System.out.println("请输入上课地点：");
        course.setC_location(sc.nextLine());
        dao.addCourse(course);
        TeacherMenu.ShowMenu();
    }
    //删除课程
    public static void tDeleteCourse(){
        TeacherDao dao = new TeacherDaoImpl();
        System.out.println("请输入要删除的课程ID：");
        String c_id = sc.nextLine();
        dao.deleteCourse(c_id);
        TeacherMenu.ShowMenu();
    }
    //修改课程
    public static void tUpdateCourse(){
        TeacherDao dao = new TeacherDaoImpl();
        Course course=new Course();
        System.out.println("请输入要修改的课程ID：");
        course.setC_id(sc.nextLine());
        System.out.println("请输入修改后的课程名：");
        course.setC_name(sc.nextLine());
        System.out.println("请输入修改后的课程教师：");
        course.setC_teacher(sc.nextLine());
        System.out.println("请输入修改后的上课地址：");
        course.setC_location(sc.nextLine());
        dao.updateCourse(course);
        TeacherMenu.ShowMenu();
    }
    //查看某一课程
    public static void tOneCourse(){
        TeacherDao dao = new TeacherDaoImpl();
        System.out.println("请输入要查看的课程ID：");
        String c_id=sc.nextLine();
        dao.selectOneCourse(c_id);
        TeacherMenu.ShowMenu();
    }
    //查看全部课程
    public static void tAllCourse(){
        TeacherDao dao = new TeacherDaoImpl();
        System.out.println("已有课程如下：");
        dao.selectAllCourse();
        TeacherMenu.ShowMenu();
    }
    //添加学生
    public static void tAddStudent(){
        TeacherDao dao = new TeacherDaoImpl();
        Student student = new Student();
        System.out.println("请输入要填加的学生用户名：");
        student.setStu_Id(sc.nextLine());
        System.out.println("请输入要填加学生的名字：");
        student.setName(sc.nextLine());
        System.out.println("请输入要填加学生的专业：");
        student.setSpec(sc.nextLine());
        System.out.println("请输入要填加学生的班级：");
        student.setClass(sc.nextLine());
        System.out.println("请输入密码：");
        student.setPassword(sc.nextLine());
        dao.addStu(student);
        TeacherMenu.ShowMenu();
    }
    //删除学生
    public static void tDeleteStu(){
        TeacherDao dao = new TeacherDaoImpl();
        System.out.println("请输入要删除的用户名：");
        String stu_id = sc.nextLine();
        dao.deleteStu(stu_id);
        TeacherMenu.ShowMenu();
    }
    //修改学生
    public static void tUpdateStu(){
        TeacherDao dao = new TeacherDaoImpl();
        Student student = new Student();
        System.out.println("请输入要修改的学生用户名：");
        student.setStu_Id(sc.nextLine());
        System.out.println("请输入要修改的学生姓名：");
        student.setName(sc.nextLine());
        System.out.println("请输入要修改的学生专业：");
        student.setSpec(sc.nextLine());
        System.out.println("请输入要修改的学生班级：");
        student.setClass(sc.nextLine());
        System.out.println("请输入修改后的密码：");
        student.setPassword(sc.nextLine());
        student.setPassword(sc.nextLine());
        dao.updateStu(student);
        TeacherMenu.ShowMenu();
    }
    //查看某一学生
    public static void tOneStu(){
        TeacherDao dao = new TeacherDaoImpl();
        System.out.println("请输入要查看的用户名：");
        String stu_id=sc.nextLine();
        dao.selectOneStu(stu_id);
        TeacherMenu.ShowMenu();
    }
    //查看全部学生
    public static void tAllStu(){
        TeacherDao dao = new TeacherDaoImpl();
        System.out.println("已有学生信息如下：");
        dao.selectAllStu();
        TeacherMenu.ShowMenu();
    }
}
