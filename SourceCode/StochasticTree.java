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
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;



public class StochasticTree extends FractalShape{

    double bendAngle;
    double branchAngle;
    double branchRatio;
    public Color ccolor;
    double treeX    = canvasWidth/2;
    double treeY    = canvasHeight;
    double treeLen;

    public StochasticTree(int maxDepth, Canvas canvas,double bendAngle, double branchAngle, double branchRatio, Color color) {
        super(maxDepth, canvas);
        setCurrentDepth(1);
        this.ccolor = color;
        int random1 = (int)(Math.random());
        int random2 = (int)(Math.random());
        this.bendAngle = Math.toRadians(bendAngle);
        this.branchAngle = Math.toRadians(branchAngle);
        this.branchRatio = branchRatio;

        if(branchRatio == .65){
            treeLen = canvasHeight / 3;
        } else{
            treeLen = canvasHeight / 3 * 1.2;
        }

        this.p = 3;
        this.s = 2;
    }

    @Override
    void drawLevel0() {}

    @Override
    public void drawCurrentLevel() {
        drawTree(getCurrentDepth(), treeX, treeY,-Math.PI/2, treeLen);
        //updateFractalDimension(getCurrentDepth());
    }

    public void drawTree(int n, double x, double y, double a, double branchRadius) {

        if(n > 0){
            double cx = x + Math.cos(a) * branchRadius;
            double cy = y + Math.sin(a) * branchRadius;
            //Changes stroke color
            gContext.setStroke(ccolor);
            gContext.strokeLine(x, y, cx, cy);
            if (n == 0) return;
            bendAngle = (int)(Math.random()*180);
            
            
           
           
            drawTree(n - 1, cx, cy, a + bendAngle - branchAngle, branchRadius * branchRatio);
            drawTree(n - 1, cx, cy, a + bendAngle + branchAngle, branchRadius * branchRatio);
            drawTree(n - 1, cx, cy, a + bendAngle, branchRadius * (1 - branchRatio));
        }
    }
}

