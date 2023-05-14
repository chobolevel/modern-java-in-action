package chap06.test;

import chap04.entity.Dish;
import chap04.enums.Type;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

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

    public enum CaloricLevel { DIET, NORMAL, FAT}

    public static void main(String[] args) {

        System.out.println("===== menu statistics =====");
        IntSummaryStatistics menuStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);

        System.out.println("===== Collectors joining =====");
        String shortMenuName = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println(shortMenuName);

        System.out.println("===== Collectors reducing =====");
        int totalCalories = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (acc, cur) -> acc + cur));
        System.out.println(totalCalories);

        System.out.println("===== groupingBy =====");
        Map<Type, List<Dish>> groupingByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(groupingByType);

        System.out.println("===== complicated groupingBy =====");
        Map<CaloricLevel, List<Dish>> groupingByCaloricLevel = menu.stream().collect(Collectors.groupingBy(dish -> {
            if (dish.getCalories() <= 400) return CaloricLevel.FAT;
            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
            else return CaloricLevel.FAT;
        }));
        System.out.println(groupingByCaloricLevel);

        System.out.println("===== groupingBy filtering =====");
        Map<Type, List<Dish>> groupingByTypeAndFiltering = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.filtering(dish -> dish.getCalories() > 500, Collectors.toList())));
        System.out.println(groupingByTypeAndFiltering);

        System.out.println("===== groupingBy mapping =====");
        Map<Type, List<String>> groupingByTypeAndMapping = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(Dish::getName, Collectors.toList())));
        System.out.println(groupingByTypeAndMapping);

        System.out.println("===== double step grouping =====");
        Map<Type, Map<CaloricLevel, List<Dish>>> groupingTwoStep = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                })));
        System.out.println(groupingTwoStep);

        System.out.println("===== grouping optional data collect =====");
        Map<Type, Optional<Dish>> optionalCollect = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(optionalCollect);

        System.out.println("===== grouping data collect without Optional =====");
        Map<Type, Dish> collectWithoutOptional = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                        Optional::get
                )));
        System.out.println(collectWithoutOptional);

    }

}
