package rx.chap03;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

import static rx.chap01.Launcher.sleep;

/**
 * Composite decomposable
 */
public class DComposite {

    public static final CompositeDisposable disposableList=
            new CompositeDisposable();

    public static void main(String[] args) {

        Disposable d1 =
                Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(s-> System.out.println("O1: "+ s));


        Disposable d2=
                Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(s-> System.out.println("02: "+ s));


        sleep(5000);

        disposableList.addAll(d1, d2);

        disposableList.dispose();

        sleep(5000);





    }
}
