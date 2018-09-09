package rx.chap03;

import io.reactivex.Observable;

public class DisposeEmitter {

    public static void main(String[] args) {

        Observable<Integer> source=
                Observable.create(observableEmitter -> {

                   for (int i=0; i<100; i++){
                       while(!observableEmitter.isDisposed()){
                           observableEmitter.onNext(i);
                       }

                   }

                });
    }
}
