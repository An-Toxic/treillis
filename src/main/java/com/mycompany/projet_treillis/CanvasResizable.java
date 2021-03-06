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
import java.text.DecimalFormat;
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
        this.canvas = new Canvas();
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

        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent me) -> {
            if (mainInterface.bsegment.isSelected()) {

                // @Override
                //public void handle(MouseEvent mouse) {
                gc.setLineWidth(3);

                gc.beginPath();
                gc.moveTo(me.getX(), me.getY());
                Point p = new Point(me.getX(), me.getY());

                p.draw(gc);
                mainInterface.addPointMain(p);

            }
        });
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent me) -> {
            if (mainInterface.bsegment.isSelected()) {

                gc.lineTo(me.getX(), me.getY());
                gc.setStroke(Color.BLUE);
                gc.stroke();
                Point p2 = new Point(me.getX(), me.getY());

                p2.draw(gc);
                mainInterface.addPointMain(p2);

            }
        });
    }

    //clears the canvas
    public void clear() {
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, this.getWidth(), this.getHeight());
        drawBorders();

    }

    public void drawBorders() {
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.strokeRect(0, 0, this.canvas.getWidth(), this.getHeight());
    }

    //placer un point en clickant avec la souris
    public void placePoint() {
        if (mainInterface.bpoint.isSelected()) {
            DecimalFormat numberFormat = new DecimalFormat("#.0");

            this.canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
                if (mainInterface.bpoint.isSelected()) {
                    final Point p;
                    GraphicsContext gc = this.canvas.getGraphicsContext2D();
                    gc.setFill(Color.AQUA);
                    gc.fillOval(me.getX(), me.getY(), 8, 8);
                    p = new Point(me.getX(), me.getY());
                    mainInterface.addPointMain(p);
                    gc.setStroke(Color.AQUA);
                    gc.strokeText("" + mainInterface.treillis.listPoint.indexOf(p), me.getX() - 10, me.getY() - 10);
                    mainInterface.textarea.appendText("P" + mainInterface.treillis.listPoint.indexOf(p)
                            + "(" + numberFormat.format(p.getPx()) + "," + numberFormat.format(p.getPy()) + ")\n");
                    System.out.println("x point" + p.getPx() + "y point " + p.getPy());
                    System.out.println("id point" + p.getId());
                }
            });
        }
    }

    //placer un noeud simple en clickant avec la souris
    public void placeNoeudSimple() {

        DecimalFormat numberFormat = new DecimalFormat("#.0");
        this.canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
            if (mainInterface.bnoeudS.isSelected()) {
                final Noeud_simple n;
                this.canvas.getGraphicsContext2D().setFill(Color.BLACK);
                this.canvas.getGraphicsContext2D().fillOval(me.getX(), me.getY(), 15, 15);
                n = new Noeud_simple(me.getX(), me.getY());
                mainInterface.addNoeudSimple(n);
                this.canvas.getGraphicsContext2D().setStroke(Color.BLACK);
                this.canvas.getGraphicsContext2D().strokeText(""+mainInterface.treillis.listNoeud.indexOf(n), n.getPx()-10, n.getPy()-10);
                
                mainInterface.textarea.appendText("NS" + mainInterface.treillis.listNoeud.indexOf(n)
                        + ";(" + numberFormat.format(n.getPx()) + "," + numberFormat.format(n.getPy()) + ")\n");
                System.out.println("id noeud" + n.getId());
            }
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
