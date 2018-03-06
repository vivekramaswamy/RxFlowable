package rx.chap01;

import io.reactivex.Observable;

public class ObservableEmpty {


    public static void main(String[] args) {


                Observable.empty().subscribe(System.out::println,
                        Throwable::printStackTrace, ()-> System.out.println("Complete"));
    }
}
