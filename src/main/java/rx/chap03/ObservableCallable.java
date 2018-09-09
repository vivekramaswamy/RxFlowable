package rx.chap03;

import io.reactivex.Observable;

public class ObservableCallable {

    public static void main(String[] args) {

        /**Observable.just(1/0)
                .subscribe(System.out::println, e->System.out.println("Thrown error "+ e.getMessage()));

**/
        Observable.fromCallable(()->1/0)
                .subscribe(System.out::println, e->System.out.println("Thrown error "+ e.getMessage()));

    }
}
