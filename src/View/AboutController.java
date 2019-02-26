package View;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutController implements Initializable {
    public javafx.scene.control.Button close;
    public javafx.scene.control.Label Itext;

    public void close(){
        Stage s = (Stage)close.getScene().getWindow();
        s.close();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Itext.setWrapText(true);
        Itext.setText("\nThis game was created as a project in the course\n" +
                        "'Advanced Topics in Programming, taken in 'Ben Gurion University' of Israel,\n" +
                        "as part of the 'Software and Information Systems Engineering' program.\n" +
                        "Created on our second year of studying on 2018.\n\n" +
                        "The Creators:\n" +
                        "   Yonatan Zax\n" +
                        "   Roy Dor\n\n" +
                        "Algorithms used in the game:\n\n" +
                        "   Maze Generating:\n" +
                        "       - Prim algorithm for generating mazes\n" +
                        "       - Simple algorithm\n\n" +
                        "   Solving Mazes:\n" +
                        "       - BreadthFirstSearch\n" +
                        "       - DepthFirstSearch\n" +
                        "       - BestFirstSearch\n\n" +
                        "The Design  Patterns used in the game:\n\n");
        //TODO maybe add the design pattens used
    }
}