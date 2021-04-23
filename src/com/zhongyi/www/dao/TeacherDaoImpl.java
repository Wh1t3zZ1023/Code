package com.zhongyi.www.dao;

import com.zhongyi.www.po.Course;
import com.zhongyi.www.po.Student;
import com.zhongyi.www.po.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeacherDaoImpl implements TeacherDao {
    //管理员登陆
    @Override
    public Teacher login(Teacher teacher) {
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql="select * from t_teacher where teacher_id=? and teacher_password=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, teacher.getTeacher_id());
            ps.setString(2, teacher.getTeacher_password());
            rs=ps.executeQuery();
            Teacher teachers = null;
            if(rs.next()){
                teachers=new Teacher();
                teachers.setTeacher_id("teacher_id");
                teachers.setTeacher_password(rs.getString("teacher_password"));
                return teachers;
            }
            else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //添加课程
    @Override
    public void addCourse(Course course) {
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql="insert into course (c_id,c_name,c_teacher,c_location) values(?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, course.getC_id());
            ps.setString(2, course.getC_name());
            ps.setString(3, course.getC_teacher());
            ps.setString(4, course.getC_location());
            int a = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //删除课程
    @Override
    public void deleteCourse(String c_id) {
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql = "delete from t_course where c_id=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, c_id);
            int a=ps.executeUpdate();
            if(a>0){
                System.out.println("删除成功");
                String sql2="delete from t_stu_course where c_id=?";
                ps=con.prepareStatement(sql2);
                ps.setString(1, c_id);
                int b=ps.executeUpdate();
            }
            else{
                System.out.println("输入ID有误，删除失败");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //修改课程
    @Override
    public void updateCourse(Course course) {
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql="update t_course set c_name=?,c_teacher=?,c_location=? where c_id=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, course.getC_name());
            ps.setString(2, course.getC_teacher());
            ps.setString(3, course.getC_location());
            ps.setString(4, course.getC_id());

            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("课程修改成功");
            }
            else{
                System.out.println("输入ID有误，课程修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //查看某一课程
    @Override
    public void selectOneCourse(String c_id) {
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql ="select * from t_course where c_id=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, c_id);
            rs=ps.executeQuery();
            Course course=null;
            if(rs.next()){
                course = new Course();
                course.setC_id(rs.getString("c_id"));
                course.setC_name(rs.getString("c_name"));
                course.setC_teacher(rs.getString("c_teacher"));
                course.setC_location(rs.getString("c_location"));
                System.out.println(course.getC_id()+" "+course.getC_name()+" "+course.getC_teacher()+""+course.getC_location());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //查看全部课程
    @Override
    public void selectAllCourse() {
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql ="select * from t_course ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            Course course=null;
            while(rs.next()){
                course = new Course();
                course.setC_id(rs.getString("c_id"));
                course.setC_name(rs.getString("c_name"));
                course.setC_teacher(rs.getString("c_teacher"));
                course.setC_location(rs.getString("c_location"));
                System.out.println(course.getC_id()+" "+course.getC_name()+" "+course.getC_teacher()+""+course.getC_location());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //添加学生
    @Override
    public void addStu(Student student) {
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql="insert into t_stu (stu_id,stu_name,stu_speciality,stu_class,stu_password) values(?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, student.getStu_id());
            ps.setString(2, student.getName());
            ps.setString(3, student.getSpec());
            ps.setString(4, student.getStuClass());
            ps.setString(5, student.getPassword());

            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("学生添加成功");
            }
            else{
                System.out.println("学生添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //删除学生
    @Override
    public void deleteStu(String stu_id) {
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql = "delete from t_stu where stu_id=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, stu_id);
            int a=ps.executeUpdate();
            if(a>0){
                System.out.println("删除成功");
                String sql2="delete from t_stu_course where stu_id=?";
                ps=con.prepareStatement(sql2);
                ps.setString(1, stu_id);
                int b=ps.executeUpdate();
            }
            else{
                System.out.println("输入用户名有误，删除失败");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //修改用户
    @Override
    public void updateStu(Student student) {
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql="update t_stu set stu_name=?,stu_speciality=?,stu_class=? where stu_id=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getSpec());
            ps.setString(3, student.getStuClass());
            ps.setString(4, student.getStu_id());
            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("用户修改成功");
            }
            else{
                System.out.println("输入有误，用户修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //查看某一学生
    @Override
    public void selectOneStu(String stu_id) {
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql ="select * from t_stu where stu_id=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, stu_id);
            rs=ps.executeQuery();
            Student student=null;
            if(rs.next()){
                student = new Student();
                student.setStu_Id(rs.getString("stu_id"));
                student.setName(rs.getString("stu_name"));
                student.setSpec(rs.getString("stu_speciality"));
                student.setClass(rs.getString("stu_id"));
                System.out.println(student.getStu_id()+" "+student.getName()+""+student.getSpec()+""+student.getStuClass());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //查看全部课程
    @Override
    public void selectAllStu() {
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql ="select * from t_stu ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            Student student=null;
            while(rs.next()){
                student = new Student();
                student.setStu_Id(rs.getString("stu_id"));
                student.setName(rs.getString("stu_name"));
                student.setSpec(rs.getString("stu_speciality"));
                student.setClass(rs.getString("stu_class"));
                System.out.println(student.getStu_id()+" "+student.getName()+""+student.getSpec()+""+student.getStuClass());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

