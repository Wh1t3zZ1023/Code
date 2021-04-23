package com.zhongyi.www.dao;

import com.zhongyi.www.po.Course;
import com.zhongyi.www.po.Student;
import com.zhongyi.www.po.Teacher;

public interface TeacherDao {
    public Teacher login(Teacher teacher);
    public void addCourse(Course course);
    public void deleteCourse(String c_id);
    public void updateCourse(Course course);
    public void selectOneCourse(String c_id);
    public void selectAllCourse();
    public void addStu(Student student);
    public void deleteStu(String stu_id);
    public void updateStu(Student student);
    public void selectOneStu(String stu_id);
    public void selectAllStu();
}
