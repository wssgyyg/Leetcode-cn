public class No66 {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + carry;
            digits[i] = (temp) % 10;
            carry = (temp) / 10;
        }

        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            System.arraycopy(result, 0, digits, 0, digits.length);
            return result;
        }

        return digits;
    }

    public static void main(String[] args) {
        int[] result = new No66().plusOne(new int[] { 9, 9 });
    }
}
