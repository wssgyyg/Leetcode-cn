public class No9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        long reverse = 0;
        int copy = x;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }

        return reverse == copy;
    }
}
