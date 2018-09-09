package rx.learnbasics;

import io.reactivex.Maybe;

public class UseMayBe {

    public static void main(String[] args) {

        Maybe<Integer> maybe=Maybe.just(100);

        Maybe<Integer> maybe1=Maybe.empty();

        maybe.subscribe(System.out::println);
        maybe1.subscribe(System.out::println);
    }
}
