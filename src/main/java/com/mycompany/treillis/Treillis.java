/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.treillis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cz
 */
public class Treillis {

    public Terrain T;
    public ArrayList<Barre> listBar;
    public ArrayList<Noeud> listNoeud;
    public ArrayList<TypeBar> catalogue;
    public ArrayList<Point> listPoint;
    public ArrayList<Triangle_terrain> listTriangle;
    protected Numerator num;

    public Treillis() {
        num = new Numerator(0);
        listBar = new ArrayList<Barre>();
        listNoeud = new ArrayList<Noeud>();
        listPoint = new ArrayList<Point>();
        listTriangle = new ArrayList<Triangle_terrain>();
    }

    //ajouter un point a la liste des points du treillis
    public void addPoint(Point p) {
        listPoint.add(p);

    }

    //ajouter une barre a la liste des points du treillis
    public void addBarre(Barre b) {
        listBar.add(b);
    }

    public void addNoeud(Noeud n) {
        listNoeud.add(n);
    }

    public Numerator getNum() {
        return num;
    }

    public List getListPoint() {
        return this.listNoeud;
    }

    public List getListBarre() {
        return this.listBar;
    }

    public List getListNoeud() {
        return this.listNoeud;
    }

    public void save() throws IOException {
        BufferedWriter out = null;
        try {
            File file = new File("C:\\Users\\cz\\Documents\\NetBeansProjects\\projetsave.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            out = new BufferedWriter(fw);
            for (Triangle_terrain t : listTriangle) {
                t.save(out);
            }
            out.append("FINTRIANGLES\n");
            for (TypeBar type : catalogue) {
                type.save(out);
            }

            out.append("FINCATALOGUE\n");
            for (Noeud n : listNoeud) {
                n.save(out);
            }
            out.append("FINNOEUDS\n");
            for (Barre b : listBar) {
                b.save(out);
            }
            out.append("FINBARRES\n");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Error in writing to file");
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception ex) {
                System.out.println("Error in closing the BufferedWriter" );
            }
        }
    }
}
