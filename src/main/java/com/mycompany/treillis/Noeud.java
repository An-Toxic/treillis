/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.treillis;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author cz
 */
 public abstract class Noeud {
    protected int id ;
    //une liste des barres concourantes en un Noeud qui va nous servir dans l'etablissement des equations
    protected ArrayList<Barre> bConcour;
    public Noeud(int identite){
        id = identite ;
        bConcour=new ArrayList<Barre>();
    }
    public Noeud(){
        bConcour=new ArrayList<Barre>();
    }
    
    abstract double getPx();
    abstract double getPy();
    
    abstract void drawNoeud(GraphicsContext gc);
    public int getId(){
        return this.id;
    }
    abstract public void save(BufferedWriter out)throws IOException;
    
    
    
}
