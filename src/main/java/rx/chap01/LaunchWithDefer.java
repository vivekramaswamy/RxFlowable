package rx.chap01;



import io.reactivex.Observable;

import java.util.concurrent.CompletionService;

public class LaunchWithDefer {

    private static int start =1;
    private static int count =5;

    public static void main(String[] args) {
        Observable<Integer> source=
                Observable.defer(()->Observable.range(start, count));

        source.subscribe(s-> System.out.println("Source 1: "+ s));

        count=10;

        source.subscribe(s-> System.out.println("Source 2: "+ s));


        Observable.fromCallable(()->1/0).subscribe(System.out::println,
                e-> System.err.println("Caught error"));



    }
}
