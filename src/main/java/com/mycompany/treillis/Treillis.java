/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.treillis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author cz
 */
public class Treillis {

   
    public ArrayList<Barre> listBar;
    public ArrayList<Noeud> listNoeud;
    public ArrayList<TypeBar> catalogue;
    public ArrayList<Point> listPoint;
    public ArrayList<Triangle_terrain> listTriangle;
    protected Numerator num;
    public Matrice matrice;
    protected Terrain terrain;

    public Treillis() {
        num = new Numerator(0);
        listBar = new ArrayList<Barre>();
        listNoeud = new ArrayList<Noeud>();
        listPoint = new ArrayList<Point>();
        listTriangle = new ArrayList<Triangle_terrain>();
        catalogue = new ArrayList<TypeBar>();
        terrain = new Terrain();

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

    public void addTriangle(Triangle_terrain t) {
        listTriangle.add(t);
    }

    public void addTypebar(TypeBar type) {
        catalogue.add(type);
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

    //definir les dimensions de la zone constructible
    public void setZoneConstructible() {
        double[] xPoint = new double[listTriangle.size() * 3];
        double[] yPoint = new double[listTriangle.size() * 3];
        int i = 0;
        for (Triangle_terrain t : listTriangle) {
            xPoint[i] = t.pt1.px;
            yPoint[i] = t.pt1.py;
            i++;
            xPoint[i] = t.pt2.px;
            yPoint[i] = t.pt2.py;
            i++;
            xPoint[i] = t.pt3.px;
            yPoint[i] = t.pt3.py;

        }
        int imin = 0;
        double xmin;
        int imax = 0;
        double xmax;
        int iymin = 0;
        int iymax = 0;
        double ymin;
        double ymax;
        for (int j = 1; j < xPoint.length; j++) {
            xmin = xPoint[0];

            if (xmin > xPoint[i]) {
                imin = i;
                xmin = xPoint[i];
            }

        }
        terrain.xmin = (float) xPoint[imin];
        for (int j = 1; j < xPoint.length; j++) {
            xmax = xPoint[0];

            if (xmax < xPoint[i]) {
                imax = i;
                xmax = xPoint[i];
            }

        }
        terrain.xmax = (float) xPoint[imax];
        for (int j = 1; j < xPoint.length; j++) {
            ymin = yPoint[0];

            if (ymin > yPoint[i]) {
                iymin = i;
                ymin = yPoint[i];
            }

        }
        terrain.ymin = (float) yPoint[iymin];
        for (int j = 1; j < yPoint.length; j++) {
            ymax = yPoint[0];

            if (ymax < yPoint[i]) {
                iymax = i;
                ymax = yPoint[i];
            }

        }
        terrain.ymax = (float) yPoint[iymax];

    }

    public void save(String path) throws IOException {
        BufferedWriter out = null;
        setZoneConstructible();
        try {
            File file = new File(path);
            //si le file n'existe pas on cree un nouveau file 
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            out = new BufferedWriter(fw);
            //pour chaque TT on ecrit dans le file 
            out.append("ZoneConstructible;" + terrain.xmin + ";" + terrain.xmax + ";"
                    + terrain.ymin + ";" + terrain.ymax + "\n");
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
                System.out.println("Error in closing the BufferedWriter");
            }
        }
    }

    //load from a text file and represent it on the canvas
    public void load(GraphicsContext gc, String path) throws IOException {
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader in = new BufferedReader(fr);
            String s = null;
            while ((s = in.readLine()) != null) {
                System.out.println(s);

                String[] string = s.split(";");
                System.out.println(string);
                //lire les noeuds simple et les represnter
                if (string[0].equals("ZoneConstructible")) {
                    terrain.xmin = Float.parseFloat(string[1]);
                    terrain.xmax = Float.parseFloat(string[2]);
                    terrain.ymin = Float.parseFloat(string[3]);
                    terrain.ymax = Float.parseFloat(string[4]);
                }
                if (string[0].equals("NoeudSimple")) {
                    int identite = Integer.parseInt(string[1]);
                    String res = string[2].substring(1, string[2].length() - 1);
                    String[] resSplit = res.split(",");
                    double x = Double.parseDouble(resSplit[0]);
                    double y = Double.parseDouble(resSplit[1]);

                    Noeud_simple n = new Noeud_simple(identite, x, y);
                    addNoeud(n);
                    //on met le noeud dans le hashmap avec son identificateur comme indice
                    num.objtoKey.put(n, identite);
                    num.keytoObj.put(identite, n);
                    n.drawNoeud(gc);
                    Noeud_simple ntest = (Noeud_simple) num.keytoObj.get(identite);
                    System.out.println(ntest.Nx);
                    System.out.println(ntest.Ny);
                    System.out.println(ntest.id);

                }
                if (string[0].equals("AppuiSimple")) {
                    int identite = Integer.parseInt(string[1]);
                    Triangle_terrain t = (Triangle_terrain) num.keytoObj.get(Integer.parseInt(string[2]));
                    int numero = Integer.parseInt(string[3]);
                    double pos = Double.parseDouble(string[4]);

                    Appui_double n = new Appui_double(identite, t, numero, pos);
                    num.objtoKey.put(n, identite);
                    num.keytoObj.put(identite, n);
                    addNoeud(n);
                    n.drawNoeud(gc);
                }
                if (string[0].equals("AppuiDouble")) {
                    int identite = Integer.parseInt(string[1]);
                    Triangle_terrain t = (Triangle_terrain) num.keytoObj.get(Integer.parseInt(string[2]));
                    int numero = Integer.parseInt(string[3]);
                    double pos = Double.parseDouble(string[4]);

                    Appui_double n = new Appui_double(identite, t, numero, pos);
                    num.objtoKey.put(n, identite);
                    num.keytoObj.put(identite, n);
                    addNoeud(n);
                    n.drawNoeud(gc);

                }
                //apres avoir lu les noeuds simples , lire les barres et les representer
                if (string[0].equals("Barre")) {
                    int identite = Integer.parseInt(string[1]);
                    int idType = Integer.parseInt(string[2]);
                    int idN1 = Integer.parseInt(string[3]);
                    int idN2 = Integer.parseInt(string[4]);

                    Noeud n1 = (Noeud) num.keytoObj.get(idN1);
                    Noeud n2 = (Noeud) num.keytoObj.get(idN2);
                    TypeBar type = (TypeBar) num.keytoObj.get(idType);

                    Barre b = new Barre(identite, type, n1, n2);
                    num.objtoKey.put(b, identite);
                    addBarre(b);
                    b.drawBarre(gc);
                }
                if (string[0].equals("TypeBarre")) {
                    int identite = Integer.parseInt(string[1]);
                    double cout = Double.parseDouble(string[2]);
                    double lmin = Double.parseDouble(string[3]);
                    double lmax = Double.parseDouble(string[4]);
                    double rt = Double.parseDouble(string[5]);
                    double rc = Double.parseDouble(string[6]);

                    TypeBar typeb = new TypeBar(identite, lmax, lmin, rt, rc);
                    this.addTypebar(typeb);
                    num.objtoKey.put(typeb, identite);
                    num.keytoObj.put(identite, typeb);

                }
                if (string[0].equals("Triangle")) {
                    int identite = Integer.parseInt(string[1]);
                    String s1 = string[2].substring(1, string[2].length() - 1);
                    String[] parts = s1.split(",");
                    double px1 = Double.parseDouble(parts[0]);
                    double py1 = Double.parseDouble(parts[1]);
                    Point p1 = new Point(px1, py1);

                    String s2 = string[3].substring(1, string[3].length() - 1);
                    String[] parts2 = s2.split(",");
                    double px2 = Double.parseDouble(parts2[0]);
                    double py2 = Double.parseDouble(parts2[1]);
                    Point p2 = new Point(px2, py2);

                    String s3 = string[4].substring(1, string[4].length() - 1);
                    String[] parts3 = s3.split(",");
                    double px3 = Double.parseDouble(parts3[0]);
                    double py3 = Double.parseDouble(parts3[1]);
                    Point p3 = new Point(px3, py3);

                    Triangle_terrain t = new Triangle_terrain(identite, p1, p2, p3);
                    addTriangle(t);
                    num.objtoKey.put(t, identite);
                    num.keytoObj.put(identite, t);
                    t.drawTriangle(gc);
                }

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Error opening file");
        }

    }
//calcul la matrice des inconnues du treillis

    public Matrice calculMatrice() {
        matrice = new Matrice(2 * listNoeud.size(), listNoeud.size() + this.nombreNA());
        Matrice secondMembre = new Matrice(matrice.nbrLig, 1);
        //pour chaque noeud du treillis on remplit deux lignes de la matrice
        int i = 0;
        int AD=0;
        int AS=0;
        for (Noeud s : listNoeud) {

            if (s instanceof Noeud_simple) {
                for (int j = 0; j < ((Noeud_simple) s).bConcour.size(); j++) {
                    Barre b = ((Noeud_simple) s).bConcour.get(j);

                    matrice.coeffs[i][listBar.indexOf(b)] = Math.cos(b.getAlpha());
                    matrice.coeffs[i + 1][listBar.indexOf(b)] = Math.sin(b.getAlpha());

                }

            }
            if (s instanceof Appui_simple) {
                for (int j = 0; j < ((Appui_simple) s).bConcour.size(); j++) {
                    Barre b = ((Appui_simple) s).bConcour.get(j);
                    matrice.coeffs[i][listBar.indexOf(b)] = Math.cos(b.getAlpha());
                    matrice.coeffs[i + 1][listBar.indexOf(b)] = Math.sin(b.getAlpha());
                    matrice.coeffs[i][matrice.nbrCol - 1-AS] = Math.cos(((Appui_simple) s).getBeta());
                    matrice.coeffs[i + 1][matrice.nbrCol - 1-AS] = Math.sin(((Appui_simple) s).getBeta());
                    secondMembre.coeffs[i][0] = 1000;
                    AS++;

                }
            }
            if (s instanceof Appui_double) {
                for (int j = 0; j < ((Appui_double) s).bConcour.size(); j++) {
                    Barre b = ((Appui_double) s).bConcour.get(j);
                    matrice.coeffs[i][listBar.indexOf(b)] = Math.cos(b.getAlpha());
                    matrice.coeffs[i + 1][listBar.indexOf(b)] = Math.sin(b.getAlpha());
                    matrice.coeffs[i][listNoeud.size()+AD] = 1;
                    matrice.coeffs[i + 1][listNoeud.size()+AD] = 1;
                    AD++;

                }

            }
            i += 2;

        }
        matrice.toString();
        Matrice mfinale = matrice.concatCol(secondMembre);
        //mfinale.resolution();
        return mfinale;
    }

    public ResSys resMatrice() {
        double[] tab = new double[calculMatrice().nbrLig];
        Matrice second = Matrice.creeVecteur(tab);

        Matrice fin = calculMatrice().concatCol(second);
        return fin.resolution();

    }

    public int nombreNA() {
        int k = 0;
        for (Noeud n : listNoeud) {
            if (n instanceof Noeud_appui) {
                k++;
            }
        }
        return k;
    }

    public int nombreAS() {
        int k = 0;
        for (Noeud n : listNoeud) {
            if (n instanceof Appui_simple) {
                k++;
            }
        }
        return k;
    }
      public int nombreAD() {
        int k = 0;
        for (Noeud n : listNoeud) {
            if (n instanceof Appui_double) {
                k++;
            }
        }
        return k;
    }
    
}
