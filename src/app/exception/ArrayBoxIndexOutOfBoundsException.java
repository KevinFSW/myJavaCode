/**
 * Edit and run with VSCode, default encoding: UTF-8
 */
package app.exception;

public class ArrayBoxIndexOutOfBoundsException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ArrayBoxIndexOutOfBoundsException() {
        
    }

    public ArrayBoxIndexOutOfBoundsException(String msg) {
        super(msg);
    }
}