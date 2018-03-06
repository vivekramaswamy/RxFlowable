package rx.chap01;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class LauncherConnectable {

    public static void main(String[] args) {

        ConnectableObservable<Long> source=
                Observable.interval(1, TimeUnit.SECONDS).publish();

        source.subscribe(s-> System.out.println("Observer One: "+ s));

        source.connect();

        Launcher.sleep(5000);

        source.subscribe(s-> System.out.println("Observer Two: "+ s));

        Launcher.sleep(5000);
    }
}
