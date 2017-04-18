package expression.exceptions;

/**
 * Created by vanya on 04.04.17.
 */
public class DBZException extends Exception {
    public DBZException() {
        super("You try to divide by zero!");
    }
}
