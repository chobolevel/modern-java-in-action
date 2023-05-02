package chap02.quiz;

import chap02.entity.Apple;
import chap02.enums.Color;
import chap02.formatter.AppleFancyFormatter;
import chap02.formatter.AppleFormatter;
import chap02.formatter.AppleSimpleFormatter;

import java.util.ArrayList;
import java.util.List;

public class Quiz01 {

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter f) {
        for(Apple apple : inventory) {
            System.out.println(f.accept(apple));;
        }
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(Color.GREEN, 120));
        inventory.add(new Apple(Color.RED, 160));

        prettyPrintApple(inventory, new AppleFancyFormatter());
        prettyPrintApple(inventory, new AppleSimpleFormatter());

    }

}
