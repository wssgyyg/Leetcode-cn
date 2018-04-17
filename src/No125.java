public class No125 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isAlphanumeric(s.charAt(left))) left++;
            while (left < right && !isAlphanumeric(s.charAt(right))) right--;
            if (toLowerCaseIfCapital(s.charAt(left)) == toLowerCaseIfCapital(s.charAt(right))) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public char toLowerCaseIfCapital(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char)(c + 32);
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println((int)'A');
        System.out.println((int)'a');
    }
}
