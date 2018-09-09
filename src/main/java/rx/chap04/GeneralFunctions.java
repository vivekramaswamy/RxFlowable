package rx.chap04;

import io.reactivex.Observable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GeneralFunctions {

    public static void main(String[] args) {

        Observable.range(1,100)
                .takeWhile(i->i<=5)
                .subscribe(System.out::println);

        Observable.range(1,100)
                .skipWhile(i->i<90)
                .subscribe(System.out::println);


        Observable.just("Alpha", "Beta", "Gamma", "Epsilon", "Delta")
                .map(String::length)
                .distinct()
                .subscribe(System.out::println);

        Observable.just("Alpha", "Beta", "Gamma", "Epsilon", "Delta")
                .distinct(String::length)
                .subscribe(System.out::println);


        Observable.just(1,1,2,3,3,3,4,5,5,6)
                .distinctUntilChanged()
                .subscribe(System.out::println);

        Observable.just("Alpha", "Blpha", "Beta", "Gamma", "Epsilon", "Delta")
                .distinctUntilChanged(String::length)
                .subscribe(System.out::println);


        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("d/M/yyyy");

        Observable.just("2/2/2020", "5/3/1999", "12/12/2001", "23/11/2006")
                .map(s->LocalDate.parse(s, dtf))
                .subscribe(i-> System.out.println("Received: "+ i));



    }
}
