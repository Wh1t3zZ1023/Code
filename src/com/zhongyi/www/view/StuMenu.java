package com.zhongyi.www.view;

import com.zhongyi.www.service.StudentService;

import java.util.Scanner;
 /**
  * 学生界面
  */
 public class StuMenu {
     public static void showMenu(String stu_id,String stu_name){
         Scanner sc = new Scanner(System.in);
         System.out.println("_________________________");
         System.out.println("      欢迎"+stu_name+"使用VTMER课程系统         ");
         System.out.println("    1.修改学生密码");
         System.out.println("    2.查看已选课程");
         System.out.println("    3.选择可选课程");
         System.out.println("    4.查看可选课程");
         System.out.println("    5.删除已选课程");
         System.out.println("    6.退出选课系统");
         System.out.println("_________________________");
         int a = sc.nextInt();
         switch(a){
             case 1:
                 StudentService.stuChangePassWord(stu_id,stu_name);
                break;
             case 2:  StudentService.stuStuCourse(stu_id,stu_name);
                break;
             case 3:  StudentService.stuChooseCourse(stu_id,stu_name);
                break;
             case 4:  StudentService.stuAvaCourse(stu_id,stu_name);
                break;
             case 5:  StudentService.stuDeleteCourse(stu_id,stu_name);
                break;
             case 6:  System.out.println("用户成功退出！");
                System.exit(0);
                break;
             default:
                System.out.println("输入数字不合法，程序退出");
                System.exit(0);
         }
     }
 }
