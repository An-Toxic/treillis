/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.treillis;

import java.io.BufferedWriter;
import java.io.IOException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author cz
 */
public class Appui_double extends Noeud_appui {

    public Appui_double(int identite, Triangle_terrain T, int num, double pos) {
        super(identite, T, num, pos);
    }
    public Appui_double(Triangle_terrain T,int num,double pos){
        super(T,num,pos);
    }

    public void save(BufferedWriter out) throws IOException {
        //format AppuiDouble;id;triangle.id;numero;pos
        try {
            out.append("AppuiDouble;");
            out.append(this.id + ";");
            out.append(this.triangle.id + ";");
            out.append(this.numero + ";");
            out.append(this.alpha + "\n");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
    public void drawNoeud(GraphicsContext gc){
          gc.setStroke(Color.BLUEVIOLET);
        gc.strokeOval(this.getPx(), this.getPy(), 5, 5);
        double[] doubles={this.getPx()-5,this.getPx()+5,this.getPx()};
        double[] doubles1={this.getPy()+5,this.getPy()+5,this.getPy()-10};
        gc.strokePolyline(doubles, doubles1, 3);
    }
    }

