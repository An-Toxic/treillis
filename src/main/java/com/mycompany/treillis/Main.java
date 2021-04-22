/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.treillis;

import com.mycompany.treillis.Point;
import com.mycompany.treillis.Segment_terrain;

/**
 *
 * @author cz
 */
public class Main {
    public static void main(String[] args){
        Point p1=new Point (0,0);
        Point p3=new Point (3,3);
        Point p2=new Point (5,0);
        Triangle_terrain t=new Triangle_terrain(p1,p3,p2);
        Appui_simple app = new Appui_simple(1,t,2,0.5);
        System.out.println(app.getPy());
    }
    
}
