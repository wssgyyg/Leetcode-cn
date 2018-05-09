import java.util.Arrays;

public class No462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            res += (nums[j--] - nums[i++]);
        }
        return res;
    }

    class Solution {
        public int minMoves2(int[] A) {
            int sum = 0, median = quickSelect(A, A.length / 2);
            for (int i = 0; i < A.length; i++)
                sum += Math.abs(A[i] - median);
            return sum;
        }

        public int quickSelect(int[] nums, int k) {
            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                int i = partition(nums, low, high);
                if (i < k) {
                    low = i + 1;
                } else if (i > k) {
                    high = i - 1;
                } else {
                    break;
                }
            }

            return nums[k];
        }

        public int partition(int[] nums, int low, int high) {
            int pivot = nums[low];
            while (low < high) {
                while (low < high && nums[high] > pivot) {
                    high--;
                }
                nums[low] = nums[high];
                while (low < high && nums[low] <= pivot) {
                    low++;
                }
                nums[high] = nums[low];
            }
            nums[high] = pivot;
            return high;
        }
    }
}
