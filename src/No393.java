public class No393 {
    public boolean validUtf8(int[] data) {
        int i = 0;
        while (i < data.length) {
            int num = data[i];
            if (num < 128 && num >= 0) {
                i++;
            } else if ((num & 128) == 0) {
                if (i + 1 < data.length && inRange(data[i + 1])) {
                    i += 2;
                } else {
                    return false;
                }
            } else if (num >= 224 && num <= 239) {
                if (i + 2 < data.length && inRange(data[i + 1]) && inRange(data[i + 2])) {
                    i += 3;
                } else {
                    return false;
                }
            } else if (num >= 240 && num <= 247){
                if (i + 3 < data.length && inRange(data[i + 1]) && inRange(data[i + 2]) && inRange(data[i + 3])) {
                    i += 4;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean inRange(int i) {
        return i <= 191 && i >= 128;
    }
}
