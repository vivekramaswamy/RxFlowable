package rx.chap01;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import javafx.application.Application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyJavaFx extends Application{

    private static <T> Observable<T> valueOf(final ObservableValue<T> fxObservable){
        return
                Observable.create(ObservableEmitter ->
                {
                   //Emit initial state
                   ObservableEmitter.onNext(fxObservable.getValue());

                   //Emit value changes uses a listener
                    final ChangeListener<T> listener=
                            (observableVale, prev, current)->
                                    ObservableEmitter.onNext(current);
                    fxObservable.addListener(listener);
                });
    }

    @Override
    public void start(Stage stage) throws Exception {
        ToggleButton toggleButton=
                new ToggleButton("TOGGLE ME");

        Label label=new Label();

        Observable<Boolean> selectedState= valueOf(toggleButton.selectedProperty());

        selectedState.map(selected->selected?"DOWN":"UP")
                .subscribe(label::setText);

        VBox vBox=
                new VBox(toggleButton, label);

        stage.setScene(new Scene(vBox));
        stage.show();

    }
}
