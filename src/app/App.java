/**
 * Edit and run with VSCode, default encoding: UTF-8
 */

package app;

import app.OperationalSymbol.*;
import app.SyntacticStructure.*;
import app.Array.*;
import app.ObjectOriented.ArrayOptClass.*;
import app.ObjectOriented.DrawStar.*;

public class App {
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
        ArrayOpt arrayOpt = new ArrayOpt();
        int[] array0 = {0,1,2,3,4};
        int[] array1 = {5,6,7,8,9};
        int[] array2 = {10,1,3,0,9,5,4,10,10,2,10,3,10};
        int[] array3 = {0,1,2,3,4,5,6,7,8,9};
        int[] arrayOutput;
        int[][] arrayOutut2;
        arrayOutput = arrayOpt.findInArray(array2, 13);
        if(arrayOutput != null)
            arrayOpt.outputArray(arrayOutput);
        else
            System.out.println("llllllllllll");
        /*
        arrayOpt.setResultOutputEnable(true);
        arrayOpt.exchangeTwoArrayValue(array0, array1);
        arrayOpt.outputArray(array0);
        arrayOpt.outputArray(array1);
        */
        /*
        arrayOutput = arrayOpt.arrayCombine(array0, array1);
        arrayOpt.arrayCutByMax(array2);
        arrayOpt.arraySorted(array2);
        arrayOpt.deleteArrayZeroElement(array2);
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
    }
}