/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.treillis;

import static java.lang.Math.acos;
import static java.lang.Math.sqrt;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import com.mycompany.projet_treillis.CanvasResizable;

/**
 *
 * @author cz
 */
public class Point {

    protected double px;
    protected double py;
    protected int id;

    public Point(double x, double y) {
        px = x;
        py = y;
    }
    public Point(Numerator num , double x , double y){
        this.px=x;
        this.py=y;
        num.getOrCreateKey(this);
    }

    public boolean colineaire(Segment_terrain ST) {
        double x, y, x1, y1;
        x = this.px - ST.pt1.px;
        y = this.py - ST.pt1.py;
        x1 = ST.pt2.px - ST.pt1.px;
        y1 = ST.pt2.py - ST.pt1.py;
        if (y1 / y == x1 / x) {
            return true;
        } else {
            return false;
        }

    }

    public boolean positif(Segment_terrain ST) {
        double a, angle, x, y, x1, y1;
        x = this.px - ST.pt1.px;
        y = this.py - ST.pt1.py;
        x1 = ST.pt1.px - ST.pt2.px;
        y1 = ST.pt1.py - ST.pt2.py;
        a = (x1 * x + y1 * y) / (sqrt(x * x + y * y) * sqrt(x1 * x1 + y1 * y1));
        angle = acos(a);
        if (0 < angle && angle < Math.PI) {
            return true;
        } else {
            return false;

        }

    }
//savoir si un point appartient a un traingle terrain
    public boolean dans(Triangle_terrain TT) {
        if (this.positif(TT.seg12) && this.positif(TT.seg23) && this.positif(TT.seg31)) {
            return true;
        }
        if (!this.positif(TT.seg12) && !this.positif(TT.seg23) && !this.positif(TT.seg31)) {
            return true;
        }
        return false;
    }
    public double getPy(){
        return this.py;
    }
    public double getPx(){
        return this.px;
    }
    public void draw(GraphicsContext gc){
        
        gc.setFill(Color.AQUA);
        gc.fillOval(this.px,this.py,8,8);
    }
    public int getId(){
        return id;
    }
    public void setId(int identite){
        id=identite;
    }
}

