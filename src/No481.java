public class No481 {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;
        int res = 1;
        int[] aux = new int[n + 1];
        aux[0] = 1; aux[1] = 2; aux[2] = 2;
        int head = 2;
        int tail = 3;
        int num = 1;
        while (tail < n) {
            for (int i = 0; i < aux[head]; i++) {
                aux[tail] = num;
                if (num == 1 && tail < n) res++;
                tail++;
            }
            num = num ^ 3;
            head++;
        }

        return res;
    }
}
