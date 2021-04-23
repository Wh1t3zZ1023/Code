package com.zhongyi.www.view;

import com.zhongyi.www.service.StudentService;
import com.zhongyi.www.service.TeacherService;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎使用选课系统");
        System.out.println("请输入登录名：");
        String id = sc.nextLine();
        System.out.println("请输入您的名字");
        String name = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        System.out.println("请选择您的身份");
        System.out.println("1.教师");
        System.out.println("2.学生");
        int a = sc.nextInt();
        switch(a){
            case 1:
                new TeacherService().tLogin(id, password);
                break;
            case 2:

                new StudentService().stuLogin(id,name,password);
                break;
             default:
                 System.out.println("输入数字不合法，程序退出");
                 System.exit(0);
        }
    }
}
