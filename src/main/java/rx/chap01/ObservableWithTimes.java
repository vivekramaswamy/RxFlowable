package rx.chap01;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableWithTimes {

    public static void main(String[] args) {
        Observable<Long> source=
                Observable.interval(1, TimeUnit.SECONDS);

        source.subscribe(s-> System.out.println("Source 1 "+ s));

        Launcher.sleep(5000);


        source.subscribe(s-> System.out.println("Source 2 "+ s));

        Launcher.sleep(5000);
    }
}
