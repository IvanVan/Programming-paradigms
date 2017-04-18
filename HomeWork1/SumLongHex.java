public class SumLongHex {
    public static void main(String[] args) {
        long resultSum = 0L;
        for (int index = 0; index < args.length; index++) {
            resultSum = resultSum + parseNumbers(args[index].toLowerCase());
        }
        System.out.println(resultSum);
    }

    private static long parseNumbers(String nowString) {
        long result = 0;
        int firstDigitIndex = -1;
        int lastIntegerType = -1;
        boolean minusSign = false;
        for (int index = 0; index < nowString.length(); index++) {
            if (Character.isWhitespace(nowString.charAt(index))) {
                if (firstDigitIndex != -1) {
                    result += getLongValue(nowString.substring(firstDigitIndex, index));
                }
                firstDigitIndex = -1;
            } else if (firstDigitIndex == -1) {
                firstDigitIndex = index;
            }
        }
        if (firstDigitIndex != -1) {
            result += getLongValue(nowString.substring(firstDigitIndex));
        }
        return result;
    }

    private static long getLongValue(String number) {
        if (number.length() >= 2 && number.substring(0, 2).equals("0x")) {
            return Long.parseUnsignedLong(number.substring(2), 16);
        }
        return Long.parseLong(number);
    }
}