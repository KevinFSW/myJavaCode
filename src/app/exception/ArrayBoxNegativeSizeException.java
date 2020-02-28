/**
 * Edit and run with VSCode, default encoding: UTF-8
 */
package app.exception;

public class ArrayBoxNegativeSizeException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ArrayBoxNegativeSizeException() {

    }

    public ArrayBoxNegativeSizeException(String msg){
        super(msg);
    }
}