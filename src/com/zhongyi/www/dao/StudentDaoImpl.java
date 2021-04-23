package com.zhongyi.www.dao;

import com.zhongyi.www.po.Course;
import com.zhongyi.www.po.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public  class StudentDaoImpl implements StudentDao {

    //学生登陆
    @Override
    public Student login(Student stu) {
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql="select * from t_stu where stu_id=? and stu_password=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, stu.getStu_id());
            ps.setString(2, stu.getPassword());
            rs=ps.executeQuery();
            Student student =null;
            if(rs.next()){
                student = new Student();
                //从数据库中获取值设置到实体类的setter方法中
                student.setStu_Id(rs.getString("stu_id"));
                student.setPassword(rs.getString("stu_password"));
                return student;
            }else{
                return null;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //更改密码
    @Override
    public void changePass(Student stu) {
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql = "update t_stu set stu_password=? where stu_id=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, stu.getPassword());
            ps.setString(2, stu.getStu_id());
            int a =ps.executeUpdate();
        }    catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void getStuCourse(String stu_id) {
        //查询已选课程
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql ="select * from t_course where c_id in (select c_id from t_stu_course where stu_id=?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, stu_id);
            rs=ps.executeQuery();
            while (rs.next()) {
                //System.out.println(6);
                Course course = new Course();
                course.setC_id(rs.getString("c_id"));
                course.setC_name(rs.getString("c_name"));
                course.setC_teacher(rs.getString("c_teacher"));
                course.setC_location(rs.getString("c_location"));
                System.out.println(course.getC_id()+" "+course.getC_name()+" "+course.getC_teacher()+" "+course.getC_location());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //查询可选课程
    @Override
    public void getAvaCourse(String stu_id) {
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql = "select * from t_course where c_id not in (select c_id from t_stu_course where stu_id=?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, stu_id);
            rs=ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setC_id(rs.getString("c_id"));
                course.setC_name(rs.getString("c_name"));
                course.setC_teacher(rs.getString("c_teacher"));
                System.out.println(course.getC_id()+" "+course.getC_name()+" "+course.getC_teacher()+" "+course.getC_location());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //选择课程
    @Override
    public void chooseCourse(String stu_id,String stu_name, String c_id) {
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql ="insert into t_stu_course (stu_id,stu_name,c_id) values(?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, stu_id);
            ps.setString(2, stu_name);
            ps.setString(3, c_id);
            int a =ps.executeUpdate();
            if(a>0){
                System.out.println("选课成功");
            }
            else{
                System.out.println("输入ID有误，选课失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //删除选课
    @Override
    public void deleteCourse(String stu_id, String c_id) {
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql="delete from t_stu_course where stu_id=? and c_id=? ";
            ps=con.prepareStatement(sql);
            ps.setString(1, stu_id);
            ps.setString(2, c_id);
            int a =ps.executeUpdate();
            if(a>0){
                System.out.println("删除成功");
            }
            else{
                System.out.println("输入ID有误，删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
