package rx.chap03;

import io.reactivex.Observable;

/**
 * When your observable source is not capturing change to the things driving it,
 * try putting it in observable.defer()
 */
public class DeferObservable {

    public static int start =0;
    public static int count = 5;
    public static void main(String[] args) {
        Observable<Integer> observable=
                Observable.defer(()->Observable.range(start, count));


        observable.subscribe(i->System.out.println("before changing count "+ i));

        count =10;

        observable.subscribe(i->System.out.println("after changing count "+ i));
    }
}
