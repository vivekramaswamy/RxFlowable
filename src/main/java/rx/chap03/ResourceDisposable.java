package rx.chap03;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;

import java.util.concurrent.TimeUnit;

public class ResourceDisposable {

    public static void main(String[] args) {

        Observable<Long> observable=
                Observable.interval(1, TimeUnit.SECONDS);

        ResourceObserver<Long> observer=new ResourceObserver<Long>() {
            @Override
            public void onNext(Long aLong) {
                System.out.println(aLong);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Done");
            }
        } ;

        Disposable disposable=
                observable.subscribeWith(observer);
    }
}
