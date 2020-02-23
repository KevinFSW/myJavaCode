package app.array;
/*
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
*/
import java.util.Scanner;

public class Array {
    /**
     * 数组初始化练习
     */
    public void testArrayInit() {
        /**
         * 静态初始化
         */
        System.out.printf("{%s}:\n", Thread.currentThread().getStackTrace()[1].getMethodName());
        int[] array0 = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] array1 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        /**********************************************
         * 以下三种初始化都是正确可用的 //int[] array1 = {0,1,2,3,4,5,6,7,8,9}; //int array1[] =
         * {0,1,2,3,4,5,6,7,8,9}; //int [] array1 = {0,1,2,3,4,5,6,7,8,9};
         ***********************************************/

        /**
         * 动态初始化
         */
        int[] array3 = new int[10];
    }

    /**
     * 数组练习，两个数组的值对应互换
     */
    public void exchangeTwoArrayValue() {
        int[] array0 = { 0, 1, 2, 3, 4 };
        int[] array1 = { 5, 6, 7, 8, 9 };

        System.out.printf("{%s}:\n", Thread.currentThread().getStackTrace()[1].getMethodName());
        
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

        for (int i : array0) {
            System.out.print(i + ",");
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
    public void exchangeArrayHeadTail() {
        int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

        System.out.printf("{%s}:\n", Thread.currentThread().getStackTrace()[1].getMethodName());
        for (int i = 0; i < array.length / 2; i++)// 遍历一半即可
        {
            /**
             * 值互换，用异或的方法 i 顺数第i个， (array.length - 1 - i)倒数第i个
             */
            array[i] = array[i] ^ array[array.length - 1 - i];
            array[array.length - 1 - i] = array[i] ^ array[array.length - 1 - i];
            array[i] = array[i] ^ array[array.length - 1 - i];
        }

        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    /**
     * 数组练习，计算数组平均值
     */
    public void getArrayAverageValue() {
        int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        double averageValue = 0;

        System.out.printf("{%s}:\n", Thread.currentThread().getStackTrace()[1].getMethodName());
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
    public void getArrayMaxAndMin() {
        int[] array = { 1, 5, 3, 4, 8, 5, 7, 4 };
        int max = array[0];// 配置初始值
        int min = array[0];

        System.out.printf("{%s}:\n", Thread.currentThread().getStackTrace()[1].getMethodName());
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

        System.out.print("数组：\n{");
        for (int i : array) {
            System.out.print(i + ",");
        }

        System.out.println("}\n的最大值是" + max + ", 最小值是" + min);
    }

    /**
     * 数组练习，合并两个数组
     */
    public void arrayCombine() {
        int[] array0 = { 0, 1, 2, 3 };
        int[] array1 = { 0, 7, 4, 3, 2, 8, 20, 24 };
        int[] arrayCombine = new int[array0.length + array1.length];// 根据两个数组的长度创建新数组

        System.out.printf("{%s}:\n", Thread.currentThread().getStackTrace()[1].getMethodName());
        for (int i = 0; i < arrayCombine.length; i++) {
            if (i < array0.length) {
                arrayCombine[i] = array0[i];
            } else {
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
    public void deleteArrayZeroElement() {
        int[] array = { 1, 5, 3, 0, 0, 4, 8, 5, 0, 7, 4 };

        System.out.printf("{%s}:\n", Thread.currentThread().getStackTrace()[1].getMethodName());
        /*
        //这个方法对于大量的数据可能效率比较低
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

        //下面的方法比上面的方法效率高
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
     * 数组练习，按照数组中的最大值分割数组
     */
    public void arrayCutByMax() {
        int[] array = {0, 10, 10, 9, 5, 10, 4, 8, 10, 5, 7, 4, 10, 0};

        System.out.printf("{%s}:\n", Thread.currentThread().getStackTrace()[1].getMethodName());
        /*
        //以下的方法只处理了只有一个最大元素的情况
        int max = array[0];// 配置初始值
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)// 大过就填入替换
            {
                max = array[i];
                maxIndex = i;
            }
        }

        int[] array0 = new int[maxIndex];
        int[] array1 = new int[array.length - maxIndex - 1];

        for (int i = 0; i < array.length; i++) {
            if (i < maxIndex)// 大过就填入替换
            {
                array0[i] = array[i];
            } else if (i > maxIndex) {
                array1[i - maxIndex - 1] = array[i];
            }
        }

        System.out.print("数组：\n{");
        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.printf("}\n被第%d个元素%d分割为：\n{", maxIndex, array[maxIndex]);
        for (int i : array0) {
            System.out.print(i + ",");
        }
        System.out.print("}; {");
        for (int i : array1) {
            System.out.print(i + ",");
        }
        System.out.println("}");
        */

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
        for (int i = 0, subArrayLen = 0; i < tempArray.length; i++) {
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

        //检查分割出来的数组是否有空数组
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
        for (int[] is : newArray) {
            for (int is2 : is) {
                System.out.print(is2+"\t");
            }
            System.out.println();
        }
    }

    /**
     * 数组练习，冒泡排序
     */
    public void arraySorted() {
        int[] array = { 1, 5, 3, 4, 8, 5, 7, 4 };

        System.out.printf("{%s}:\n", Thread.currentThread().getStackTrace()[1].getMethodName());
        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println();

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

        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    /**
     * 数组练习，用户登录认证
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