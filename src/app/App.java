package app;

import app.OperationalSymbol.OperationalSymbol;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
        OperationalSymbol operationalSymbol = new OperationalSymbol();
        operationalSymbol.test0();
        operationalSymbol.test1();
    }
}