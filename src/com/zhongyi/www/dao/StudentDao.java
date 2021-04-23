package com.zhongyi.www.dao;

import com.zhongyi.www.po.Student;

public interface StudentDao {

        public Student login(Student stu);
        public void changePass(Student stu);
        public void getStuCourse(String stu_id);
        public void getAvaCourse(String stu_id);
        public void chooseCourse(String stu_id,String stu_name,String c_id);
        public void deleteCourse(String stu_id,String c_id);

}
