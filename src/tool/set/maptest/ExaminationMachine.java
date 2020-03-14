package tool.set.maptest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * 考试系统：
 * 具备的属性
 *     1.保存学生的ID和密码的集合，私有的
 *     2.保存老师的ID和密码的集合，私有的
 *     3.保存题库的集合，私有的
 *     4.保存当前登录的学生id的变量，私有的
 * 具备的方法
 *     1.管理系统，用于修改集合内容
 *     2.登录系统，包括学生的和老师的，
 *         老师登录能修改学生的信息，也就是决定谁能参加考试
 *         学生登录只能是参加考试
 *     3.考试系统，提供题目给学生进行考试，以及对学生的试卷进行机器打分
 */

public class ExaminationMachine{

    /** 
     * 内部类：包装题目及其答案，便于存储
     */
    private class Questions{
        String question;
        String answer;

        public Questions(String question, String answer){
            this.question = question;
            this.answer = answer;
        }

        public String getQuestion(){
            return this.question;
        }

        public String getAnswer(){
            return this.answer;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{");
            builder.append(this.question);
            builder.append("    ");
            builder.append(this.answer);
            builder.append("}");
            return builder.toString();
        }

        /**
         * 重写便于存入HashSet
         */
        @Override
        public boolean equals(Object o){
            if(o == this){
                return true;
            }
    
            if(o instanceof Questions){
                Questions temp = (Questions)o;
                String[] ttcTemp = temp.getQuestion().split("\r\n");//只比较题目，不比较选项，因为选项可以是一样的
                String[] ttcThis = this.getQuestion().split("\r\n");
                if(!ttcTemp[0].equals(ttcThis[0])){
                    return false;
                }
    
                return true;
            }
    
            return false;
        }
    
        /**
         * 重写便于存入HashSet
         */
        @Override
        public int hashCode(){
            String[] ttcThis = this.getQuestion().split("\r\n");
            return ttcThis[0].hashCode();//只获取题目的hashCode，不获取选项，因为选项可以是一样的
        }    

    }

    /**
     * 属性：保存学生的ID和密码
     */
    private HashMap<String, String> studentData = new HashMap<>();

    /**
     * 属性：保存老师的ID和密码 
     */  
    private HashMap<String, String> teacherData = new HashMap<>();

    /**
     * 属性：保存题库
     */
    private HashSet<Questions> examinationQuestions = new HashSet<>();

    /**
     * 属性：当前登录的学生id
     */
    private String currStudentID;

    /**
     * 程序块：初始化的一个老师的ID和密码
     * 管理系统
     */
    {        
        teacherData.put("0", "0000");
    }

    /**
     * 私有方法：初始化初版题库
     * 管理系统
     */
    private void initExaminationQuestions(){
        addExaminationQuestions(new Questions("value1\r\nchoice", "a"));
        addExaminationQuestions(new Questions("value2\r\nchoice", "b"));
        addExaminationQuestions(new Questions("value3\r\nchoice", "c"));
        addExaminationQuestions(new Questions("value4\r\nchoice", "a"));
        addExaminationQuestions(new Questions("value5\r\nchoice", "b"));
        addExaminationQuestions(new Questions("value6\r\nchoice", "a"));
        addExaminationQuestions(new Questions("value7\r\nchoice", "b"));
        addExaminationQuestions(new Questions("value8\r\nchoice", "b"));
        addExaminationQuestions(new Questions("value9\r\nchoice", "c"));
        addExaminationQuestions(new Questions("value10\r\nchoice", "c"));
        addExaminationQuestions(new Questions("value11\r\nchoice", "b"));
        addExaminationQuestions(new Questions("value12\r\nchoice", "c"));

        //System.out.println(examinationQuestions);
    }

    /**
     * 私有方法：往题库里面添加题目
     * 管理系统
     * @param questions
     * @return
     */
    private boolean addExaminationQuestions(Questions questions){
        return this.examinationQuestions.add(questions);
    }

