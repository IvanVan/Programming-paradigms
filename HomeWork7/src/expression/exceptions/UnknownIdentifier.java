package expression.exceptions;


/**
 * Created by vanya on 11.04.17.
 */
public class UnknownIdentifier extends Exception {
    private StringBuilder out;
    private String expression;

    public UnknownIdentifier(String expression, StringBuilder out, int position) {
        super("Unknown identifier at position " + position);
        this.out = out;
        this.expression = expression;
    }

    public String getMessage() {
        return super.getMessage() + "\n" + expression + "\n" + out.toString();
    }
}
