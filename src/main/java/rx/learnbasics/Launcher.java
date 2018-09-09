package rx.learnbasics;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Launcher {


    public static Observable<String> getSampleObservable(){

        return Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
    }

    public static void sleep(long timeToSleep){

        try {
            Thread.sleep(timeToSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


        //Output all items in the observable
        System.out.println("Output all items in the observable");
        Launcher.getSampleObservable().subscribe(System.out::println);

        //Convert String to length and emit the length
        System.out.println("Convert the observable String to it's length and emit the length");
        Launcher.getSampleObservable().map(s->s.length()).subscribe(System.out::println);

        //Emit event every one second. The thing to remember is that observable runs in its own thread
//        RxJava runs observable in a computation thread
        System.out.println("Emit an event every 1 second");
        Observable.interval(1, TimeUnit.SECONDS).subscribe(System.out::println);

        sleep(6000);

    }
}
