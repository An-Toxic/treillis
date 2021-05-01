/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.treillis;

import java.io.BufferedWriter;
import java.io.IOException;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author cz
 */
public class Triangle_terrain {

    protected int id;
    protected Point pt1;
    protected Point pt2;
    protected Point pt3;
    protected Segment_terrain seg12;
    protected Segment_terrain seg23;
    protected Segment_terrain seg31;
    protected Point[] tbpoint;

    public Triangle_terrain(Point p1, Point p2, Point p3) {
        pt1 = p1;
        pt2 = p2;
        pt3 = p3;
        seg12 = new Segment_terrain(pt1, pt2);
        seg23 = new Segment_terrain(pt2, pt3);
        seg31 = new Segment_terrain(pt3, pt1);
        tbpoint = new Point[]{pt1, pt2, pt3};
    }
     public Triangle_terrain(int identite,Point p1, Point p2, Point p3) {
         id=identite;
        pt1 = p1;
        pt2 = p2;
        pt3 = p3;
        seg12 = new Segment_terrain(pt1, pt2);
        seg23 = new Segment_terrain(pt2, pt3);
        seg31 = new Segment_terrain(pt3, pt1);
        tbpoint = new Point[]{pt1, pt2, pt3};
    }
    
public void setId(int identite){
    this.id=identite;
}
    public void save(BufferedWriter out) throws IOException {
        //format Triangle;id;(p1x,p1y);(p2x,p2y);(p3x,p3y);
        try {
            out.append("Triangle;");
            out.append(id + ";(");
            out.append(pt1.px + "," + pt1.py + ");(");
            out.append(pt2.px + "," + pt2.py + ");(");
            out.append(pt3.px + "," + pt3.py + ")\n");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public void drawTriangle(GraphicsContext gc){
        seg12.DrawSegment(gc);
        seg23.DrawSegment(gc);
        seg31.DrawSegment(gc);
    }

}
