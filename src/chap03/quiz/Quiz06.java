package chap03.quiz;

public class Quiz06 {

    // 다음의 람다 표현식과 일치하는 메서드 참조를 작성
    // 1) ToIntFunction<String> stringInt = (String s) -> Integer.parseInt(s);

    // 2) BiPredicate<List<String, String> contains = (list, el) -> list.contains(el);

    // 3) Predicate<String> startsWithNumber = (String str) -> this.startsWithNumber(str);

    // result
    // 1) ToIntFunction<String> stringInt = Integer::parseInt;

    // 2) BiPredicate<List<String> String> contains = List::contains;

    // 3) Predicate<String> startsWithNumber = this::startsWithNumber;

}
