package arithmetic.tencommonlyused;

import org.junit.Test;

import java.util.Arrays;

/**
 * KMP算法
 */
public class ViolenceMatch {

    @Test
    public void test () {
        String str1 = "aaabcdefg";
        String str2 = "abc";
        //int index = violenceMatch(str1, str2);
        int[] ints = kmpNext(str2);
        System.out.println(Arrays.toString(ints));
        int index = kmpSearch(str1, str2, ints);
        System.out.println(index);
    }


    //暴力匹配
    public int violenceMatch (String str1,String str2) {
        if (str1 == null || str2 == null) return -1;
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();

        int i = 0;
        int j = 0;
        while (i < ch1.length && j<ch2.length) {
            if (ch1[i] == ch2[j]) {
                i++;
                j++;
            } else {
                i = i - (j-1);
                j = 0;
            }
        }

        if (j == ch2.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    //返回一个字符串的不分匹配值表
    public int[] kmpNext (String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1,j = 0; i < dest.length(); i++) {

            //kmp核心
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j-1];
            }

            if (dest.charAt(i) == dest.charAt(j)) {
                j ++ ;
            }
            next[i] = j;
        }
        return next;
    }

    //KMP算法实现
    public int kmpSearch (String str1,String str2,int[] next) {
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

}
