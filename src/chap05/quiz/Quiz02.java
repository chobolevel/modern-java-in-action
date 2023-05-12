package chap05.quiz;

import java.util.Arrays;
import java.util.List;

public class Quiz02 {

    // 1) 숫자 리스트가 주어졌을 때 각 숫자의 제곱근으로 이루어진 리스트 반환
    // [1, 2, 3, 4, 5] -> [1, 4, 9, 16, 25]

    // result
    // List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    // numbers.stream()
    //     .map(i -> i * i)
    //     .collect(toList());

    // 2) 두 개의 숫자 리스트가 있을 떄 숫자 쌍을 반환
    // [1, 2, 3], [3, 4] -> [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]

    // result
    // List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    // List<Integer> numbers2 = Arrays.asList(3, 4);
    // List<int[]> pairs = numbers1.stream()
    //     .flatMap(i -> numbers2.stream().map(j -> new int []{i, j})
    //     .collect(toList());

    // 3) 이전 예제에서 3으로 나누어 떨어지는 쌍만 반환 -> 166p

}
