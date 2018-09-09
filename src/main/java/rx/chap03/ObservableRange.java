package rx.chap03;


import io.reactivex.Observable;

public class ObservableRange {

    public static void main(String[] args) {

        Observable.range(0,10).map(i->i+3).subscribe(i->System.out.println("Received "+ i));
    }
}
