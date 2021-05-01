/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.treillis;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author cz
 */
public class TypeBar {

    protected double cout;
    protected double lmax;
    protected double lmin;
    protected double rtraction;
    protected double rcompression;
    protected int id;

    public TypeBar(double c, double L, double l, double rt, double rc) {
        cout = c;
        lmax = L;
        lmin = l;
        rtraction = rt;
        rcompression = rc;

    }
    public void setId(int identite){
        id=identite;
        
    }

    public void save(BufferedWriter out) throws IOException {
        try {
            out.append("TypeBarre;");
            out.append(cout + ";");
            out.append(lmin + ";");
            out.append(lmax + ";");
            out.append(rtraction + ";");
            out.append(rcompression + ";\n");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
