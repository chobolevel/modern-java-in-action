package chap05.test;

import chap05.entity.Trader;
import chap05.entity.Transaction;

import java.util.Arrays;
import java.util.List;

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
    // 3) 케이브리지에서 근무하는 모든 거래자를 찾아 이름순으로 정렬
    // 4) 모든 거래자의 이름을 알파벳순으로 정렬해서 반환
    // 5) 밀라노에 거래자 있는가?
    // 6) 케임브리지에 거주하는 거래자의 모든 트랜잭션 출력
    // 7) 전체 트랜잭션 중 최댓값은?
    // 8) 전체 트랜잭션 중 최솟값은?

    public static void main(String[] args) {

    }

}
