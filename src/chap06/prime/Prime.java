package chap06.prime;

import java.util.stream.IntStream;

public class Prime {

    public boolean isPrime(int candidate) {
        // 다음 코드로 소수의 대상을 제곱근 이하의 수로 제한 가능
        int candidateRoot = (int) Math.sqrt((double) candidate);
        // 2부터 candidate 자연수 생성, 스트림의 모든 정수로 candidate 나눌 수 없으면 참을 반환
        return IntStream.range(2, candidate)
                .noneMatch(i -> candidate % i == 0);
    }

    public static void main(String[] args) {

    }

}
