import java.util.Arrays;
import java.util.Random;

public class No384 {

    class Solution {

        int[] nums;
        Random random;
        public Solution(int[] nums) {
            this.nums = nums;
            this.random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {

            int[] a = nums.clone();
            for (int i = 1; i < a.length; i++) {
                int j = random.nextInt(i + 1);
                swap(a, i, j);
            }
            return a;
        }

        private void swap(int[] a, int i, int j){
            a[i] = a[i] ^ a[j];
            a[j] = a[i] ^ a[j];
            a[i] = a[i] ^ a[j];
        }
    }

    public static void main(String[] args) {
        int a = 10, b = 20;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }
}


