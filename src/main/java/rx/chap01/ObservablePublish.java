package rx.chap01;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.observables.ConnectableObservable;

public class ObservablePublish {

    public static void main(String[] args) {

        ConnectableObservable<String> observable=
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon").publish();


        observable.map(String::length)
                .subscribe(s->System.out.println("Source 1 "+ s));

        observable.subscribe(s-> System.out.println("Souce 2 "+ s));

        observable.connect();

        Observable.range(4,10).subscribe(System.out::println);



    }
}
