package java9;

import org.junit.Test;

public class TestString {

    @Test
    public void test1 () {
        String str = "abc";
        str.lines().forEach(System.out::println);
        System.out.println(str.repeat(3));

        String a = switch (str) {
            case "a" -> "1";
            case "b" -> "2";
            case "abc" -> "3";
            default -> throw new IllegalStateException("Unexpected value: " + str);
        };
    }


}
