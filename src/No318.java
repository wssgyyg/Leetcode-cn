public class No318 {
    public int maxProduct(String[] words) {
        if (words == null || words.length <= 0) return 0;

        int[] bitRepresentations = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                bitRepresentations[i] |= (1 << (ch - 'a'));
            }
        }

        int maxProducts = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bitRepresentations[i] & bitRepresentations[j]) == 0 && (words[i].length() * words[j].length() > maxProducts)) {
                    maxProducts = words[i].length() * words[j].length();
                }
            }
        }

        return maxProducts;
    }
}
