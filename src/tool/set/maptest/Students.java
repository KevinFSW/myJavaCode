package tool.set.maptest;

import java.util.ArrayList;
import java.util.Scanner;

public class Students{
    String id;
    String password;

    public Students(String id, String password){
        this.id = id;
        this.password = password;
    }

    //方法 学生考试，参数是考试机和拿到的试卷
    public void takeAnExamination(ExaminationMachine examinationMachine, TestPaper testPaper){
        ArrayList<Integer> test = testPaper.getExaminationQuestionsID();
        Scanner input = new Scanner(System.in);
        while(true){
            for(int i = 0; i < test.size(); i++){
                System.out.println("第" + (i+1) + "题：");
                System.out.println(examinationMachine.getExaminationQuestions(test.get(i)));
                System.out.println("请输入答案");
                String answer = input.nextLine();
                testPaper.addAnswerToAnswerSheet(answer);
            }

            System.out.println("题目已答完，输入yes交卷，输入其他重做题目：");
            String confirm = input.nextLine();
            if(confirm.equals("yes")){
                break;
            }
        }
    }
}