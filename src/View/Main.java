package View;

import Model.MyModel;
import Server.*;
import ViewModel.MyViewModel;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MyModel model = new MyModel();
        MyViewModel myViewModel = new MyViewModel(model);
        model.addObserver(myViewModel);

        //TODO check if can be changed to IMODEL

        primaryStage.setTitle("The Incredible Maze!");
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("MyView.fxml").openStream());
        Scene scene = new Scene(root,800,700);
        scene.getStylesheets().add(getClass().getResource("ViewStyle.css").toExternalForm());

        MyViewController myViewController = fxmlLoader.getController();
        myViewController.setResizeEvent(scene);
        myViewController.setViewModel(myViewModel);
        myViewModel.addObserver(myViewController);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> myViewController.KeyPressed(event));

        primaryStage.setScene(scene);
        SetStageCloseEvent(primaryStage, myViewController);
        primaryStage.show();
        //myViewModel.generateMaze(10,10);



        //Rise Servers

    }

    private void SetStageCloseEvent(Stage primaryStage, MyViewController myViewController) {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent windowEvent) {
                myViewController.exitCorrectly();
                windowEvent.consume();
            }
        });
    }



    public static void main(String[] args) {



        launch(args);
    }
}
