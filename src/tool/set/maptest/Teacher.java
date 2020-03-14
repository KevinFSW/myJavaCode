package tool.set.maptest;

import java.util.ArrayList;
import java.util.Scanner;

public class Teacher {
    String id;
    String password;

    public Teacher(String id, String password){
        this.id = id;
        this.password = password;
    }

    /**
     * 老师人工批改试卷
     * @param examinationMachine
     * @param testPaper
     * @return
     */
    public int teacherCorrectTestPaper(ExaminationMachine examinationMachine, TestPaper testPaper){
        ArrayList<Integer> test = testPaper.getExaminationQuestionsID();
        Scanner input = new Scanner(System.in);
        System.out.println("题目是：");
        for (int i = 0; i < test.size(); i++) {
            System.out.println(examinationMachine.getExaminationQuestions(test.get(i)));
        }

        ArrayList<String> answer = testPaper.getAnswerSheet();
        System.out.println("学生的答案是：");
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i));
        }
        System.out.println();

        System.out.println("请输入学生的成绩：");
        int score = input.nextInt();

        return score;
    }
}