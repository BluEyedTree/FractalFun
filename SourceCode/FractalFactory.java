/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractalfun;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Tom
 */
public class FractalFactory {


   public FractalFactory(){ 
    }
   
   public static FractalShape makeFractal(int selectionFractal , Color inputColor, Canvas inputCanvas){
       if(selectionFractal==1){
          
          Tree newTree = new Tree(10, inputCanvas ,0, 60, .50, inputColor);
          return newTree;  
        }
       else {
           
          StochasticTree newSTree = new StochasticTree(10, inputCanvas ,0, 60, .50, inputColor);
          return newSTree;  
       }
   
    }
}
