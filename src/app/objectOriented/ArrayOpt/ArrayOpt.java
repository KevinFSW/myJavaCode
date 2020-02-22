package app.ObjectOriented.ArrayOpt;

import java.util.Scanner;

public class ArrayOpt {

    private boolean resultOutputEnable = false;

    /**
     * 配置结果输出
     * @param en :true 打开方法内的结果输出; false 关闭方法内的结果输出.
     */
    public void setResultOutputEnable(boolean en){
        this.resultOutputEnable = en;
    }

    /**
     * 一维数组打印输出
     * @param array 要打印的一维数组
     */
    public void outputArray(int[] array){
        for (int i : array) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    /**
     * 二维数组打印输出
     * @param array 要打印的二维数组
     */
    public void outputArray2(int[][] array){
        for (int[] is : array) {
            for (int js : is) {
                System.out.print(js + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 两个数组的值对应互换
     * @param array0
     * @param array1
     */
    public void exchangeTwoArrayValue(int[] array0, int[] array1) {

        if(this.resultOutputEnable){
            System.out.printf("{%s}:\n", Thread.currentThread().getStackTrace()[1].getMethodName());
            
            System.out.println("输入的数组是：");
            this.outputArray(array0);
            this.outputArray(array1);
        }

        //这个方法无法解决数组长度不一样的问题
        /* for (int i = 0; i < array0.length; i++) {
             // 值互换，用异或的方法
            array0[i] = array0[i] ^ array1[i];
            array1[i] = array0[i] ^ array1[i];
            array0[i] = array0[i] ^ array1[i];
        } */

        //直接交换引用，可以解决数组长度不一样的问题
        int[] temp = array0;
        array0 = array1;
        array1 = temp;

        if(this.resultOutputEnable){
            //输出看看而已
            System.out.println("输出的数组是：");
            this.outputArray(array0);
            this.outputArray(array1);
        }
    }

    /**
     * 将一个数组的头尾值互换
     * @param array
     */
    public void exchangeArrayHeadTail(int[] array) {
        if(this.resultOutputEnable){
            System.out.printf("{%s}:\n", Thread.currentThread().getStackTrace()[1].getMethodName());
            
            System.out.println("输入的数组是：");
            this.outputArray(array);
        }

        for (int i = 0; i < array.length / 2; i++)// 遍历一半即可
        {
            /**
             * 值互换，用异或的方法 i 顺数第i个， (array.length - 1 - i)倒数第i个
             */
            array[i] = array[i] ^ array[array.length - 1 - i];
            array[array.length - 1 - i] = array[i] ^ array[array.length - 1 - i];
            array[i] = array[i] ^ array[array.length - 1 - i];
        }

        if(this.resultOutputEnable){
            System.out.println("输出的数组是：");
            this.outputArray(array);
        }
    }

    /**
     * 寻找数组的最大最小值
     * @param array
     * @return int[0] 最小值; int[1] 最大值.
     */
    public int[] getArrayMaxAndMin(int[] array) {
        int[] maxAndMin = new int[2];//用作返回值
        int max = array[0];// 配置初始值
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)// 大过就填入替换
            {
                max = array[i];
            }

            if (array[i] < min)// 小过就填入替换
            {
                min = array[i];
            }
        }

        maxAndMin[0] = min;
        maxAndMin[1] = max;

        if(this.resultOutputEnable){
            System.out.printf("{%s}:\n", Thread.currentThread().getStackTrace()[1].getMethodName());
            System.out.println("数组：");
            this.outputArray(array);
            System.out.println("的最大值是" + max + ", 最小值是" + min);
        }

        return maxAndMin;
    }

    /**
     * 在数组中找元素
     * @param array 从这个数组里面查找
     * @param target 要找的元素
     * @return int[x] 找到的target的索引数组
     */
    public int[] findInArray(int[] array, int target){
        int[] temp = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == target){
                temp[j++] = i;
            }
        }

        if(j > 0)
        {
            int[] targetArray = new int[j];
            for (int i = 0; i < targetArray.length; i++) {
                targetArray[i] = temp[i];
            }
            
            return targetArray;
        }

        return null;
    }

    /**
     * 合并两个数组
     * @param array0
     * @param array1
     * @return int[] 合并后的数组
     */
    public int[] arrayCombine(int[] array0, int[] array1) {

        int[] arrayCombine = new int[array0.length + array1.length];// 根据两个数组的长度创建新数组

        if(this.resultOutputEnable){
            System.out.printf("{%s}:\n", Thread.currentThread().getStackTrace()[1].getMethodName());
            System.out.println("输入的数组是：");
            this.outputArray(array0);
            this.outputArray(array1);
        }

        for (int i = 0; i < arrayCombine.length; i++) {
            if (i < array0.length) {
                arrayCombine[i] = array0[i];
            } else {
                arrayCombine[i] = array1[i - array0.length];
            }
        }

        if(this.resultOutputEnable){
            System.out.println("输出的数组是：");
            this.outputArray(arrayCombine);
        }

        return arrayCombine;
    }

    /**
     * 去掉数组的0元素
     * @param array
     * @return 去掉数组的0元素后得到的数组
     */
    public int[] deleteArrayZeroElement(int[] array) {
        if(this.resultOutputEnable){
            System.out.printf("{%s}:\n", Thread.currentThread().getStackTrace()[1].getMethodName());
            System.out.println("输入的数组是：");
            this.outputArray(array);
        }

        /*
        //这个方法对于大量的数据可能效率比较低，但是空间利用率较低
        int zeroCnt = 0;
        for (int i : array) {
            if (i == 0) {
                zeroCnt++;// 检查0元素的个数
            }
        }

        if (zeroCnt == 0) {
            System.out.println("数组中没有0");
            return;
        }

        int[] arrayX0 = new int[array.length - zeroCnt];// 创建新数组
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] != 0)// 非0才填入新数组
            {
                arrayX0[j] = array[i];
                j++;
            }
        }
        */

        //下面的方法比上面的方法效率高，但是空间利用率较高
        int[] arrayTemp = new int[array.length];
        int arrayTempIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != 0)//先把不为0的存起来
            {
                arrayTemp[arrayTempIndex++] = array[i];
            }
        }

