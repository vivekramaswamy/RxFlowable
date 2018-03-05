package rx.chap01;

import io.reactivex.Observable;

public class LaunchWithEmitter {


    public static void main(String[] args) {


        Observable<String> observable=Observable.create(source->{

            try{
                source.onNext("Alpha");
                source.onNext("Beta");
                source.onNext("Gamma");
                source.onNext("Delta");
                source.onNext("Epsilon");

            }catch (Throwable ex){
                source.onError(ex);
            }

            }
           );

        observable.subscribe(System.out::println, Throwable::printStackTrace);

        //Now we will call intermediate operations between the observable and the source.

        observable.map(String::length).filter(integer -> integer<=5).subscribe(System.out::println);


    }
}
