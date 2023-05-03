package chap03.quiz;

public class Quiz04 {

    // 다음과 같은 함수형 디스크립터가 있을 때 어떤 함수형 인터페이스를 사용할 수 있을까?
    // 1) T -> R
    // 2) (int, int) -> int
    // 3) T -> void
    // 4) () -> T
    // 5) (T, U) -> R

    // result
    // 1) Function<T, R>
    // 2) IntBinaryOperator applyAsInt()
    // 3) Consumer accept()
    // 4) Supplier get(), Callable call()
    // 5) BiFunction(T, U, R) apply()

}
