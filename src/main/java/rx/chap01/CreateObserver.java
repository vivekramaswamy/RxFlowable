package rx.chap01;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CreateObserver {

    public static void main(String[] args) {
        Observable<String> observable=
                Observable.just("Alpha","Beta", "Gamma", "Delta", "Epsilon");



        observable.map(String::length).filter(i->i<=5).subscribe(
                s-> System.out.println("Received: "+ s),
                Throwable::printStackTrace,
                ()-> System.out.println("Completed")
        );


    }
}
