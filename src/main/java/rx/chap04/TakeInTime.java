package rx.chap04;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

import static rx.chap01.Launcher.sleep;

public class TakeInTime {

    public static void main(String[] args) {

        Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(2, TimeUnit.SECONDS)
                .subscribe(System.out::println);


        sleep(5000);
    }
}
