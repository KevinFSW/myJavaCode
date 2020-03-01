/**
 * Edit and run with VSCode, default encoding: UTF-8
 */

package app;

import app.operation.*;
import app.syntactic.*;

import java.lang.invoke.StringConcatException;
import java.util.Scanner;

import app.array.*;
import app.arraybox.IntArrayBox;
import app.arraybox.StringArrayBox;
import app.classrelation.car.Car;
import app.classrelation.car.Wheel;
import app.classrelation.computerlab.ComputerLab;
import app.classrelation.computerlab.Student;
import app.classrelation.killpig.*;
import app.object.arrayopt.*;
import app.object.drawstar.*;

public class App {

    private static Scanner input;
    public static void main(String[] args) throws Exception {
        /*
        OperationalSymbol.test0();
        OperationalSymbol.test1();
        OperationalSymbol.test2();
        OperationalSymbol.test3();
        */
        /*
        SyntacticStructure.test0();
        SyntacticStructure.test1();
        SyntacticStructure.test2();
        SyntacticStructure.test3();
        SyntacticStructure.test4();
        SyntacticStructure.test5();
        SyntacticStructure.test6();
        SyntacticStructure.test7();
        SyntacticStructure.test8();
        SyntacticStructure.test9();
        SyntacticStructure.test10();
        SyntacticStructure.test11();
        SyntacticStructure.test12();
        SyntacticStructure.test13();
        SyntacticStructure.test14();
        SyntacticStructure.test15();
        SyntacticStructure.test16();
        */
        /*
        Array array = new Array();
        array.testArrayInit();
        array.exchangeTwoArrayValue();
        array.exchangeArrayHeadTail();
        array.getArrayAverageValue();
        array.getArrayMaxAndMin();
        array.deleteArrayZeroElement();
        array.arrayCombine();
        array.arraySorted();
        array.userSignAndLogin();
        array.arrayCutByMax();
        */
        /*
        DrawStar drawStar = new DrawStar();
        drawStar.starDrawHandstandRightTriangle(3, '*', false);
        */
        /*
        ArrayOpt arrayOpt = new ArrayOpt();
        int[] array0 = {0,1,2,3,4};
        int[] array1 = {5,6,7,8,9};
        int[] array2 = {10,1,3,0,9,5,4,10,10,2,10,3,10};
        int[] array3 = {0,1,2,3,4,5,6,7,8,9};
        int[] arrayOutput;
        int[][] arrayOutput2;
        
        arrayOpt.setResultOutputEnable(true);
        arrayOutput = arrayOpt.findInArray(array2, 10);
        if(arrayOutput != null){
            System.out.println("找到这个元素的索引如下：");
            arrayOpt.outputArray(arrayOutput);
        }
        else{
            System.out.println("找不到这个元素");
        }
        
        //arrayOpt.setResultOutputEnable(true);
        arrayOutput2 = arrayOpt.exchangeTwoArrayValue(array0, array1);
        array0 = arrayOutput2[0];
        array1 = arrayOutput2[1];
        arrayOpt.outputArray(array0);
        arrayOpt.outputArray(array1);
        */
        /* 
        arrayOpt.setResultOutputEnable(true);
        arrayOutput = arrayOpt.findPrimeInArray(1, 50);
        if(arrayOutput != null){
            arrayOpt.outputArray(arrayOutput);
        }
        else{
            System.out.println("输入有误或没有找到素数");
        }
        */
        /*
        arrayOutput = arrayOpt.arrayCombine(array0, array1);
        arrayOpt.arrayCutByMax(array2);
        arrayOpt.arraySorted(array2, true);
        arrayOpt.deleteElementFromArray(array2, 0);
        arrayOpt.exchangeArrayHeadTail(array3);
        arrayOpt.exchangeTwoArrayValue(array0, array1);
        arrayOpt.getArrayMaxAndMin(array2);
        arrayOpt.userSignAndLogin();
        */
        /*
        arrayOpt.outputArray(array0);
        arrayOpt.outputArray(array1);
        arrayOpt.outputArray(array2);
        arrayOpt.outputArray(array3);
        */
        /*
        StringArrayBox arrayBox = new StringArrayBox();
        
        for (int i = 0; i < 10; i++) {
            arrayBox.add("i" + i);
            System.out.println("size:" + arrayBox.size());
        }

        for (int i = 0; i < arrayBox.size(); i++) {
            System.out.println("element:" + arrayBox.get(i));
        }

        arrayBox.remove(7);
        System.out.println("size:" + arrayBox.size());

        for (int i = 0; i < arrayBox.size(); i++) {
            System.out.println("element:" + arrayBox.get(i));
        }

        for (int i = 0; i < 10; i++) {
            arrayBox.add("i" + 2);
            System.out.println("size:" + arrayBox.size());
        }

        for (int i = 0; i < arrayBox.size(); i++) {
            System.out.println("element:" + arrayBox.get(i));
        }
        */
        /*
        Farmer farmer = new Farmer();
        Scanner input = new Scanner(System.in);
        PigKiller pigKiller = new PigKiller();
        System.out.println("农民要买猪仔了，你有什么猪？");
        String type = input.nextLine();
        farmer.farmerBuyPig(type);
        System.out.println("农民买了一头" + type);
        while(true){
            System.out.println("要喂猪了，喂几个月？");
            int month = input.nextInt();
            for (int i = 0; i < month; i++) {
                farmer.farmerFeedPig();
            }

            if(pigKiller.pigKillerBuyPig(farmer.farmerSellPig())){
                break;
            }
        }
        pigKiller.pigKillerKillPig();
        */
        /*
        Car car = new Car();
        Wheel wheel = new Wheel("kkk", 10, "black");
        car.carRepair(wheel);
        */

        ComputerLab computerLab = new ComputerLab();
        //Student student = new Student("name", "grade", 0);
        Student[] students = new Student[8];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student("name" + i, "grade 3", i);
        } 

        input = new Scanner(System.in);

        System.out.println("一共有" + students.length + "个学生");

        while(true){
            System.out.println("你想让谁来上机？请输入学生的序号，输入q退出");
            String sid = input.nextLine();
            if(sid.equals("q")){
                break;
            }
            int id = Integer.parseInt(sid);

            userDefineLoop(computerLab, students, id);
        }

        //computerLab.allowUserToFinishUsingComputer(student);
    }

    /**
     * 递归
     * @param computerLab
     * @param students
     * @param param
     */
    private static void userDefineLoop(ComputerLab computerLab, Student[] students, int param){
        int ret = computerLab.acceptUserToUseComputer(students[param]);
        if(ret == 1){
            System.out.println(param + "号学生上机成功");
        }
        else{
            System.out.println(param + "号学生上机失败");
            if(ret == -1){
                System.out.println("没有空闲的电脑了");
                System.out.println("需要谁下机空出电脑吗？是请输入学生的序号，否则输入q");
                String sid = input.nextLine();
                if(sid.equals("q")){
                    return;//返回
                }

                int id = Integer.parseInt(sid);
                //让这个学生下机
                if(!computerLab.allowUserToFinishUsingComputer(students[id])){
                    System.out.println(id + "号学生没有在上机");
                }

                userDefineLoop(computerLab, students, param);//继续让新来的上机
            }
            else if(ret == -2){
                System.out.println(param + "号学生已经在上机了");
            }
        }
    }
}