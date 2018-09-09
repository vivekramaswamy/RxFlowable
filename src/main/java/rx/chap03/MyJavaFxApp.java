package rx.chap03;

import io.reactivex.Observable;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyJavaFxApp extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        ToggleButton toggleButton=
                new ToggleButton("Toggle Me");

        Observable<Boolean> toggleObservable=
                valuesOf(toggleButton.selectedProperty());

        Label label
                =new Label();

        toggleObservable.map(b->b?"true":"false").subscribe(label::setText);

        VBox vBox=
                new VBox(toggleButton, label);

        primaryStage.setScene(new Scene(vBox));
        primaryStage.show();


    }

    public static <T> Observable<T> valuesOf(final ObservableValue<T> fxObservable) {

        return Observable.create(emittter->{
            emittter.onNext(fxObservable.getValue());

            //emit value changes uses a listener
            final ChangeListener<T> listener=
                    (observableValue, prev, current)->emittter.onNext(current);

            fxObservable.addListener(listener);
        });



    }


}
