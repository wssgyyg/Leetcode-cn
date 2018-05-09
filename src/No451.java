import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class No451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        IntStream.range(0, s.length()).forEach(i -> map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1));

        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>((entry1, entry2) -> entry2.getValue() - entry1.getValue());

        priorityQueue.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Character, Integer> entry = priorityQueue.poll();
            IntStream.range(0, entry.getValue()).forEach(i -> sb.append(entry.getKey()));
        }
        return sb.toString();
    }

    public String frequencySortBucketSort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        IntStream.range(0, s.length()).forEach(i -> map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1));

        List<Character>[] bucket = new List[s.length() + 1];
        Arrays.stream(bucket).forEach(i -> i =  new LinkedList<>());
        map.entrySet().forEach(entry -> {
            if (bucket[entry.getValue()] == null){
                bucket[entry.getValue()] = new LinkedList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        });

        StringBuilder sb = new StringBuilder();

        for (int pos = bucket.length - 1; pos >=0; pos--) {
            if (bucket[pos] != null) {
                for (char num : bucket[pos]) {
                    for (int i = 0; i < map.get(num); i++) {
                        sb.append(num);
                    }
                }
            }
        }

        return sb.toString();
    }
}
