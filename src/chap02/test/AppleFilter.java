package chap02.test;

import chap02.entity.Apple;
import chap02.enums.Color;
import chap02.predicate.ApplePredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppleFilter {

    // 1) 녹색 사과 필터링
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(apple.getColor() == Color.GREEN) {
                result.add(apple);
            }
        }
        return result;
    }

    // 2) 동적으로 다양한 색의 사과 필터링
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(apple.getColor() == color) {
                result.add(apple);
            }
        }
        return result;
    }

    // 3) 동적으로 다양한 무게의 사과 필터링
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    // 4) 동적으로 다양한 색, 무게의 사과 필터링
    // 각각 색 또는 무게로 구분할지에 대한 flag 설정 -> 절대 권장되지 않음
    // 이유: 기본적으로 flag 의미 알기 어려움, 구분 파라미터 추가하면 flag 설정의 어려움
    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if((flag && apple.getColor() == color) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    // 5) 추상적 조건으로 필터링(동작 파라미터화) -> Predicate 구현체를 파라미터로 받음(메서드를 파라미터로)
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    // 6) 익명 클래스를 사용하여 ApplePredicate 구현체 전달
    List<Apple> redApples = filterApples(new ArrayList<>(), new ApplePredicate() {
        @Override
        public boolean test(Apple apple) {
            return apple.getColor() == Color.RED;
        }
    });

    // 7) 람다식을 사용하여 ApplePredicate 구현체 전달
    List<Apple> result = filterApples(new ArrayList<>(), (apple) -> {
       return apple.getColor() == Color.RED;
    });

    // 8) 리스트 형식으로 추상화 -> Apple 뿐만 아닌 다양한 객체에 대해 필터링 가능한 메서드
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for(T t : list) {
            if(p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
    // 사용 예시
//    List<Apple> redApples = filter(inventory, (Apple apple) -> {
//        apple.getColor() == Color.RED
//    })

}
