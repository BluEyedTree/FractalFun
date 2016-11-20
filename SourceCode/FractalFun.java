/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractalfun;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.SepiaTone;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Tom
 */
public class FractalFun extends Application {
   Button button1,button2,greenButton,yellowButton,blueButton, redButton, pinkButton;
   FlowPane FractalDisplayPane;
   Scene scene1, scene2;
   Stage thestage, newStage;
   Tree tree;
   StochasticTree stree;
   Color FractalColor;
   public int tCounter=0;
   public int stCounter=0;
   
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fractal Fun");
        FlowPane FractalDisplayPane=new FlowPane(); //This is where the new fract scene will be placed
        Stage newStage = new Stage(); //The new stage that will have the fractal stuff in it
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text scenetitle = new Text("Choose Your Color Then Fractal Type");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(scenetitle, 0, 0, 5, 1);
        
        //This sections Creates the color buttons and their actions
        Button greenButton = new Button();
        greenButton.setStyle("-fx-font: 10 arial; -fx-base: #78AB46;");
        grid.add(greenButton, 0, 1);
        Button blueButton = new Button();
        blueButton.setStyle("-fx-font: 10 arial; -fx-base: #007FFF;");
        grid.add(blueButton, 1, 1);
        Button yellowButton = new Button();
        yellowButton.setStyle("-fx-font: 10 arial; -fx-base: #FFFF00;");
        grid.add(yellowButton, 2, 1);
        Button redButton = new Button();
        redButton.setStyle("-fx-font: 10 arial; -fx-base: #ff0000;");
        grid.add(redButton, 3, 1);
        Button pinkButton = new Button();
        pinkButton.setStyle("-fx-font: 10 arial; -fx-base: #FFC0CB;");
        grid.add(pinkButton, 4, 1);
        //Color button action handling
        greenButton.setOnAction(e-> greenColorButtonClicked(e));
        blueButton.setOnAction(e-> blueColorButtonClicked(e));
        redButton.setOnAction(e-> redColorButtonClicked(e));
        yellowButton.setOnAction(e-> yellowColorButtonClicked(e));
        pinkButton.setOnAction(e-> pinkColorButtonClicked(e));
        
        //scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
 
        Button button1 = new Button();
      
        
        button1.setStyle("-fx-font: 22 arial; -fx-base: #000000;");
        grid.add(button1, 0, 2);
        Text button1AdjText = new Text("Normal Tree Fracal");
        grid.add(button1AdjText, 1, 2);
        Button button2 = new Button();
        button2.setStyle("-fx-font: 22 arial; -fx-base: #000000;");
        grid.add(button2, 0, 3);
        Text button2AdjText = new Text("Stochasic Tree Fracal");
        grid.add(button2AdjText, 1, 3);
        button1.setOnAction(e-> Button1Clicked(e));
        button2.setOnAction(e-> Button2Clicked(e));
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
 private void Button1Clicked(ActionEvent e) {
  {
            tCounter = 0;
            System.out.println("test");
            Group root = new Group();
            newStage = new Stage();
            Canvas canvas = new Canvas(1000, 1000);
            tree = (Tree) FractalFactory.makeFractal(1,FractalColor,canvas); 
            root.getChildren().add(canvas);
            Button iter = new Button();
            iter.setOnAction(a-> treeButtonClicked(a));
            root.getChildren().add(iter);
            newStage.setScene(new Scene(root));
            newStage.setTitle("Fractal Tree");
            newStage.show();
     
 }
 }
 
 private void Button2Clicked(ActionEvent e) {
            stCounter = 0;
            newStage = new Stage();
            newStage.setTitle("Stochasitc Fractal Tree");
            //Create scene with the stochastic Fractal tree showing
            Group root = new Group();
            Canvas canvas = new Canvas(1000, 1000);
            stree = (StochasticTree) FractalFactory.makeFractal(0,FractalColor,canvas); 
            root.getChildren().add(canvas);
            Button iter = new Button();
            iter.setOnAction(a-> streeButtonClicked(a));
            root.getChildren().add(iter);
            newStage.setScene(new Scene(root));
            newStage.show();
     
 }
 
  private void streeButtonClicked(ActionEvent a){
        stCounter +=1;
        stree.setCurrentDepth(stCounter);
        stree.drawCurrentLevel();
 }
 
 
 private void treeButtonClicked(ActionEvent a){
        tCounter +=1;
        tree.setCurrentDepth(tCounter);
        tree.drawCurrentLevel();
 }
 
private void greenColorButtonClicked(ActionEvent e){
    FractalColor = Color.GREEN;
    
}

private void blueColorButtonClicked(ActionEvent e){
    FractalColor = Color.BLUE;
}

private void redColorButtonClicked(ActionEvent e){
    FractalColor = Color.RED;
}

private void yellowColorButtonClicked(ActionEvent e){
    FractalColor = Color.YELLOW;
}

private void pinkColorButtonClicked(ActionEvent e){
    FractalColor = Color.PINK;
}

    public static void main(String[] args) {
        launch(args);
    }

   
    
}
