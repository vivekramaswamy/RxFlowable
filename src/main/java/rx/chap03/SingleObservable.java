package rx.chap03;

import io.reactivex.Observable;
import io.reactivex.Single;

public class SingleObservable {

    public static void main(String[] args) {

        Single.just("Hello World")
                .map(String::length).subscribe(System.out::println, Throwable::printStackTrace);

        Observable<String> observable=
                Observable.just("vicky", "vinny");


        observable
                .first("Nil").subscribe(System.out::println);





    }
}
