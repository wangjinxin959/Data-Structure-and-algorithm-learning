package java8.my;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream的操作步骤
 *      1. 创建Stream
 *      2.中间操作
 *      3.终止操作
 */
public class TestStreamApi {

    // 创建Stream
    @Test
    public void test1 () {
        //1.可以通过Collection系列集合的 stream()方法或 parallelStream()方法
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        Stream<String> stringStream = list.parallelStream();

        //2.通过Arrays工具类中的静态方法 stream() 获取数组流
        IntStream stream1 = Arrays.stream(new int[10]);

        //3.通过Stream类中静态方法 of()
        Stream<String> stringStream1 = Stream.of("1", "2", "3");

        //4.创建无限流
        //迭代
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);
        iterate.limit(10).forEach(System.out::println);
        //生成
        Stream<Double> generate = Stream.generate(() -> Math.random());
        generate.limit(5).forEach(System.out::println);

    }


    /**
     * Stream中间操作  筛选与切片
     *      limit()
     *      filter()
     *      skip()
     *      distinct()
     */
    @Test
    public void test2 () {
        String[] arr = {"11","1","123","1234","12345","123456"};
        Arrays.stream(arr)
                .filter((x) -> {
            System.out.println("过滤");
            return x.length()>2;
            })
                .skip(2)
                .limit(2)
                .forEach(System.out::println);

    }

    // Stream中间操作  映射 map flatMap
    @Test
    public void test3 () {
        String[] arr = {"11","1","123","1234","12345","123456"};
        Arrays.stream(arr).map(String::length)
        .forEach(System.out::println);

        Stream<Stream<Character>> streamStream = Arrays.stream(arr).map(TestStreamApi::characterStream);
        Stream<Character> characterStream = Arrays.stream(arr).flatMap(TestStreamApi::characterStream);
    }


    public static Stream<Character> characterStream (String arr) {
        List<Character> characters = new ArrayList<>();
        for (Character ch : arr.toCharArray()) {
            characters.add(ch);
        }
        return characters.stream();
    }

    //排序 sorted() 自然排序
    //     sorted(Comparator com) 定制排序
    @Test
    public void test4 () {
        String[] arr = {"11","1","123","1234","12345","123456"};
        Arrays.stream(arr)
              .sorted(Comparator.comparingInt(String::length))
              .forEach(System.out::println);
    }

    /** 终止操作
     查找与匹配
     allMatch --检查是否匹配所有元素
     anyMatch --检查是否至少匹配一个元素
     noneMatch --检查是否没有匹配所有元素
     findFirst --返回第一个元素
     findAny --返回当前元素中任意一个元素
     count --返回元素中的个数
     max --返回最大值
     max --返回最小值
     reduce --规约
     collect --收集
     */
    @Test
    public void test5 () {
        List<Empployee> list = Arrays.asList(
                new Empployee(Empployee.Status.BUSY),
                new Empployee(Empployee.Status.FREE),
                new Empployee(Empployee.Status.HOLIDAY)
        );

        boolean a = list.stream().allMatch((e) -> e.getStatus().equals(Empployee.Status.BUSY));
        boolean b = list.stream().anyMatch((e) -> e.getStatus().equals(Empployee.Status.BUSY));
        list.stream().map(Empployee::getSalary).min(Double::compareTo);
        list.stream().min(Comparator.comparingDouble(Empployee::getSalary));
    }

    @Test
    public void test6 () {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);

    }

}
