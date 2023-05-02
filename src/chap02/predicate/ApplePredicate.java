package chap02.predicate;

import chap02.entity.Apple;

public interface ApplePredicate {
    boolean test(Apple apple);
}
