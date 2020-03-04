/**
 * Edit and run with VSCode, default encoding: UTF-8
 */
package app.exception;

public class BoxIndexOutOfBoundsException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public BoxIndexOutOfBoundsException() {
        
    }

    public BoxIndexOutOfBoundsException(String msg) {
        super(msg);
    }
}