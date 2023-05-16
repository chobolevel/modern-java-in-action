package chap07.recursive;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

// RecursiveTask 상속받아 포크/조인 프레임워크에서 사용할 테스크 생성
public class ForkJoinSumCalculator extends RecursiveTask<Long> {
    private final long[] numbers; // 더할 숫자 배열
    private final int start; // 이 서브테스크에서 처리할 배열의 초기 위치
    private final int end; // 이 서브테스크에서 처리할 배열의 최종 위치
    public static final long THRESHOLD = 10_000; // 이 값 이하의 서브테스크는 더 이상 분할할 수 없음

    // 메인 테스크를 생성할 때 사용할 공개 연산자
    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    // 메인 테스크의 서브테크스를 재귀적으로 만들 때 사용할 비공개 생성자
    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    // RecursiveTask 추상 메서드
    @Override
    protected Long compute() {
        // 이 테스크에서 더할 배열의 길이
        int length = end - start;
        
        // 기준값과 같거나 작으면 순차적으로 결과를 계산
        if(length <= THRESHOLD) {
            return computeSequentially();
        }
        
        // 배열의 첫 번째 절반을 더하도록 서브테스크를 생성
        ForkJoinSumCalculator leftTask =
                new ForkJoinSumCalculator(numbers, start, start + length/2);
        // ForkJoinPool 다른 스레드로 새로 생성한 테스크를 비동기로 실행        
        leftTask.fork();
        // 배열의 나머지 절반을 더하도록 서브테스크 생성
        ForkJoinSumCalculator rightTask =
                new ForkJoinSumCalculator(numbers, start + length/2, end);
        // 두 번째 서브테스크를 동시 실행, 이떄 추가로 분할이 일어날 수 있음
        Long rightResult = rightTask.compute();
        // 첫 번째 서브테스크의 결과를 읽거나 없다면 기다림
        Long leftResult = leftTask.join();
        // 두 테스크의 결과를 조합한 값이 이 테스크의 결과값이 되고 이를 반환
        return leftResult + rightResult;
    }

    // 분할할 수 없을 때 서브테스크의 결과를 계산하는 단순한 알고리즘
    private long computeSequentially() {
        long sum = 0;
        for(int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    // ForkJoinSumCalculator 생성자로 원하는 수의 배열을 넘겨줄 수 있음
    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.range(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }

}
