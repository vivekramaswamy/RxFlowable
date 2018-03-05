package rx.chap01;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class LaunchWithObservables {

    public static void main(String[] args) {

        List<String> list=
                Arrays.asList("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        Observable.fromIterable(list)
                .map(String::length)
                .filter(integer -> integer<=5)
                .subscribe(System.out::println);

    }
}
