package expression.parser;

import expression.Variable;
import expression.exceptions.MissingArgument;
import expression.exceptions.Overflow;
import expression.exceptions.UnknownIdentifier;
import expression.exceptions.UnknownSymbol;

import java.util.*;

/**
 * Created by vanya on 10.04.17.
 */
class NextToken {
    private final String expression;
    private int curIndex;
    private Token prevToken = Token.Nothing;
    private String name;
    private int value;
    private int balance;

    private static HashMap<String, Token> correctIdentifier = new HashMap<>();

    static {
        correctIdentifier.put("x", Token.Variable);
        correctIdentifier.put("y", Token.Variable);
        correctIdentifier.put("z", Token.Variable);
        correctIdentifier.put("<<", Token.LeftShift);
        correctIdentifier.put(">>", Token.RightShift);
        correctIdentifier.put("abs", Token.Abs);
        correctIdentifier.put("mod", Token.Mod);
        correctIdentifier.put("square", Token.Square);
        correctIdentifier.put("sqrt", Token.Sqrt);
        correctIdentifier.put("max", Token.Max);
        correctIdentifier.put("min", Token.Min);
    }

    int getValue() {
        return value;
    }

    String getName() {
        return name;
    }

    NextToken(String expression) {
        this.expression = expression;
        curIndex = 0;
        balance = 0;
    }

    private void checkOperand(Token who) throws Exception {
        if (prevToken != Token.CloseBracket && prevToken != Token.Variable && prevToken != Token.Number) {
            if (who == Token.Min || who == Token.Max) {
                throw new MissingArgument(expression, getString(curIndex - 3), curIndex - 3);
            } else {
                throw new MissingArgument(expression, getString(curIndex), curIndex);
            }
        }
    }

    private void checkOperation() throws Exception {
        if (prevToken == Token.CloseBracket || prevToken == Token.Variable || prevToken == Token.Number) {
            throw new MissingArgument(expression, getString(curIndex), curIndex);
        }
    }

    private void checkBalance() throws Exception {
        if (balance < 0) {
            throw new MissingArgument(expression, getString(curIndex), curIndex);
        }
    }

    Token getNextToken() throws Exception {
        Token curToken;
        int sz = expression.length();
        while(curIndex < sz && Character.isWhitespace(expression.charAt(curIndex))) {
            curIndex++;
        }
        if (curIndex >= sz) {
            checkOperand(Token.End);
            if (balance != 0) {
                System.out.println(balance);
                throw new MissingArgument(expression, getString(curIndex), curIndex);
            }
            return Token.End;
        }
        char nowHave = expression.charAt(curIndex);
        switch (nowHave) {
            case '+':
                checkOperand(Token.Add);
                curToken = Token.Add;
                break;
            case '-':
                if (prevToken == Token.CloseBracket || prevToken == Token.Variable || prevToken == Token.Number) {
                    checkOperand(Token.Min);
                    curToken = Token.Sub;
                } else {
                    if (curIndex + 1 < expression.length() && Character.isDigit(expression.charAt(curIndex + 1))){
                        value = parseInt();
                        curIndex--;
                        curToken = Token.Number;
                    } else {
                        curToken = Token.Not;
                    }
                }
                break;
            case '*':
                checkOperand(Token.Mul);
                curToken = Token.Mul;
                break;
            case '/':
                checkOperand(Token.Div);
                curToken = Token.Div;
                break;
            case '(':
                checkOperation();
                curToken = Token.OpenBracket;
                balance++;
                break;
            case ')':
                checkOperand(Token.CloseBracket);
                curToken = Token.CloseBracket;
                balance--;
                break;
            default:
                if (Character.isDigit(expression.charAt(curIndex))) {
                    int from = curIndex;
                    while(curIndex < sz && Character.isDigit(expression.charAt(curIndex))) {
                        curIndex++;
                    }
                    int to = curIndex;
                    try {
                        value = Integer.parseInt(expression.substring(from, to));
                    } catch (Exception e) {
                        throw new Overflow();
                    }
                    if (curIndex != sz)
                        curIndex--;
                    curToken = Token.Number;
                } else {
                    curToken = getIdentifier();
                }
        }
        //System.out.println(prevToken + " " + curToken);
        checkBalance();
        curIndex++;
        prevToken = curToken;
        return curToken;
    }

    private int parseInt() throws Exception{
        int from = curIndex;
        curIndex++;
        while (curIndex < expression.length() && Character.isDigit(expression.charAt(curIndex))) {
            curIndex++;
        }
        try {
            return value = Integer.parseInt(expression.substring(from, curIndex));
        } catch (Exception e) {
            throw new MissingArgument(expression, getString(curIndex), curIndex);
        }
    }

    private boolean isGood(char now) {
        return now == '_' || Character.isLetterOrDigit(now);
    }

    private Token getIdentifier() throws Exception {
        int from = curIndex, sz = expression.length(), to;
        if (!Character.isLetter(expression.charAt(from))) {
            throw new UnknownSymbol();
        }
        while (curIndex < sz && isGood(expression.charAt(curIndex))) {
            curIndex++;
        }
        String nowIdentifier = expression.substring(from, curIndex);
        curIndex--;
        Token nowToken = correctIdentifier.get(nowIdentifier);
        if (nowToken == null) {
            throw new UnknownIdentifier(expression, getString(from), from);
        }
        if (nowToken == Token.Variable) {
            name = nowIdentifier;
        }
        if (nowToken == Token.Max || nowToken == Token.Min) {
            checkOperand(Token.Max);
        }
        return nowToken;
    }

    private StringBuilder getString(int position) {
        StringBuilder out = new StringBuilder("");
        for (int i = 0; i < position; i++) {
            out.append(" ");
        }
        out.append("^");
        return out;
    }
}
