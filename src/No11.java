import java.util.Arrays;

public class No11 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int tempArea = Math.min(height[left], height[right]) * (right - left);
            if (tempArea > maxArea) {
                maxArea = tempArea;
            }

            if (height[left] > height[right]) {
                --right;
            } else {
                ++left;
            }
        }
        return maxArea;
    }
}
