/**
 * Edit and run with VSCode, default encoding: UTF-8
 */

package app;

import app.modifier.Modifier;
import app.modifier.ModifierSub;

public class App {

    public static void main(String[] args) throws Exception {
        Modifier modifier = new Modifier();
        ModifierSub modifierSub = new ModifierSub();
        modifier.setPoint(0);
        modifierSub.optContent();
        modifier.setContent("ct");
        System.out.println(modifier.getContent());
        //System.out.println(modifierSub.getContent());
    }
}