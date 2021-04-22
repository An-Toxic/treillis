/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.treillis;

import java.io.BufferedWriter;
import java.io.IOException;
import static java.lang.Math.acos;
import static java.lang.Math.sqrt;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author cz
 */
public class Barre {

    protected int id;
    protected Noeud n1;
    protected Noeud n2;
    protected TypeBar type;

    public Barre(Noeud noeud1, Noeud noeud2) {
        n1 = noeud1;
        n2 = noeud2;
        //chaque fois une barre est cree elle est ajoute a la liste des barres concourantes
        //des noeuds correspandants
        n1.bConcour.add(this);
        n2.bConcour.add(this);
        type =new TypeBar(5,5,5,5,5);

    }

    //determiner la longueur d'une barre
    public double barLenght() {
        double a = (n1.getPx() - n2.getPx()) * (n1.getPx() - n2.getPx()) + (n1.getPy() - n2.getPy()) * (n1.getPy() - n2.getPy());
        return sqrt(a);
    }

    //trouver l'angle alpha ente la barre et l'horizontale 
    public double getAlpha() {
        double alpha = (n2.getPx() - n1.getPx()) / (this.barLenght());
        return acos(alpha);

    }

    public int getId() {
        return id;
    }

    public void setId(int identite) {
        id = identite;
    }

    public void drawBarre(GraphicsContext gc) {
        gc.setStroke(Color.BLACK.darker());
        gc.strokeLine(n1.getPx(), n1.getPy(), n2.getPx(), n2.getPy());

    }

    public void save(BufferedWriter out) throws IOException {
        //format barre;id;Typebar.id;n1.id;n2.id
        try {
            out.append("Barre;");
            out.append(this.id + ";");
            out.append(this.type.id + ";");
            out.append(this.n1.id + ";");
            out.append(this.n2.id + "\n");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
