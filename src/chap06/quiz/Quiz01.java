package chap06.quiz;

import chap04.entity.Dish;
import chap04.enums.Type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz01 {

    private static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Type.MEAT),
            new Dish("beef", false, 700, Type.MEAT),
            new Dish("chicken", false, 400, Type.MEAT),
            new Dish("french", true, 530, Type.OTHER),
            new Dish("rice", true, 350, Type.OTHER),
            new Dish("season fruit", true, 120, Type.OTHER),
            new Dish("pizza", true, 550, Type.OTHER),
            new Dish("prawns", false, 300, Type.FISH),
            new Dish("salmons", false, 450, Type.FISH)
    );
    public static void main(String[] args) {

        // 리듀싱으로 문자열 연결하기
        String result = menu.stream().collect(Collectors.reducing("", Dish::getName, (acc, cur) -> acc + cur));
        System.out.println(result);

        // joining 메서드 활용
        String joining = menu.stream().map(Dish::getName).collect(Collectors.joining(","));
        System.out.println(joining);

    }
}
