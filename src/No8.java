public class No8 {
    public int myAtoi(String str) {
        String string = str.trim();
        if (string.length() == 0){
            return 0;
        }

        int sign = 1;
        int i = 0;
        if (string.charAt(0) == '+') {
            sign = 1;
            i=1;
        }
        else if (string.charAt(0) == '-') {
            sign = -1;
            i=1;
        }
        else if (string.charAt(0) < '0' || string.charAt(0) > '9') {
            return 0;
        }

        long result = 0;
        for (; i < string.length(); i++) {
            if (string.charAt(i) < '0' || string.charAt(i) > '9') {
                break;
            }
            if (sign > 0 && (result > Long.MAX_VALUE / 10 || (result == Long.MAX_VALUE / 10 && (string.charAt(i) - '0') > Long.MAX_VALUE % 10))) {
                return Integer.MAX_VALUE;
            }
            if (sign < 0 && (result > Long.MAX_VALUE / 10 || (result == Long.MAX_VALUE / 10 && (string.charAt(i) - '0') > Long.MAX_VALUE % 10 + 1))) {
                return Integer.MIN_VALUE;
            }


            result = result * 10 + (string.charAt(i) - '0');
        }

        result = sign < 0 ? -result : result;

        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (result < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int)result);
    }
}
