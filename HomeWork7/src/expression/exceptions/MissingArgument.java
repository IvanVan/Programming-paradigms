package expression.exceptions;

import sun.security.acl.AllPermissionsImpl;

/**
 * Created by vanya on 11.04.17.
 */
public class MissingArgument extends Exception {
    private String expression;
    private StringBuilder out;

    public MissingArgument(String expression, StringBuilder out, int position) {
        super("Missing operand at position " + position);
        this.expression = expression;
        this.out = out;
    }

    public String getMessage() {
        return super.getMessage() + "\n" + expression + "\n" + out.toString();
    }
}
