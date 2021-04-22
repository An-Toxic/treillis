/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.treillis;

import java.io.BufferedWriter;
import java.io.IOException;
import static java.lang.Math.acos;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author cz
 */
public abstract class Noeud_appui extends Noeud {
    public Triangle_terrain triangle;
    protected double alpha;
    protected int numero ;
    protected Segment_terrain seg;
    public Noeud_appui(int identite ,Triangle_terrain TT , int num,double pos){
        super(identite);
        numero =num;
        triangle = TT;
        seg = new Segment_terrain(TT.tbpoint[numero],TT.tbpoint[(numero+1)%3]);
        if(pos<=1 && pos>=0){
             alpha= pos ;
        }
        else {
            throw new Error ("alpha must be between 0 and 1");
        }
            
        
        
    }
    public double getPx(){
        return this.alpha*triangle.tbpoint[numero].px+(1-alpha)*triangle.tbpoint[(numero+1)%3].px ;
        }                
    public double getPy(){
        return this.alpha*triangle.tbpoint[numero].py+(1-alpha)*triangle.tbpoint[(numero+1)%3].py;
}
    //calculer l'angle entre le vecteur normale au segment du terrain correspandant au noeud et l'horizontale
    public double getBeta(){
        
        double a =(seg.pt2.px-seg.pt1.px)/(seg.getLength());
        return Math.PI/2+acos(a);
    }
    public void drawNoeud(GraphicsContext gc){
        
    }

       
   }

