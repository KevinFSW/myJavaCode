package tool.set.maptest;

import java.util.ArrayList;

public class TestPaper{

    //试卷属性，存放题目的编号(考试时通过编号从考试机的数据库里面拿题目)
    private ArrayList<Integer> examinationQuestionsID = new ArrayList<>();

    //答题卡
    private ArrayList<String> answerSheet = new ArrayList<>();

    //试卷的题数
    private int questionsNum;

    public TestPaper(){
        this.questionsNum = 10;
    }

    public TestPaper(int questionsNum){
        this.questionsNum = questionsNum;
    }
    
    //往试卷里添加题目
    public boolean addExaminationQuestionsID(int id){
        boolean ret = this.examinationQuestionsID.contains(id);
        if(ret){
            return false;
        }
        return this.examinationQuestionsID.add(id);
    }

    //得到试卷
    public ArrayList<Integer> getExaminationQuestionsID(){
        return this.examinationQuestionsID;
    }

    //填写答题卡
    public void addAnswerToAnswerSheet(String as){
        this.answerSheet.add(as);
    }

    //提交答题卡
    public ArrayList<String> getAnswerSheet(){
        return this.answerSheet;
    }

    public int getQuestionsNum(){
        return this.questionsNum;
    }
    
}