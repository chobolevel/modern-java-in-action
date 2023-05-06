package chap04.quiz;

import chap04.entity.Dish;
import chap04.enums.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Quiz01 {

    // 리팩터링을 어떻게 하면 가능할까?
//    List<String> highCaloricDishes = new ArrayList<>();
//    Iterator<String> iterator = menu.iterator();
//    while(iterator.hasNext()) {
//        Dish dish = iterator.next();
//        if(dish.getCalories() > 300) {
//            highCaloricDishes.add(dish.getName());
//        }
//    }

    // filter 패턴 작성
//    List<String> highCaloricDish = menu.stream()
//            .filter(dish -> dish.getColories() > 300)
//            .map(Dish::getName)
//            .toList();


}
