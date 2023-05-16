package chap08.test;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        System.out.println("===== List Factory =====");
        // 고정 크기의 List 추가/삭제 불가능
        List<String> friends = List.of("Raphael", "Olivia", "Thibaut");
        System.out.println(friends);

    }
}
