/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.treillis;

import static java.lang.Math.sqrt;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author cz
 */
public class Segment_terrain {
    protected Point pt1;
    protected Point pt2;
    
    public Segment_terrain(Point p1,Point p2){
        pt1=p1;
        pt2=p2;
    }
    //trouver la longueur d'un segment terrain
    public double getLength(){
        double a = (pt2.px-pt1.px)*(pt2.px-pt1.px)+(pt2.py-pt1.py)*(pt2.py-pt1.py);
        return sqrt(a);
    }
    public static void DrawSegment(GraphicsContext gc,Point p1,Point p2){
       gc.setStroke(Color.BLUE);
       gc.strokeLine(p1.px, p1.py, p2.px, p2.py);
        
    }
    public void DrawSegment(GraphicsContext gc){
        gc.setLineWidth(3);
        gc.setStroke(Color.BLUE);
        gc.strokeLine(pt1.px, pt1.py, pt2.px, pt2.py);
    }
}