        int[] arrayX0 = new int[arrayTempIndex];//根据不为0的元素数量创建新数组
        for (int i = 0; i < arrayX0.length; i++) {
            arrayX0[i] = arrayTemp[i];
        }

        arrayTemp = null;//释放中间资源

        if(this.resultOutputEnable){
            System.out.println("输出的数组是：");
            this.outputArray(arrayX0);
        }

        return arrayX0;
    }

    /**
     * 按照数组中的最大值分割数组
     * @param array
     * @return int[][] 假设能分割成三个数组，则这三个数组分别是int[0]; int[1]; int[2]
     */
    public int[][] arrayCutByMax(int[] array) {
        //下面的方法处理有n个最大元素的情况
        int max = array[0];// 配置初始值
        int[] maxIndex = new int[array.length];//用于存放最大元素的索引
        int maxCnt = 0;//用于计算最大元素的个数
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)//大过就填入替换，同时最大元素的个数重置为1，记录索引
            {
                max = array[i];
                maxCnt = 1;
                maxIndex[maxCnt-1] = i;
            }
            else if(array[i] == max)//等于当前的最大元素，记录最大元素的索引，同时cnt++
            {
                maxIndex[maxCnt] = i;
                maxCnt++;
            }
        }

        //根据最大元素的个数创建一个二维数组。第二维就是分割出来的数组，其长度需要根据最大元素的索引创建
        int[][] tempArray = new int[maxCnt+1][];
        for (int i = 0, subArrayLen = 0/* 第二维的长度 */; i < tempArray.length; i++) {
            if(i == 0) //newArray[0][]的长度直接用第一个索引创建  假设：这是第一个
            {
                subArrayLen = maxIndex[i];
            }
            else if (i == tempArray.length - 1)//newArray[length-1][]的长度
            {
                subArrayLen = array.length - maxIndex[i-1] - 1;
            }
            else//不是第一个和最后一个的要计算一下，创建的数组长度等于当前的索引减去前一个索引再减一
            {
                subArrayLen = maxIndex[i] - maxIndex[i-1] - 1;
            }

            tempArray[i] = new int[subArrayLen];//这个就是分割后得到的数组 
            for (int j = 0; j < tempArray[i].length; j++) {
                if(i == 0)
                {
                    tempArray[i][j] = array[j];//被分割出来的第一个数组，从原数组的0索引开始取值
                }
                else
                {
                    tempArray[i][j] = array[maxIndex[i-1]+j+1];//非第一个，要根据最大元素的索引取值
                }
            }
        }

        //检查分割出来的数组是否有空数组（最大值在头和尾的时候可能分割到空数组）
        int emptyArrayCnt = 0;
        for (int i = 0; i < tempArray.length; i++) {
            if(tempArray[i].length == 0)
            {
                emptyArrayCnt++;
            }
        }

        int[][] newArray;
        if(emptyArrayCnt == 0)//没有空数组，直接赋值引用
        {
            newArray = tempArray;
        }
        else //有空数组，去除空数组
        {
            newArray = new int[tempArray.length - emptyArrayCnt][];
            int newArrayIndex = 0;
            for (int i = 0; i < tempArray.length; i++) {
                if(tempArray[i].length > 0)
                {
                    newArray[newArrayIndex++] = tempArray[i];
                }
            }
        }

        tempArray = null;
        //打印出来看看而已
        if(this.resultOutputEnable){
            System.out.printf("{%s}:\n", Thread.currentThread().getStackTrace()[1].getMethodName());
            System.out.println("输入的数组是：");
            this.outputArray(array);
            System.out.println("输出的数组是：");
            this.outputArray2(newArray);
        }

        return newArray;
    }

    /**
     * 冒泡排序
     * @param array
     */
    public void arraySorted(int[] array) {
        if(this.resultOutputEnable){
            System.out.printf("{%s}:\n", Thread.currentThread().getStackTrace()[1].getMethodName());
            System.out.println("输入的数组是：");
            this.outputArray(array);
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    /**
                     * 值互换，用异或的方法
                     */
                    array[j] = array[j] ^ array[j + 1];
                    array[j + 1] = array[j] ^ array[j + 1];
                    array[j] = array[j] ^ array[j + 1];
                }
            }
        }

        if(this.resultOutputEnable){
            System.out.println("输出的数组是：");
            this.outputArray(array);
        }
    }

    /**
     * 用户登录认证
     */
    public void userSignAndLogin() {
        /*
        // 读取文件
        File file = new File("./user.txt");
        Scanner fileScanner;
        int initUserCnt = 0;
        if (file.exists() == false) {
            try {
                file.createNewFile();// 文件不存在则创建
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return;
            }
        } else {
            try {
                fileScanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return;
            }
            initUserCnt = fileScanner.nextInt();
        }

        //创建初始配置文件的数组
        String[][] initUser = new String[initUserCnt][2];
        if(initUserCnt > 0)
        {
            for (int i = 0; i < initUserCnt; i++) {
                initUser[i][0] = fileScanner.nextLine();
            }
        }
        */

        //创建保存用户名和密码的数组，通过文件保存和读取待完成
        String[][] userAndPwd = {
            {"user0", "12345678"},
            {"user1", "87654321"},
        };
        //提示用户登录。
        System.out.println("请输入用户名：");
        Scanner input = new Scanner(System.in);
        String user = input.nextLine();
        System.out.println("请输入密码：");
        String pwd = input.nextLine();

        //System.out.println(userAndPwd.length);
        
        for (int i = 0; i < userAndPwd.length; i++) {
            if(user.equals(userAndPwd[i][0]) && pwd.equals(userAndPwd[i][1]))
            {
                System.out.println("login:"+userAndPwd[i][0]+":"+userAndPwd[i][1]);
                return;
            }
        }
        System.out.println("login failed");
    }

}