public class No168 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, (char)(--n % 26 + 'A'));
            n /= 26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println((char) 64);
    }
}
