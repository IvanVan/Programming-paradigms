package expression.parser;

import expression.*;

public class ExpressionParser implements Parser {
    private int value;

    private String name;

    private Token curToken;

    private NextToken token;

    void setValue(int value) {
        this.value = value;
    }

    void setName(String name) {
        this.name = name;
    }

    private TripleExpression unary() {
        curToken = token.getNextToken(this);
        TripleExpression ans;
        switch (curToken) {
            case Number:
                ans = new Const(value);
                curToken = token.getNextToken(this);
                break;
            case Variable:
                ans = new Variable(name);
                curToken = token.getNextToken(this);
                break;
            case Not:
                ans = new Minus(unary());
                break;
            case Abs:
                ans = new Abs(unary());
                break;
            case Square:
                ans = new Square(unary());
                break;
            case OpenBracket:
                ans = shifts();
                curToken = token.getNextToken(this);
                break;
            default:
                return new Const(0);
        }
        return ans;
    }

    private TripleExpression mulDiv() {
        TripleExpression ans = unary();
        do {
            switch (curToken) {
                case Mul:
                    ans = new Multiply(ans, unary());
                    break;
                case Div:
                    ans = new Divide(ans, unary());
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

    private TripleExpression addSub() {
        TripleExpression ans = mulDiv();
        do {
            switch (curToken) {
                case Add:
                    ans = new Add(ans, mulDiv());
                    break;
                case Sub:
                    ans = new Subtract(ans, mulDiv());
                    break;
                default:
                    return ans;
            }
        } while (curToken != Token.End);
        return ans;
    }

    private TripleExpression shifts() {
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

    //private TripleExpression minMax() {
    //    TripleExpression ans = shifts();
    //    do {
    //        switch (curToken) {
    //            case
    //        }
    //    }
    //    return null;
    //}

    @Override
    public TripleExpression parse(String expression) {
        token = new NextToken(expression);
        TripleExpression ans = shifts();
        return ans;
    }
}