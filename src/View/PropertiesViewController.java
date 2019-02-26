package View;

import Server.Configurations;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PropertiesViewController extends Dialog implements Initializable {

    private String algorithmString;
    private String generatorString;
    private int threadNum;
     public ChoiceBox algorithmChoiceBox;
     public ChoiceBox mazeGeneratorChoiceBox;
     public Spinner spinner;
     public SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
    private Stage stage;


    public void saveChanges(){
         System.out.println("Properties: saveChanges");
         algorithmString = (String)algorithmChoiceBox.getValue();
         generatorString = (String)mazeGeneratorChoiceBox.getValue();
        threadNum = (Integer)spinner.getValue();
        System.out.println(generatorString);
        System.out.println(algorithmString);
        System.out.println(spinner.getValue());
        Configurations.setNewProperties(threadNum,algorithmString, generatorString);

        Configurations.run();
        stage.close();
     }

     public void setStage(Stage stage){
         this.stage = stage;
     }


    public void closeButton(){
        System.out.println("Properties: closeButton");
        stage.close();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        valueFactory.setValue(Configurations.getServer_threadPoolSize());
        spinner.setValueFactory(valueFactory);
        algorithmChoiceBox.getItems().addAll("BestFirstSearch","DepthFirstSearch","BreadthFirstSearch");
        String searchValue = Configurations.getValue("algorithms_solveAlgorithm");
        algorithmChoiceBox.setValue(searchValue);
        mazeGeneratorChoiceBox.getItems().addAll("myMazeGenerator","simpleMazeGenerator");
        String generateValue = Configurations.getValue("algorithms_mazeGenerateAlgorithm");
        mazeGeneratorChoiceBox.setValue(generateValue);

    }
}
