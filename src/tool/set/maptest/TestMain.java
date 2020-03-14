package tool.set.maptest;

import java.util.Scanner;

public class TestMain{
    public static void main(String[] args) {
        Teacher teacher = new Teacher("0", "0000");
        ExaminationMachine examinationMachine = new ExaminationMachine();
        while(true){
            System.out.println("教师登录配置请输入1，学生登录考试请输入2，退出请输入q");
            Scanner input = new Scanner(System.in);
            String choose = input.nextLine();
            if(choose.equals("q")){
                break;
            }
            try {
                int mode = Integer.parseInt(choose);
                if(mode != 1 && mode != 2){
                    System.out.println("输入错误！请重新输入");
                    continue;
                }
                if(mode == 1){
                    System.out.println("请输入ID:");
                    String id = input.nextLine();
                    System.out.println("请输入密码:");
                    String password = input.nextLine();
                    if(examinationMachine.teacherLoginSystem(id, password) == false){
                        System.out.println("ID或密码错误！");
                    }
                }
                else{
                    System.out.println("请输入ID:");
                    String id = input.nextLine();
                    System.out.println("请输入密码:");
                    String password = input.nextLine();
                    TestPaper testPaper = examinationMachine.studentLoginSystem(id, password);
                    if(testPaper != null){
                        Students student = new Students(id, password);
                        student.takeAnExamination(examinationMachine, testPaper);
                        //int score = teacher.teacherCorrectTestPaper(examinationMachine, testPaper);
                        int score = examinationMachine.correctTestPaper(student, testPaper);
                        System.out.println(id + "考了" + score + "分");
                    }
                    else{
                        System.out.println("ID或密码错误！");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("输入错误！请重新输入");
            }
        }
    }
}