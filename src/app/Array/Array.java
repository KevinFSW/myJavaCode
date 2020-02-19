package app.Array;

import java.util.Scanner;

public class Array{
    /**
     * 数组初始化练习
     */
    public void testArrayInit(){
        /**
         * 静态初始化
         */
        int[] array0 = new int[]{0,1,2,3,4,5,6,7,8,9};
        int[] array1 = {9,8,7,6,5,4,3,2,1,0}; 
        /**********************************************
         * 以下三种初始化都是正确可用的
        //int[] array1 = {0,1,2,3,4,5,6,7,8,9};
        //int array1[] = {0,1,2,3,4,5,6,7,8,9};
        //int [] array1 = {0,1,2,3,4,5,6,7,8,9}; 
        ***********************************************/

        /**
         * 动态初始化
         */
        int[] array3 = new int[10];
    }
    
    /**
     * 数组练习，两个数组的值对应互换
     */
    public void exchangeTwoArrayValue(){
        int[] array0 = {0,1,2,3,4};
        int[] array1 = {5,6,7,8,9};

        for(int i = 0; i < array0.length; i++)
        {
            /**
             * 值互换，用异或的方法
             */
            array0[i] = array0[i]^array1[i];
            array1[i] = array0[i]^array1[i];
            array0[i] = array0[i]^array1[i];
        }

        for (int i : array0) {
            System.out.print(i+ ",");
        }
        System.out.println();

        for (int i : array1) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    /**
     * 数组练习，将一个数组的头尾值互换
     */
    public void exchangeArrayHeadTail(){
        int[] array = {0,1,2,3,4,5,6,7,8};

        for(int i = 0; i < array.length/2; i++)//遍历一半即可
        {
            /**
             * 值互换，用异或的方法
             * i 顺数第i个， (array.length - 1 - i)倒数第i个
             */
            array[i] = array[i]^array[array.length - 1 - i];
            array[array.length - 1 - i] = array[i]^array[array.length - 1 - i];
            array[i] = array[i]^array[array.length - 1 - i];
        }

        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    /**
     * 数组练习，计算数组平均值
     */
    public void getArrayAverageValue(){
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        double averageValue = 0;

        for (int i = 0; i < array.length; i++) {
            averageValue += array[i];
        }

        averageValue /= array.length;

        System.out.print("数组：\n{");
        for (int i : array) {
            System.out.print(i + ",");
        }

        System.out.println("}\n的平均值是" + averageValue);
    }

    /**
     * 数组练习，寻找数组的最大最小值
     */
    public void getArrayMaxAndMin(){
        int[] array = {1,5,3,4,8,5,7,4};
        int max = array[0];//配置初始值
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if(array[i] > max)//大过就填入替换
            {
                max = array[i];
            }

            if(array[i] < min)//小过就填入替换
            {
                min = array[i];
            }
        }

        System.out.print("数组：\n{");
        for (int i : array) {
            System.out.print(i + ",");
        }

        System.out.println("}\n的最大值是" + max + ", 最小值是" + min);
    }

    /**
     * 数组练习，合并两个数组
     */
    public void arrayCombine(){
        int[] array0 = {0,1,2,3};
        int[] array1 = {0,7,4,3,2,8,20,24};
        int[] arrayCombine = new int[array0.length + array1.length];//根据两个数组的长度创建新数组

        for (int i = 0; i < arrayCombine.length; i++) {
            if (i < array0.length){
                arrayCombine[i] = array0[i];
            }else{
                arrayCombine[i] = array1[i - array0.length];
            }
        }

        for (int i : arrayCombine) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    /**
     * 数组练习，去掉数组的0元素
     */
    public void deleteArrayZeroElement(){
        int[] array = {1,5,3,0,0,4,8,5,0,7,4};
        int zeroCnt = 0;

        for (int i : array) {
            if(i == 0)
            {
                zeroCnt++;//检查0元素的个数
            }
        }

        if(zeroCnt == 0)
        {
            System.out.println("数组中没有0");
            return;
        }

        int[] arrayX0 = new int[array.length - zeroCnt];//创建新数组
        for (int i = 0, j = 0; i < array.length; i++) {
            if(array[i] != 0)//非0才填入新数组
            {
                arrayX0[j] = array[i];
                j++;
            }
        }

        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println("===>");
        for (int i : arrayX0) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    /**
     * 数组练习，冒泡排序
     */
    public void getArraySorted(){
        int[] array = {1,5,3,4,8,5,7,4};

        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println();

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j+1])
                {
                    /**
                     * 值互换，用异或的方法
                     */
                    array[j] = array[j]^array[j+1];
                    array[j+1] = array[j]^array[j+1];
                    array[j] = array[j]^array[j+1];
                }
            }
        }

        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

}