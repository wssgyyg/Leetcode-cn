import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];

        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                ugly[i] = Math.min(primes[j] * ugly[idx[j]], ugly[i]);
            }

            for (int j = 0; j < primes.length; j++) {
                while (primes[j] * ugly[idx[j]] <= ugly[i]) idx[j]++;
            }
        }

        return ugly[n - 1];
    }

    public int nthSuperUglyNumberBetter(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);

        int next = 1;
        for (int i = 0; i < n; i++) {
            ugly[i] = next;

            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (val[j] == ugly[i]) val[j] = ugly[idx[j]++] * primes[j];

                next = Math.min(next, val[j]);
            }
        }
        return ugly[n - 1];
    }

    public int nthSuperUglyNumberPQ(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        PriorityQueue<Num> priorityQueue = new PriorityQueue<>();
        for (int prime : primes) {
            priorityQueue.offer(new Num(prime, 1, prime));
        }

        for (int i = 1; i < n; i++) {
            ugly[i] = priorityQueue.peek().val;
            while (priorityQueue.peek().val == ugly[i]) {
                Num num = priorityQueue.poll();
                priorityQueue.offer(new Num(ugly[num.idx] * num.prime, num.idx + 1, num.prime));
            }
        }

        return ugly[n - 1];
    }

    private class Num implements Comparable<Num> {
        int val;
        int idx;
        int prime;

        public Num(int val, int idx, int prime) {
            this.val = val;
            this.idx = idx;
            this.prime = prime;
        }

        @Override
        public int compareTo(Num num) {
            return this.val - num.val;
        }
    }
}
