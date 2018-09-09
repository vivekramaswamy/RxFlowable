package rx.chap03;


import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

import static rx.chap01.Launcher.sleep;

public class ObservableInterval {

    public static void main(String[] args) {

        ConnectableObservable<Long> connectableObservable=
                Observable.interval(1, TimeUnit.SECONDS).publish();

        connectableObservable.subscribe(i->System.out.println("Observable 1: "+ i));
        connectableObservable.connect();

        sleep(5000);

        connectableObservable.subscribe(i->System.out.println("Observable 2: "+ i));

        sleep(5000);

        connectableObservable.subscribe(i->System.out.println("Observable 3: "+ i));

        sleep(5000);
    }
}
