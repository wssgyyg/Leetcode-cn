public class No75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;

        int k = 0;
        while(k <= j) {
            if (nums[k] == 0) {
                swap(i++, k++, nums);
            }else if (nums[k] == 2) {
                swap(j--, k, nums);
            }else {
                k++;
            }
        }
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 2, 0, 1, 1 };
        new No75().sortColors(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
