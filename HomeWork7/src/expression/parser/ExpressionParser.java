package expression.parser;


import expression.*;
import expression.exceptions.Parser;

public class ExpressionParser implements Parser {
    private Token curToken;

    private NextToken token;

    private TripleExpression unary() throws Exception {
        curToken = token.getNextToken();
        TripleExpression ans;
        switch (curToken) {
            case Sqrt:
                ans = new Sqrt(unary());
                break;
            case Number:
                ans = new Const(token.getValue());
                curToken = token.getNextToken();
                break;
            case Variable:
                ans = new Variable(token.getName());
                curToken = token.getNextToken();
                break;
            case Not:
                ans = new CheckedNegate(unary());
                break;
            case Abs:
                ans = new Abs(unary());
                break;
            case Square:
                ans = new Square(unary());
                break;
            case OpenBracket:
                ans = minMax();
                curToken = token.getNextToken();
                break;
            default:
                return new Const(0);
        }
        return ans;
    }

    private TripleExpression mulDiv() throws Exception {
        TripleExpression ans = unary();
        do {
            switch (curToken) {
                case Mul:
                    ans = new CheckedMultiply(ans, unary());
                    break;
                case Div:
                    ans = new CheckedDivide(ans, unary());
                    break;
                case Mod:
                    ans = new Mod(ans, unary());
                    break;
                default:
                    return ans;
            }
        } while (curToken != Token.End);
        return ans;
    }

    private TripleExpression addSub() throws Exception {
        TripleExpression ans = mulDiv();
        do {
            switch (curToken) {
                case Add:
                    ans = new CheckedAdd(ans, mulDiv());
                    break;
                case Sub:
                    ans = new CheckedSubtract(ans, mulDiv());
                    break;
                default:
                    return ans;
            }
        } while (curToken != Token.End);
        return ans;
    }

    private TripleExpression shifts() throws Exception {
        TripleExpression ans = addSub();
        do {
            switch (curToken) {
                case LeftShift:
                    ans = new ShiftLeft(ans, addSub());
                    break;
                case RightShift:
                    ans = new ShiftRight(ans, addSub());
                    break;
                default:
                    return ans;
            }
        } while(curToken != Token.End);
        return ans;
    }

    private TripleExpression minMax() throws Exception {
        TripleExpression ans = shifts();
        do {
            switch (curToken) {
                case Min:
                    ans = new Min(ans, shifts());
                    break;
                case Max:
                    ans = new Max(ans, shifts());
                    break;
                default:
                    return ans;
            }
        } while (curToken != Token.End);
        return ans;
    }

    @Override
    public TripleExpression parse(String expression) throws Exception {
        token = new NextToken(expression);
        TripleExpression ans = minMax();
        return ans;
    }
}