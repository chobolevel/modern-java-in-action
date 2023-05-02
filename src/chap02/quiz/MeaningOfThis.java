package chap02.quiz;

public class MeaningOfThis {
    
    // quiz 2) 다음 코드를 실행한 결과는 4, 5, 6, 42 중 어느 것?
    
    private final int value = 4;
    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            private final int value = 5;
            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }

    public static void main(String[] args) {
        MeaningOfThis m = new MeaningOfThis();
        m.doIt();
    }
    
    // result -> this 는 MeaningOfThis 가 아니라 Runnable 을 참조하므로 5가 정답
    
}
