import java.util.Arrays;

public class No324 {
    public void wiggleSort(int[] nums) {
        int middle = getKthLargest(nums, (nums.length + 1) / 2);
        int odd = 1;
        int even = nums.length % 2 == 0 ? nums.length - 2 : nums.length - 1;
        int[] aux = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > middle) {
                aux[even] = nums[i];
                even -= 2;
                continue;
            }

            if (nums[i] < middle) {
                aux[odd] = nums[i];
                odd += 2;
                continue;
            }
        }

        while (even >= 0) {
            aux[even] = middle;
            even -= 2;
        }

        while (odd < nums.length) {
            aux[odd] = middle;
            odd += 2;
        }

        System.arraycopy(aux, 0, nums, 0, nums.length);

    }

    private int getKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
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

    private int partition(int[] nums, int low, int high) {
        int i = low, j = high;
        int pivot = nums[i];

        while (i < j) {
            while (i < j && nums[j] > pivot) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            nums[j] = nums[i];
        }

        nums[i] = pivot;
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        new No324().swap(a, 0, 2);

        for (int i : a) {
            System.out.println(i);
        }
    }
}
