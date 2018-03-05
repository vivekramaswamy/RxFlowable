package rx.chap01;


import io.reactivex.Observable;

public class LaunchWithJust {

    public static void main(String[] args) {

        //Instead of using create we an use just for less than 10 items
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .map(String::length)
                .filter(integer -> integer<=5)
                .subscribe(System.out::println);


    }
}
