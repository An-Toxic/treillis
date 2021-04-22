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
public class Appui_simple extends Noeud_appui {

    public Appui_simple(int identite, Triangle_terrain T, int num, double pos) {
        super(identite, T, num, pos);
    }

    public void save(BufferedWriter out) throws IOException {
        //format Appui_simple;id;triangleterrain.id;numero;pos
        try {
            out.append("AppuiSimple;");
            out.append(id + ";");
            out.append(triangle.id + ";");
            out.append(this.numero + ";");
            out.append(this.alpha + ";\n");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
