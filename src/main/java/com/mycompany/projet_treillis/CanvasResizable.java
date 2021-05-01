/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projet_treillis;

import com.mycompany.treillis.Noeud_simple;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import com.mycompany.treillis.Point;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author cz
 */
public class CanvasResizable extends StackPane {

    protected Canvas canvas;
    protected Interface_graphique mainInterface;

    public CanvasResizable(Interface_graphique main, double h, double w) {
        /* GraphicsContext gc = canvas.getGraphicsContext2D();
    gc.setStroke(Color.BLACK);
    gc.setLineWidth(4);
    gc.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());
         */
        mainInterface = main;
        this.setPrefSize(h, w);
        this.canvas=new Canvas();
        this.canvas.setManaged(false);
        this.canvas.widthProperty().bind(
                this.widthProperty());
        this.canvas.heightProperty().bind(
                this.heightProperty());
        this.getChildren().add(this.canvas);
        this.canvas.widthProperty().addListener((o) -> {
            redraw();
        });
        this.canvas.heightProperty().addListener((o) -> {
            redraw();
        });
        
        this.canvas.setOnMouseClicked((t) -> {
//            control.clicDessin(t);
        });

        this.canvas.setOnMouseClicked((t) -> {

        });
        redraw();
       
      
    }
    //dessiner un segment en faisant un click + drag de la souris
    //un premier point est place sur la place de la click
    //un deuxieme point est place sur la fin de la drag

    public void drawLine() {
        if(mainInterface.bsegment.isSelected()){
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

            @Override

            public void handle(MouseEvent mouse) {
                gc.setLineWidth(3);

                gc.beginPath();
                gc.moveTo(mouse.getX(), mouse.getY());
                Point p=new Point(mouse.getX(),mouse.getY());
                GraphicsContext gc=canvas.getGraphicsContext2D();
                p.draw(gc);
                mainInterface.addPointMain(p);

            }
        });
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouse) {

                gc.lineTo(mouse.getX(), mouse.getY());
                gc.stroke();
                Point p2=new Point(mouse.getX(),mouse.getY());
                GraphicsContext gc=canvas.getGraphicsContext2D();
                p2.draw(gc);
                mainInterface.addPointMain(p2);
            }

        });
    }
    }

    //clears the canvas
    public void clear() {
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, this.getWidth(), this.getHeight());
        drawBorders();

    }
    public void drawBorders(){
        GraphicsContext gc=this.canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.strokeRect(0,0,this.canvas.getWidth(),this.getHeight());
    }
    

    //placer un point en clickant avec la souris
    public void placePoint() {

        this.canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
            final Point p;
            GraphicsContext gc = this.canvas.getGraphicsContext2D();
            gc.setStroke(Color.AQUA);
            gc.fillOval(me.getX(), me.getY(), 10, 10);
            p = new Point(me.getX(), me.getY());
            mainInterface.addPointMain(p);
            System.out.println("x point"+p.getPx() + "y point " + p.getPy());
            System.out.println("id point"+p.getId());

        });

    }

    //placer un noeud simple en clickant avec la souris
    public void placeNoeudSimple() {
        this.canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
            final Noeud_simple n;
            this.canvas.getGraphicsContext2D().setStroke(Color.BLACK);
            this.canvas.getGraphicsContext2D().fillOval(me.getX(), me.getY(), 15, 15);
            n = new Noeud_simple(me.getX(), me.getY());
            mainInterface.addNoeudSimple(n);
            System.out.println("id noeud"+  n.getId());
        });
    }

    public void redraw() {
        double width = this.canvas.getWidth();
        double height = this.canvas.getHeight();
//        System.out.println("redraw2 [" + width + "," + height + "]");

        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, width, height);
        drawBorders();

      

    }

    public Canvas getCanvas() {
        return this.canvas;
    }
}
