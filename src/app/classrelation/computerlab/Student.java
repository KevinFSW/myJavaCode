package app.classrelation.computerlab;

//学生是电脑使用者的一种，也就是电脑使用者的子类
public class Student extends ComputerUser{
    //学生独有的信息
    public String grade;
    public int id;

    /**
     * 构造方法
     * @param name
     * @param grade
     * @param id 
     */
    public Student(String name, String grade, int id){
        this.name = name;
        this.grade = grade;
        this.id = id;
    }

}