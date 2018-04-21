public class No165 {
    public int compareVersion(String version1, String version2) {
        String[] versionSegments1 = version1.split("\\.");
        String[] versionSegments2 = version2.split("\\.");

        int length1 = versionSegments1.length;
        int length2 = versionSegments2.length;
        int minLength = Math.min(length1, length2);
        for (int i = 0; i < minLength; i++) {
            if (Integer.valueOf(versionSegments1[i]) > Integer.valueOf(versionSegments2[i])) {
                return 1;
            } else if (Integer.valueOf(versionSegments1[i]) < Integer.valueOf(versionSegments2[i])) {
                return -1;
            }
        }

        if (length1 < length2) {
            for (int i = length1; i < length2; i++) {
                if (Integer.valueOf(versionSegments2[i]) != 0) {
                    return -1;
                }
            }
        }

        if (length1 > length2) {
            for (int i = length2; i < length1; i++) {
                if (Integer.valueOf(versionSegments1[i]) != 0) {
                    return 1;
                }
            }
        }

        return 0;
    }
}
