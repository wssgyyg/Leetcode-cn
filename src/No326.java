public class No326 {
    public boolean isPowerOfThree(int n) {
        return (n > 0 && (int)Math.pow(3, 19) % n == 0);
    }
}
