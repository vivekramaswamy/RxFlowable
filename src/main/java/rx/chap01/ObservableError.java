package rx.chap01;

import io.reactivex.Observable;

public class ObservableError {

    public static void main(String[] args) {

        Observable.error(()->new Exception("Crash and burn...."))
                .subscribe(System.out::println,
                        Throwable::printStackTrace,
                        ()-> System.out.println("Finishes"));
    }

}
