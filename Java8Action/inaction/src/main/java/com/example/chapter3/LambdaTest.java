package com.example.chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Created by jutao on 2017/2/8.
 */
public class LambdaTest {
    public static void main(String[] args) {
//        lambdaTest();
//        predicateTest();
//        consumerTest();
//        functionTest();
        IntPredicate evenNumbers=(int i)->i%2==0;
        System.out.println(evenNumbers.test(1000));
    }

    private static void functionTest() {
       List<Integer> lengths=map(Arrays.asList("hello", "world", "ok"), String::length);
        for (Integer length : lengths) {
            System.out.println(length);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }

    private static void consumerTest() {
        Consumer<Integer> consumer = System.out::println;
        forEach(Arrays.asList(1, 2, 3, 4), consumer);
    }

    private static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    private static void lambdaTest() {
        try {
            //读取第一行
            System.out.println(processFile((BufferedReader br) -> br.readLine()));
            //读取前两行
            System.out.println(processFile((BufferedReader br) -> br.readLine() + br.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void predicateTest() {
        Predicate<String> nonEmptyStringPredicate = (String s) -> s != null && !s.isEmpty();
        List<String> list = new ArrayList<>();
        list.add("sss");
        list.add(null);
        list.add("");
        list.add("jjj");
        List<String> filter = filter(list, nonEmptyStringPredicate);
        for (String s : filter) {
            System.out.println(s);
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        //Java7 中的带资源try语句，我们不需要显式的关闭资源
        try (BufferedReader br = new BufferedReader(new FileReader("E:\\data.txt"))) {
            return p.process(br);
        }
    }

    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }


}