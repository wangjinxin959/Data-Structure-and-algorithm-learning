package java8.my;

import datastructures.stack.PolishNotaion;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法的引用
 *      对象::实例方法名
 *      类::静态方法名
 *      类::实例方法名
 *
 *      注意:lambda表达式的方法体中方法的参数个数与接口方法的参数个数一致，返回类型一致
 * 构造器的引用
 *      类::new
 *
 * 数组的引用
 *      Type[]::new
 *
 */
public class MethodRef {
    @Test
    public void test1 () {
        Consumer<String> cs = (o1)-> System.out.println(o1);
        cs.accept("哈哈");
        Consumer<String> cs2 = System.out::println;
        cs2.accept("呵呵");
    }

    @Test
    public void test2 () {
        Comparator<Integer> cp = (o1,o2) -> Integer.compare(o1,o2);
        System.out.println(cp.compare(1, 2));

        Comparator<Integer> cp2 = Integer::compare;
        System.out.println(cp2.compare(2,1));
    }

    @Test
    public void test3 () {
        Supplier<Empployee> s = () -> new Empployee();
        System.out.println(s.get());

        Supplier<Empployee> s1 = Empployee::new;
        System.out.println(s1.get());

        Function<Integer,Empployee> f1 = (x) -> new Empployee(x);
        System.out.println(f1.apply(1));

        BiFunction<Integer,String,Empployee> f2 = (x,y) -> new Empployee(x,y);
        System.out.println(f2.apply(2,"张三"));

        PolishNotaion no = new PolishNotaion();

    }


    @Test
    public void test4 () {
        Function<Integer,String[]> fun = (x) -> new String[x];
        System.out.println(fun.apply(10).length);

        Function<Integer,String[]> fun2 = String[]::new;
        System.out.println(fun2.apply(20).length);

    }

}
