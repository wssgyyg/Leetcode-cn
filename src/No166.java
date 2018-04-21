import java.util.HashMap;
import java.util.Map;

public class No166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();

        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sb.append("-");
        }

        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        sb.append(num / den);
        long remainder = num % den;
        if (remainder == 0) {
            return sb.toString();
        }

        sb.append(".");

        Map<Long, Integer> map = new HashMap<>();
        while (!map.containsKey(remainder)) {
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / den);
            remainder %= den;
        }

        int index = map.get(remainder);
        sb.insert(index, '(');
        sb.append(')');
        return sb.toString();
    }
}
