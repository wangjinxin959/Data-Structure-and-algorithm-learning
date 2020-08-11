package java8.my;

import java8.demo.java8.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class StreamApiPrac {

    /**
        1.给定一个数字列表，如何返回由每个数的平方构成的列表呢
        例如   给定[1,2,3,4,5] 返回 [2,4,9,16,25]
     */

    @Test
    public void test1 () {
        Arrays.stream(new int[]{1, 2, 3, 4, 5})
               .map((x) -> x*x)
                .forEach(System.out::println);
    }

    /**
     2.怎么用 map reduce 方法数一数流中有多少个Employee
     */
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );
    @Test
    public void test2 () {
        long count = emps.stream()
                .count();
        Optional<Integer> reduce = emps.stream()
                .map(e -> 1)
                .reduce(Integer::sum);
        System.out.println(reduce.get());
    }


}
