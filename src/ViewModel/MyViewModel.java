package ViewModel;

import Model.IModel;
import Model.MazeCharacter;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

public class MyViewModel extends Observable implements Observer {

    private IModel model;
    private MediaPlayer gameSoundTrack;
    private boolean isPlayed = true;
    private MazeCharacter mainCharacter = new MazeCharacter("Crash_",0,0);
    private MazeCharacter secondCharacter = new MazeCharacter("Crash_Second_",0,0);


    public MyViewModel(IModel model) {
        this.model = model;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o == model){
            if(arg != null) {
                String argument = (String) arg;
                if(argument == "Maze Load") {
                    secondCharacter.setCharacterName(model.getLoadedCharacter().getCharacterName() + "Second_");
                    secondCharacter.setCharacterRow(model.getMainCharacterPositionRow());
                    secondCharacter.setCharacterCol(model.getMainCharacterPositionColumn());
                    startSoundTrack(model.getLoadedCharacter().getCharacterName());
                }
            }
            setChanged();
            notifyObservers(arg);
        }
    }

    public boolean isPlayed(){
        return isPlayed;
    }

    public void setMainCharacterName(String character){
        mainCharacter.setCharacterName(character);
    }



    public void moveCharacter(KeyCode movement){
        model.moveCharacter(movement);
    }

    public void generateMaze(int row, int col){
        model.generateMaze(row, col);
    }

    public char[][] getMaze() {
        return model.getMaze();
    }

    public int getMainCharacterPositionRow() {
        return model.getMainCharacterPositionRow();
    }
    public int getMainCharacterPositionColumn() {
        return model.getMainCharacterPositionColumn();
    }
    public String getMainCharacterDirection() {
        return model.getMainCharacterDirection();
    }
    public String getMainCharacterName(){ return mainCharacter.getCharacterName();}

    public int getSecondCharacterPositionRow() {
        return model.getSecondCharacterPositionRow();
    }
    public int getSecondCharacterPositionColumn() {
        return model.getSecondCharacterPositionColumn();
    }
    public String getSecondCharacterDirection() {
        return model.getSecondCharacterDirection();
    }
    public String getSecondCharacterName(){ return secondCharacter.getCharacterName();}


    public boolean isAtTheEnd() {
        return model.isAtTheEnd();
    }

    public int[][] getSolution(){
        return model.getSolution();
    }

    public int[][] getMazeSolutionArr(){
        return model.getMazeSolutionArr();
    }

    public void generateSolution(){
        model.generateSolution();
    }

    public void saveOriginalMaze(File file){
        model.saveOriginalMaze(file,mainCharacter.getCharacterName());
    }

    public void saveCurrentMaze(File file){
        model.saveCurrentMaze(file,mainCharacter.getCharacterName());
    }

    public void loadFile(File file){

        model.loadMaze(file);
    }

    public void closeModel(){
        model.closeModel();
    }

    public void startSoundTrack(String character){
        if (gameSoundTrack != null)
            gameSoundTrack.stop();
        String musicFile = "Resources/Music/" + character + "gameSoundTrack.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        gameSoundTrack = new MediaPlayer(sound);
        gameSoundTrack.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                gameSoundTrack.seek(Duration.ZERO);
            }
        });
        if(isPlayed){
            gameSoundTrack.play();
        }
        /*gameSoundTrack.play();
        isPlayed = true;*/

    }

    public boolean setSound(){
        if (gameSoundTrack == null)
            isPlayed = !isPlayed;
        else {
            gameSoundTrack.play();
            if (isPlayed) {
                /*gameSoundTrack.stop();*/
                gameSoundTrack.setMute(true);
                isPlayed = false;
            } else {
                /*gameSoundTrack.play();*/
                gameSoundTrack.setMute(false);
                isPlayed = true;
            }
        }
        return isPlayed;
    }

    public void setSecondCharacterName(String secondCharacterName) {
        this.secondCharacter.setCharacterName(secondCharacterName);
    }

    public MazeCharacter getLoadedCharacter() {
        mainCharacter = model.getLoadedCharacter();
        return mainCharacter;
    }

    public void setMultiPlayerMode(boolean setMode){
        model.setMultiPlayerMode(setMode);
    }



}