    /**
     * 私有方法：操作数据库，添加或删除学生数据
     * 管理系统
     * @param input
     * @param mode
     */
    private void addOrRemoveStudentData(Scanner input, int mode){
        while(true){
            System.out.println("请输入学生的ID，或输入q退出：");
            String ids = input.nextLine();
            if(ids.equals("q")){
                break;
            }

            try {
                Integer.parseInt(ids);//限制只能是数字
            } catch (Exception e) {
                System.out.println("输入格式错误");
                continue;
            }

            if(mode == 1){ //添加或修改学生信息
                System.out.println("请输入学生的密码，或输入q退出：");
                String passwd = input.nextLine();
                if(passwd.equals("q")){
                    break;
                }
    
                studentData.put(ids, passwd);
                System.out.println(ids + "添加成功");
            }
            else{ //删除学生信息
                if(studentData.remove(ids) != null){
                    System.out.println(ids + "删除成功");                    
                }
                else{
                    System.out.println("没有这个ID");
                }
            }
        }
    }

    /**
     * 方法：老师登录系统，添加或删除学生信息
     * 登录系统
     * @param ID
     * @param passWord
     * @return
     */
    public boolean teacherLoginSystem(String ID, String passWord){
        if(teacherData.get(ID) != null && 
            teacherData.get(ID).equals(passWord)){
            Scanner input = new Scanner(System.in);
            while(true){
                System.out.println("添加学生输入1，删除学生输入2，输入q退出");
                String md = input.nextLine();
                if(md.equals("q")){
                    break;
                }

                try {
                    int mode = Integer.parseInt(md);
                    if(mode != 1 && mode != 2){
                        System.out.println("没有这个选项，请重新输入");
                        continue;
                    }
                    addOrRemoveStudentData(input, mode);
                } catch (Exception e) {
                    System.out.println("输入错误，请重新输入");
                    continue;
                }
            }

            return true;
        }

        return false;
    }

    /**
     * 方法：学生登录系统 输入学生的ID和密码 登录成功后生成试卷
     * 登录系统
     * @param ID
     * @param passWord
     * @return
     */
    public TestPaper studentLoginSystem(String ID, String passWord){
        if(this.studentData.get(ID) != null && 
            this.studentData.get(ID).equals(passWord)){
            this.currStudentID = ID;//记录学生的ID，批改试卷会核查
            this.initExaminationQuestions();
            return this.generateTestPaper();
        }

        return null;
    }

    /**
     * 私有方法：生成试卷
     * 考试系统
     * @return
     */
    private TestPaper generateTestPaper(){
        TestPaper testPaper = new TestPaper();
        Random random = new Random();
        for (int i = 0; i < testPaper.getQuestionsNum(); ) {
            int id = random.nextInt(this.examinationQuestions.size());//获取随机数，也就是第几道题
            if(testPaper.addExaminationQuestionsID(id) == false){ //试卷里面已经有这道题了，重新获取随机数
                continue;
            }
            i++;
        }
        return testPaper;
    }

    /**
     * 方法：通过题目的实际题号从题库里取出题目用于展示
     * 考试系统
     * @param id
     * @return
     */
    public String getExaminationQuestions(int id){
        Questions[] questions = new Questions[this.examinationQuestions.size()]; 
        questions = this.examinationQuestions.toArray(questions); //把题库转成数组
        return questions[id].getQuestion(); //根据题目的实际题号，也就是生成试卷的随机数，来获取题目文本
    }

    /**
     * 私有方法：通过题目的实际题号从题库里取出答案用于统计分数
     * 考试系统
     * @param id
     * @return
     */
    private String getExaminationAnswer(int id){
        Questions[] questions = new Questions[this.examinationQuestions.size()];
        questions = this.examinationQuestions.toArray(questions);
        return questions[id].getAnswer();//这里是获取答案
    }

    /**
     * 方法：考试机检查学生提交的试卷，实现自动批改
     * 考试系统
     * @param students
     * @param testPaper
     * @return
     */
    public int correctTestPaper(Students students, TestPaper testPaper){
        if(this.currStudentID == students.id){ //检查这个学生有没有登录
            ArrayList<Integer> questionsIDs = testPaper.getExaminationQuestionsID(); //试卷上的题目的题号
            ArrayList<String> studentAnswers = testPaper.getAnswerSheet(); //学生的答案
            int scoreOfEachQ = 100/questionsIDs.size();
            int score = 0;
            for (int i = 0; i < questionsIDs.size(); i++) {
                if(studentAnswers.get(i).equals(getExaminationAnswer(questionsIDs.get(i)))){ //通过题目获取答案，跟学生的对比，计算得分
                    score += scoreOfEachQ;
                }
            }
            return score;
        }
        
        return -1;//没登录返回-1
    }
    
}