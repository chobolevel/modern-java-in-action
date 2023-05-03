package chap03.quiz;

public class Quiz03 {

    // 다음 중 람다 표현식을 올바르게 사용한 코드는

    // 1번 코드
//    execute(() -> {})
//    public void execute(Runnable r) {
//        r.run()
//    }

    // 2번 코드
//    public Callable<String> fetch() {
//        return () -> "Hello, World";
//    }

    // 3번 코드
//    Predicate<Apple> p = (Apple a) -> a.getWeight()

    // result -> 1, 2
    // 3번 코드에서 Predicate 함수 디스크립터는 제네릭 타입을 받아 boolean을 반환하기 때문에 반환값이 맞지 않음

}
