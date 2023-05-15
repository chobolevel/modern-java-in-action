package chap06.quiz;

import chap04.entity.Dish;
import chap04.enums.Type;

import java.util.Arrays;
import java.util.List;

public class Quiz02 {

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

        // 다음 partitioningBy를 이용한 코드의 결과를 예측

        // 1)
        // menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.partitioningBy(d -> d.getCalories() > 500)));
        // result -> 이중 파티셔닝으로 채식 true/false 구분하고 칼로리 500 기준 true/false 구분

        // 2)
        // menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.partitioningBy(Dish::getType)));
        // result -> 에러 발생(partitioningBy 인수로는 Predicate 받을 수 있기 때문)

        // 3)
        // menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.counting()));
        // result -> true = 4, false = 5 형식으로 출력 가능

    }

}
