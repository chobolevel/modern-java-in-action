package chap05.quiz;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Quiz04 {
    public static void main(String[] args) {

        // 피보나치 수열의 집합을 출력하는 예제
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(20)
                .forEach(n -> System.out.println("(" + n[0] + ", " + n[1] + ")"));

        System.out.println("===== Java 9 iterate support predicate =====");
        IntStream.iterate(0, n -> n <= 100, n -> n + 5)
                .forEach(System.out::println);

        System.out.println("===== takeWhile =====");
        IntStream.iterate(0, n -> n + 4)
                .takeWhile(n -> n <= 100)
                .forEach(System.out::println);

        System.out.println("===== generate =====");
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

    }
}
