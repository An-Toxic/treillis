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
public class Appui_double extends Noeud_appui {

    public Appui_double(int identite, Triangle_terrain T, int num, double pos) {
        super(identite, T, num, pos);
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
}
