package rx.chap01;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Launcher {

    public static void sleep(long millis){

        try{
            Thread.sleep(millis);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

      Observable<String> observable=
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");


        observable.subscribe(System.out::println);

        observable.map(s->s.length()).subscribe(System.out::println);

        //The key difference between an observable and stream is that observable pushes data
        //whereas as a stream pulls data, this has implications. Stream is better for static data
        //Whereas observable may be better for dynamic data.


        Observable<Long> secondInterval=
                Observable.interval(1, TimeUnit.SECONDS);


        secondInterval.subscribe(s->{

            System.out.println(s);

        });

        sleep(5000);

    }
}
