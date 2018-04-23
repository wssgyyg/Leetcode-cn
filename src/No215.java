import java.util.PriorityQueue;
import java.util.Random;

public class No215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(nums[i]);
            } else if (nums[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(nums[i]);
            }
        }

        return priorityQueue.peek();
    }

    public int findKthLargestWithPartition(int[] nums, int k) {
        shuffle(nums);
        k = nums.length - k;
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

    public void shuffle(int a[]) {
        Random random = new Random();
        for (int ind = 1; ind < a.length; ind++) {
            int r = random.nextInt(ind + 1);
            exchange(a, ind, r);
        }
    }

    public void exchange(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Random().nextInt(5));
    }
}
