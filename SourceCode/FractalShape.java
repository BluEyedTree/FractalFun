/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractalfun;

/**
 *
 * @author Tom
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;


public abstract class FractalShape {

    protected double p;
    protected double s;

    private int maxDepth;
    private int currentDepth;
    public Color color;
    protected Canvas canvas;

    protected double canvasWidth, canvasHeight;
    protected GraphicsContext gContext;

    abstract void drawLevel0();


    public abstract void drawCurrentLevel();

    public FractalShape(int maxDepth, Canvas canvas) {
        this.maxDepth = maxDepth;
        this.canvas = canvas;
     
        
        gContext = canvas.getGraphicsContext2D();
        currentDepth = -1;

        initCanvasWidthHeight();
    }

    public void initCanvasWidthHeight(){
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();
    }

    public void setCurrentDepth(int currentDepth) {
        this.currentDepth = currentDepth;
    }

    public int getCurrentDepth(){
        return this.currentDepth;
    }

}