import java.util.HashMap;
import java.util.Map;

public class No299 {
    public String getHint(String secret, String guess) {
        int numA = 0;
        int numB = 0;
        char[] secretCharArray = secret.toCharArray();
        char[] guessCharArray = guess.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char secretChar = secretCharArray[i];
            char guessChar = guessCharArray[i];
            if (secretChar == guessChar) {
                numA++;
                guessCharArray[i] = 'x';
            } else {
                if (map.containsKey(secretChar)) {
                    map.put(secretChar, map.get(secretChar) + 1);
                } else {
                    map.put(secretChar, 1);
                }
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            char ch = guessCharArray[i];
            if (ch != 'x') {
                if (map.containsKey(ch) && map.get(ch) != 0) {
                    numB++;
                    map.put(ch, map.get(ch) - 1);
                }
            }
        }

        return numA + "A" + numB + "B";
    }


}
