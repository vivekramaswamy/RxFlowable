package rx.chap03;

import io.reactivex.Observable;
import io.reactivex.annotations.Beta;
import io.reactivex.observables.ConnectableObservable;

public class ConnectableObser {

    public static void main(String[] args) {

        ConnectableObservable<String> connectableObservable=
                Observable.just("Alpha", "Beta","Gamma", "Delta", "Epsilon").publish();

        //First subscriber
        connectableObservable.subscribe(System.out::println);

        //Second subscriber
        connectableObservable.map(String::length).subscribe(System.out::println);


        connectableObservable.connect();

    }
}
