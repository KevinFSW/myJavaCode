/**
 * Edit and run with VSCode, default encoding: UTF-8
 */

package app;

import app.arraybox.ArrayBox;
import app.linkedbox.LinkedBox;

public class App {

    public static void main(String[] args) throws Exception {
        LinkedBox<String> arrayBox = new LinkedBox<String>();
        // ArrayBox<String> arrayBox = new ArrayBox<String>();
        for (int i = 0; i < 10; i++) {
            arrayBox.add("i"+i);
        }

        for (int i = 0; i < arrayBox.size(); i++) {
            System.out.print(arrayBox.get(i) + "\t");
        }
        System.out.println();

        //arrayBox.remove(5);
        for (int i = 0; i < arrayBox.size(); i++) {
            System.out.print(arrayBox.remove(i) + "\t");
        }
        System.out.println();

        for (int i = 0; i < arrayBox.size(); i++) {
            System.out.print(arrayBox.get(i) + "\t");
        }
        System.out.println();

        System.out.println(arrayBox.get(5));
    }
}