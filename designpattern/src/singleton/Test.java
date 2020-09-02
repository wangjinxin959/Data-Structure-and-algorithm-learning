package singleton;

import java.util.Arrays;
import java.util.Scanner;

/*1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC*/
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        int count = 0;
        while (sc.hasNextLine()) {
            String x = sc.nextLine();
            if (!"".equals(x)) {
                strs[count] = x;
                count ++;
            }
           if (count == n) {
               break;
           }
        }
        System.out.println(Arrays.toString(strs));
    }

    public static String correctStr (String str) {
        char[] ch = str.toCharArray();
        int i = 1;
        int count = 1;
        while (i < ch.length) {
            char a = ch[i-1];
            char b = ch[i];
            if (a == b) count ++;
            if (count == 3) {

            }
        }
        return null;
    }

}
