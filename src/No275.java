public class No275 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int middle = (left+right)>>1;
            if ((n - middle) == (citations[middle])) {
                return citations[middle];
            } else if ((n - middle) < citations[middle]){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return n - left;
    }
}
