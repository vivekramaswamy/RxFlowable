package rx.learnbasics;

import com.github.davidmoten.guavamini.Lists;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.List;


public class ObservableWorks {

    public static void main(String[] args) {
        Observable<String> observable=
                Observable.create(emitter->{


                    try {
                        emitter.onNext("Alpha");

                        emitter.onNext("Beta");
                        emitter.onNext("Gamma");
                        emitter.onNext("Delta");
                        emitter.onNext("Epsilon");
                        emitter.onNext("Theeta");

                    } catch (Exception e) {

                        emitter.onError(e);
                    }



                   emitter.onComplete();
                });

        observable.map(String::length).filter(length->length>=5).subscribe(System.out::println, Throwable::printStackTrace);

        //Observable from a collection

        List<String> list=List.of("Alpha", "Beta", "Gamma","Delta", "Epsilon");
        Observable.fromIterable(list).subscribe(System.out::println);

        //Create an observer to iterate over an observable.


        Observer<Integer> observer= new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Integer integer) {

                System.out.println("Consumed: "+ integer);
            }

            @Override
            public void onError(Throwable throwable) {
                    throwable.printStackTrace();

            }

            @Override
            public void onComplete() {

                System.out.println("Completed....");
            }
        };

        observable.map(String::length).subscribe(observer);

        //We can use Lamdas also to accomplish this

        observable.subscribe(System.out::println, Throwable::printStackTrace, ()-> System.out.println("Complete...Lamda"));

    }



}
