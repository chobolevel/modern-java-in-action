package chap05.quiz;

import chap04.entity.Dish;
import chap04.enums.Type;

import java.util.Arrays;
import java.util.List;

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

        // 스트림을 이용해 처음 등장하는 두 고기 요리 필터링
        List<Dish> list = menu.stream()
                .filter(d -> d.getType() == Type.MEAT)
                .limit(2)
                .toList();

        System.out.println(list);

    }

}
