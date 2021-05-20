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
public class Noeud_simple extends Noeud {

    protected double Nx;
    protected double Ny;

    public Noeud_simple(int identite, double x, double y) {
        super(identite);
        Nx = x;
        Ny = y;

    }

    public Noeud_simple(double x, double y) {
        super();
        Nx = x;
        Ny = y;
    }

    public double getPx() {
        return Nx;
    }

    public double getPy() {
        return Ny;
    }

    public void drawNoeud(GraphicsContext gc) {

        gc.setStroke(Color.BLACK.darker());
        gc.fillOval(Nx, Ny, 10, 10);

    }

   

    public void save(BufferedWriter out) throws IOException {
        //format Noeud_simple;id;x;y;
        try {
            out.append("NoeudSimple;");
            out.append(this.id + ";(");
            out.append(this.Nx + ",");
            out.append(this.Ny + ")\n");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
