package Model;

import algorithms.mazeGenerators.Maze;

import java.io.Serializable;

public class MazeDisplayState implements Serializable {

    private Maze maze;
    private MazeCharacter mazeCharacter;

    public MazeDisplayState(Maze newMaze, MazeCharacter newMazeCharacter){
        this.maze = newMaze;
        this.mazeCharacter = newMazeCharacter;
    }

    public Maze getMaze() {
        return maze;
    }

    public MazeCharacter getMazeCharacter() {
        return mazeCharacter;
    }
}
