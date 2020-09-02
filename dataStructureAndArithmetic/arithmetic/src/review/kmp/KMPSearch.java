package review.kmp;

public class KMPSearch {

    public static void main(String[] args) {
        String str1 = "avcavcsesafd";
        String str2 = "avcs";
        //int index = violenceMatch(str1,str2);
        int[] next = kmpNext(str2);
        int index = kmpSearch(str1,str2,next);
        System.out.println(index);
    }

    private static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0,j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j-1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j ++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }

        return -1;
    }

    private static int[] kmpNext(String str) {
        int[] next = new int[str.length()];
        next[0] = 0;
        for (int i = 1,j = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = next[j-1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                j ++;
            }
            next[i] = j;
        }
        return next;
    }

    private static int violenceMatch(String str1, String str2) {
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int i = 0;
        int j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (ch1[i] == ch2[j]) {
                i++;
                j++;
            } else {
                i = i - j +1;
                j = 0;
            }
        }

        if (j == ch2.length) {
            return i - j;
        }

        return -1;
    }



}
