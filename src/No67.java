public class No67 {
    public String addBinary(String a, String b) {
        while (a.length() < b.length()) {
            a = "0" + a;
        }
        while (b.length() < a.length()) {
            b = "0" + b;
        }

        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int temp = a.charAt(i) - '0' + b.charAt(i) - '0' + carry;
            result.insert(0, temp % 2);
            carry = temp / 2;
        }

        if (carry == 1) {
            result.insert(0, 1);
        }

        return result.toString();
    }
}
