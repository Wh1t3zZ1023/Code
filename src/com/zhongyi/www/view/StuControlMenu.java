package com.zhongyi.www.view;

import com.zhongyi.www.service.TeacherService;

import java.util.Scanner;

public class StuControlMenu {
    public static void ShowMenu(){
         Scanner sc = new Scanner(System.in);
         System.out.println("_________________________");
         System.out.println("    1.学生新增");
         System.out.println("    2.学生查看");
         System.out.println("    3.学生删除");
         System.out.println("    4.学生修改");
         System.out.println("_________________________");
         int a =sc.nextInt();
         switch(a){
             case 1:
                 TeacherService.tAddStudent();
                 break;
             case 2:
                 StuLookMenu.ShowMenu();
                 break;
             case 3:
                 TeacherService.tDeleteStu();
                 break;
             case 4:
                 TeacherService.tDeleteStu();
                 break;
             default:
                 System.out.println("输入数字不合法，程序退出");
                 System.exit(0);
         }
     }
}
