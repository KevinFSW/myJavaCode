package tool.stringclass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest{
    public static void main(String[] args) {
        String str = "6776rrSr8888uuSu4444";
        boolean ret  = str.matches("[0-9a-z]{2,8}");
        System.out.println(ret);

        Pattern pattern = Pattern.compile("[a-zA-Z]{4}");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}