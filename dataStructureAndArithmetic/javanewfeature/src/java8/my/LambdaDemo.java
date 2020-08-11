package java8.my;

import org.junit.Test;

import java.util.*;
import java.util.function.*;

/**
 * Counsumer<T> :消费性接口
 *      void accept(T t)
 *
 * Supplier<T> : 供给性接口
 *     T get();
 *
 * Function(T,R) : 函数式接口
 *     R apply(T t);
 *
 * Predicate<T> : 断言性接口
 *      boolean test(T t);
 *
 */

public class LambdaDemo {

    @Test
    public void testMyPredicate(){
        Integer[] arr = {1,2,3,4,5,6,7,8,9};
        List<Integer> integers = numFilter(Arrays.asList(arr), x -> x > 3);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    public List<Integer> numFilter (List<Integer> list,Predicate<Integer> mp) {
       List<Integer> l = new ArrayList<>();
        for (Integer integer : list) {
            if (mp.test(integer)) {
                l.add(integer);
            }
        }
        return l;
    }

    @Test
    public void testPredicate () {
        String[] strs = {"a","12","213","abcd"};
        List<String> predicate = predicate(Arrays.asList(strs), (t1) -> t1.length() > 2);
        System.out.println(predicate);
    }

    public List<String> predicate(List<String> strs, Predicate<String> pd){
        List<String> s = new ArrayList<>();
        for (String str : strs) {
            if (pd.test(str)) {
                s.add(str);
            }
        }
        return s;
    }

    @Test
    public void testFunction(){
        function(100.00,(t1) -> t1 );
    }

    public void function(Double d1, Function<Double,Double> fc){
        Double apply = fc.apply(d1);
        System.out.println(apply);
    }

    @Test
    public void testSupplier () {
        supplier(()->"123");
    }

    public void supplier (Supplier<String> supplier) {
        String s = supplier.get();
        System.out.println(s);
    }

    @Test
    public void testConsumer(){
        happy(200.11,(m) -> System.out.println(m));
    }

    public void happy(Double money,Consumer<Double> consumer){
        consumer.accept(money);
    }


    @Test
    public void testSort(){
        String[] strs = {"321","22","4321","12345"};
        for (String str : strs) {
            System.out.print(str + " ");
        }
        System.out.println();
        Collections.sort(Arrays.asList(strs), Comparator.comparingInt(String::length));

        Collections.sort(Arrays.asList(strs), Comparator.comparingInt(String::length));

        for (String str : strs) {
            System.out.print(str + " ");
        }
    }

    @Test
    public void test1(){
        String abcd = getValue("abcd", (t1) -> t1.toUpperCase());
        System.out.println(abcd);
    }

    public String getValue(String str,MyFunction myFunction){
       return myFunction.getValue(str);
    }

    @Test
    public void test2(){
        fun(1,2,(t1,t2) -> t1 + t2);
    }

    public void fun(int a,int b, MuFunction2<Integer, Integer> mf){
        System.out.println(mf.opt(a,b));
    }

}
