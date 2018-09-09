package rx.chap03;


import io.reactivex.Observable;

public class EmptyObservable {

    public static void main(String[] args) {

        Observable<String> observable=
                Observable.empty();

        observable.subscribe(System.out::println, Throwable::printStackTrace, ()->System.out.println("Completed"));

        Observable.error(new Exception("Crash and burn..."))
                .subscribe(System.out::println, Throwable::printStackTrace, ()->System.out.println("Done"));


    }
}
