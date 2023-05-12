package chap05.test;

import chap05.entity.Trader;
import chap05.entity.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Test {

    private static Trader raoul = new Trader("Raoul", "Cambridge");
    private static Trader mario = new Trader("Mario", "Milan");
    private static Trader alan = new Trader("Alan", "Cambridge");
    private static Trader brian = new Trader("Brian", "Cambridge");

    private static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    // 1) 2011년에 일어나 모든 트랙잭션 오름차순 정리
    // 2) 거래자가 근무하는 모든 도시를 중복 없이 나열
    // 3) 캠브리지에서 근무하는 모든 거래자를 찾아 이름순으로 정렬
    // 4) 모든 거래자의 이름을 알파벳순으로 정렬해서 반환
    // 5) 밀라노에 거래자 있는가?
    // 6) 케임브리지에 거주하는 거래자의 모든 트랜잭션 출력
    // 7) 전체 트랜잭션 중 최댓값은?
    // 8) 전체 트랜잭션 중 최솟값은?

    public static void main(String[] args) {

        List<Transaction> quiz01 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .toList();
        System.out.println("========== quiz01 ==========");
        System.out.println(quiz01);

        List<String> quiz02 = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .toList();
        System.out.println("========== quiz02 ==========");
        System.out.println(quiz02);

        List<Trader> quiz03 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .toList();
        System.out.println("========== quiz03 ==========");
        System.out.println(quiz03);

        List<String> quiz04 = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted()
                .toList();
        System.out.println("========== quiz04 ==========");
        System.out.println(quiz04);

        Optional<Trader> milan = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Milan"))
                .findFirst();
        // 아래 방법도 있음
        boolean milan1 = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        if(milan.isPresent()) {
            System.out.println("========== quiz05 ==========");
            System.out.println("milan is present!!!");
        }

        System.out.println("========== quiz06 ==========");
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        Integer max = transactions.stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::max);
        System.out.println("========== quiz07 ==========");
        System.out.println(max);

        Integer min = transactions.stream()
                .map(Transaction::getValue)
                .reduce(1000, Integer::min);
        System.out.println("========== quiz08 ==========");
        System.out.println(min);

    }

}
