package Model;

import algorithms.mazeGenerators.Maze;
import javafx.scene.input.KeyCode;

import java.io.File;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public interface IModel {

    void generateMaze(int width,int height);
    void moveCharacter(KeyCode movement);
    void generateSolution();
    char[][] getMaze();
    int getMainCharacterPositionRow();
    int getMainCharacterPositionColumn();
    int getSecondCharacterPositionRow();
    int getSecondCharacterPositionColumn();
    String getMainCharacterDirection();
    String getSecondCharacterDirection();
    void closeModel();
    boolean isAtTheEnd();
    int[][] getSolution();
    int[][] getMazeSolutionArr();
    void saveCurrentMaze(File file,String name);
    void saveOriginalMaze(File file, String name);
    void loadMaze(File file);

    MazeCharacter getLoadedCharacter();


    void setMultiPlayerMode(boolean setMode);
}
