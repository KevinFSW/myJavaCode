package tool.set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class ListTest{
    public static void main(String[] args) {
        // ArrayList<String> arrayList = new ArrayList<>();
        // LinkedList<String> arrayList = new LinkedList<>();
        Vector<String> arrayList = new Vector<>();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < 10; i++) {
            arrayList.add("" + i);
            stack.push("" + i);
        }

        System.out.println(arrayList.size());
        Iterator<String> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println(arrayList);

        arrayList.remove(0);

        System.out.println(arrayList.subList(0,3));
        String[] array = new String[arrayList.size()];
        arrayList.toArray(array);
        for (String string : array) {
            System.out.print(string + "\t");
        }

        System.out.println();

        while(stack.size() > 0){
            System.out.print(stack.pop());
        }

        System.out.println();
        arrayList.clear();
    }
}