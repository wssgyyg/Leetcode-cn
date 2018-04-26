public class No260 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }

        diff &= -diff;

        int[] res = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int a = 100;
        int b = 50;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }
}
