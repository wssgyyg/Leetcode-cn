import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            result.add(new LinkedList<>());
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    result.get(i).add(1);
                } else {
                    result.get(i).add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
        }

        return result.size() == 0 ? new ArrayList<>() : result.get(result.size() - 1);
    }
}
