public class No6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }
        int direction = 1;
        int row = 0;
        int i = 0;
        while (i < s.length()) {
            rows[row].append(s.charAt(i));
            if (row == 0){
                direction = 1;
            }
            if (row == rows.length - 1) {
                direction = -1;
            }
            row += direction;
            ++i;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb.toString());
        }
        return result.toString();
    }
}
