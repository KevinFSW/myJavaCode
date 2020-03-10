package tool.stringclass;

public class StringTest{

    //反转字符串
    public static String stringReverse(String str){
        //先检查一下传进来的字符串
        //如果传进来的字符串的null，或者是""，或者只有一个字符，则无需处理
        if(str == null || str.isEmpty() || str.length() == 1){
            return str;
        }

        //开始传进来的字符串
        //先转成字符数组
        char[] ch = str.toCharArray();
        //循环反转数组,循环数组长度的半即可
        for (int i = 0; i < ch.length/2; i++) {
            char temp = ch[i];
            ch[i] = ch[ch.length - i - 1];
            ch[ch.length - i - 1] = temp;
        }

        //把字符数组转成String
        String newStr = new String(ch);

        return newStr;
    }

    //将指定字符串的正向反向拼接
    public static String catAzAndZa(String az){
        //先检查一下传进来的字符串
        //如果传进来的字符串的null，或者是""，则无需处理
        if(az == null || az.isEmpty()){
            return az;
        }

        //获取az的反序字符串，利用上面写好的方法
        String za = StringTest.stringReverse(az);

        //利用String类的方法拼接
        String newStr = az.concat(za);

        return newStr;
    }

    //判断是否是回文abcba
    public static boolean isPalindrome(String str){
        //先检查一下传进来的字符串
        //如果传进来的字符串的null，或者是""，则返回 false (看约定)
        if(str == null || str.isEmpty()){
            return false;
        }

        //如果字符串的长度是1，返回 true （当然也是看约定）
        if(str.length() == 1){
            return true;
        }

        //可以使用的方法：
        /*
        //方法1：转成字符串，循环检查
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length/2; i++) {
            if(ch[i] != ch[ch.length - i -1]){
                return false; //只要发现前后字符不相等，直接返回false
            }
        }
       
        //没有发现不相等，是回文
        return true;
        */
    /************************************************************** */
        //方法2：利用写好的方法反序, 判断反转后是否与原来一样
        if(StringTest.stringReverse(str).equals(str)){
            return true;
        }
        
        return false;
        
    }

    //将字符串循环左移右移x位
    public static String stringRotate(boolean rolOrRor, int times, String str){
        //先检查一下传进来的参数
        //次数不合法，引用是null，空字符串无需处理
        //字符串长度为1或times，怎么移动都是他自己
        if(times < 1 || str == null || str.isEmpty() || str.length() == times || str.length() == 1){
            return str;
        }

        //每(字符串长度)次移动就会跟原来一样，因此可以对用位移次数对字符串长度取余数，处理位移次数大过字符串长度的情况
        if(times > str.length()){
            times = times % str.length();
        }

        //12345 >> 4 =====> 23451 相当于 12345 << 1, 因此可以使用转换方向的方法，处理位移次数大过字符串长度一半的情况（节约时间）
        if(times > str.length() / 2)
        {
            rolOrRor = !rolOrRor;
            times = str.length() - times;
        }

        //下面是移位的思路
        //思路1：实现移位，可以把字符串转成数组
        /*
        char[] ch = str.toCharArray();
        for (int i = 0; i < times; i++) {
            if(!rolOrRor){ //循环左移
                char temp = ch[0];//开始移位前，保存好会被移出去的那个字符
                for (int j = 0; j < ch.length - 1; j++) {
                    ch[j] = ch[j+1];
                }
                ch[ch.length - 1] = temp;//把被移出去的补到后面去
            }
            else{  //循环右移
                char temp = ch[ch.length - 1];//开始移位前，保存好会被移出去的那个字符
                for (int j = ch.length - 1; j > 0; j--) {
                    ch[j] = ch[j-1];
                }
                ch[0] = temp;//把被移出去的补到前面去
            }
        }

        //把字符数组转成String
        String newStr = new String(ch);
        return newStr;
        */
    /************************************************************ */
        //思路2：位移多少次，就从前面或者后面拿多少个字符放到后面或者前面
        int subIndex;
        if(!rolOrRor){  //左移，从前面拿到后面去，比如左移2次，从前面拿2个字符放到后面去
            subIndex = times;
        }
        else{   //右移，从后面拿到前面去，比如右移2次，从后面拿2个字符放到前面去，也相当于从前面拿str.length() - 2个字符放到后面去
            subIndex = str.length() - times;
        }

        String part0 = str.substring(0, subIndex);
        String part1 = str.substring(subIndex);
        return part1.concat(part0);
    }

    //寻找若干字符串中最长的那个
    public static String getLongestString(String str1, String str2){
        if(str1 == null && str2 == null){
            return null;
        }
        else if(str1 == null){
            return str2;
        }
        else if(str2 == null){
            return str1;
        }
        
        if(str1.length() > str2.length()){
            return str1;
        }

        return str2;
    }

    //统计字符出现的次数
    public static int getNumberOfTarget(String str, String target){
        //先检查一下传进来的字符串
        //如果传进来的字符串的null，或者是""，则返回 0
        if(str == null || str.isEmpty() || target == null || target.isEmpty()){
            return 0;
        }

        //把原来字符串里面的target全部替换为"", 再用原来的总长度减去替换后的长度，得到的长
        //度是所有找到的target的总长度，再除以target的长度就得到了target的个数
        return (str.length() - str.replaceAll(target, "").length())/target.length();
        /*
        //先看看str里面有没有target，没有则直接return 0
        if(!str.contains(target)){
            return 0;
        }

        int addNum = 0;
        for (int i = 0; i < str.length(); ) {
            //循环查找target，每次都从i索引开始找
            i = str.indexOf(target, i);
            if(i != -1){  //找到了
                i += target.length();//下一次，从当前找到的索引加target.length()个位置开始找
                addNum++;
            }
            else{  //找不到了，结束查找
                break;
            }
        }

        return addNum;
        */
    }

    //将给定的字符串中每个单词的首字母改成大写
    public static String upCaseOfEachWord(String str){
        //先检查一下传进来的字符串
        //如果传进来的字符串的null，或者是""，则无需处理
        if(str == null || str.isEmpty()){
            return str;
        }

        //先转成数组，通过索引修改字母
        char[] ch = str.toCharArray();
        boolean getWord = false; //找到单词状态标志（状态机）
        for (int i = 0; i < ch.length; i++) {
            if(getWord == false && ch[i] != ' '){  //当前的状态是没有找到单词，并且当前的这个字母不是空格，则认为刚好找到了一个单词
                if(ch[i] >= 'a' && ch[i] <= 'z'){  //找到了，当前字母必定是首字母，马上修改首字母
                    ch[i] = (char) (ch[i] - ('a' - 'A'));
                }

                getWord = true;
            }

            if(ch[i] == ' '){  //发现一个空格，则当前的单词结束，进入没有找到单词的状态
                getWord = false;
            }
        }

        return new String(ch);
    }

    //获取字符串中的全部数字
    public static String getNumbersInString(String str){
        //先检查一下传进来的字符串
        //如果传进来的字符串的null，或者是""，则无需处理
        if(str == null || str.isEmpty()){
            return str;
        }

        //先转成数组，通过索引找数字
        char[] ch = str.toCharArray();
        String newStr = "";
        for (char c : ch) {
            if(c >= '0' && c <= '9'){
                newStr += c;
            }
        }

        return newStr;
    }

    public static void main(String[] args) {
        System.out.println(StringTest.getNumberOfTarget("ggggggghhhhjjjj", "g"));
    }
}