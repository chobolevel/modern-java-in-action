package chap07.spliterator;

public class WordCounter {

    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    // 반복 알고리즘 처럼 accumulate 메서드는 문자열의 문자를 하나씩 탐색
    public WordCounter accumulate(Character c) {
        if(Character.isWhitespace(c)) {
            return lastSpace ? this : new WordCounter(counter, true);
        } else {
            // 문자열을 탐색하다가 공백 문자를 발견하면 지금까지 탐색한 문자를 단어로 간주하여 단어 수를 증가(공백 문자는 제외)
            return lastSpace ? new WordCounter(counter + 1, false) : this;
        }
    }

    public WordCounter combine(WordCounter wordCounter) {
        return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
    }

    public int getCounter() {
        return this.counter;
    }

}
