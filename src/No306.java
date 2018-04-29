import java.math.BigInteger;

public class No306 {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(0) == '0') break;
            BigInteger preTwo = new BigInteger(num.substring(0, i));
            for (int j = i + 1; j < (num.length() - Math.max(i, j - i)); j++) {
                if (num.charAt(i) == '0') break;
                BigInteger preOne = new BigInteger(num.substring(i, j));
                if (isAdditiveNumber(num, preTwo, preOne, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAdditiveNumber(String num, BigInteger preTwo, BigInteger preOne, int startIndex) {
        if (startIndex == num.length()) {
            return true;
        }

        preOne = preOne.add(preTwo);
        preTwo = preOne.subtract(preTwo);
        String sum = preOne.toString();
        return num.startsWith(sum, startIndex) && isAdditiveNumber(num, preTwo, preOne, startIndex + sum.length());
    }

}
