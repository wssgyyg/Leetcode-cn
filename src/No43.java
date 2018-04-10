public class No43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals(0)) {
            return "0";
        }
        String result = "";
        for (int i = 0; i < num2.length(); i++) {
            String temp = multiplyBySingle(num1, num2.charAt(i));
            result = addTwo(result + "0", temp);
        }
        return result.toString();
    }

    public String multiplyBySingle(String num1, char num2) {
        if (num1.equals(0) || num2 == '0') {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        while (i >= 0) {
            int product = (num2 - '0') * (num1.charAt(i) - '0') + carry;
            result.insert(0, product % 10);
            carry = product / 10;
            --i;
        }

        if (carry > 0) {
            result.insert(0, carry);
        }
        return result.toString();
    }

    public String addTwo(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 < len2) {
            for (int i = 0; i < len2 - len1; i++) {
                num1 = "0" + num1;
            }
        } else {
            for (int i = 0; i < len1 - len2; i++) {
                num2 = "0" + num2;
            }
        }

        int i = num1.length() - 1;
        int carry = 0;
        while (i >= 0) {
            result.insert(0, (carry + num1.charAt(i) - '0' + num2.charAt(i) - '0') % 10);
            carry = (carry + num1.charAt(i) - '0' + num2.charAt(i) - '0') / 10;
            --i;
        }
        if (carry > 0) {
            result.insert(0, carry);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new No43().multiply("123", "111"));
    }
}
