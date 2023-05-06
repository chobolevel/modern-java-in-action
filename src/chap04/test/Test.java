package chap04.test;

import chap04.entity.Dish;
import chap04.enums.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

//    기존 자바 코드
//    아래 코드에서는 lowCaloricDishes 라는 가비지 변수를 사용
//    즉, lowCaloricDishes 는 컨테이너 역할만 하는 중간 변수
//    List<Dish> lowCaloricDishes = new ArrayList<>();
//    for(Dish dish : menu) {
//        if(dish.getCalories() < 400) {
//            lowCaloricDishes.add(dish)
//        }
//    }
//    Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
//        public int compare(Dish dish1, Dish dish2) {
//            return Integer.compare(dish1.getCalories(), dish2.getCalories());
//        };
//    });
//    List<String> lowCaloriesDishesName = new ArrayList<>();
//    for(Dish dish : lowCaloricDishes) {
//        lowCaloriesDishesName.add(dish.getName());
//    }

//    최신 자바 코드
//    List<String> lowCaloricDishesName =
//        menu.stream()
//            .filter(d -> d.getCalories() < 400)
//            .sorted(comparing(Dish::getCalories))
//            .map(Dish::getName)
//            .collect(toList());
//    아래처럼 parallelStream 사용하면 멀티코어 아키텍처에서 병렬로 실행 가능
//    List<String> lowCaloricDishesName =
//        menu.parallelStream()
//            .filter(d -> d.getCalories() < 400)
//            .sorted(comparing(Dish::getCalories))
//            .map(Dish::getName)
//            .collect(toList());

    private List<Dish> menu = Arrays.asList(
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
    
    // Stream 예제
    // result -> 고칼로리 상위 3개 메뉴의 이름만 출력
    List<String> threeHighCaloricDishes = menu.stream()
            .filter(dish -> dish.getCalories() > 300)
            .map(Dish::getName)
            .limit(3)
            .toList();
    

}
