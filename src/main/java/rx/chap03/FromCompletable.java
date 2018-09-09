package rx.chap03;

import io.reactivex.Completable;


public class FromCompletable {

    public static void main(String[] args) {

        Completable.fromRunnable(()->runProcess())
        .subscribe(()-> System.out.println("DOne"));
    }

    private static void runProcess() {

        System.out.println("Finishes runnable");
    }
}
