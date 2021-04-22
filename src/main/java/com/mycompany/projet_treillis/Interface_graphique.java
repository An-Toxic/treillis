/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.projet_treillis;

import com.mycompany.treillis.Barre;
import com.mycompany.treillis.Noeud_simple;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import com.mycompany.treillis.Point;
import com.mycompany.treillis.Segment_terrain;
import com.mycompany.treillis.Treillis;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author cz
 */
public class Interface_graphique extends BorderPane{
    protected Treillis treillis;
    protected RadioButton bpoint;
    protected RadioButton bsegment;
    protected RadioButton bnoeudS;
    protected RadioButton bnoeudAS;
    protected RadioButton bnoeudAD;
    
    protected Button bcouleur;
    protected Button bclear;
    protected Button bTT;
    protected Button bST;
    protected Button bTreillis;
    protected Button bcreateP;
    protected Button bcreateNS;
    protected Button bcreateSeg;
    protected Button bcreateBar;
    protected Button bsave;
    
    protected TextField tpointx;
    protected TextField tpointy;
    protected TextField tSegPoint1;
    protected TextField tSegPoint2;
    
    
    protected VBox h3;
    protected HBox h1;
    protected HBox h2;
    protected VBox h4;
    protected HBox h5;
    
    
    protected Label lx;
    protected Label ly;
    protected Label lSegPoint1;
    protected Label lSegPoint2;
    
    protected CanvasResizable zonedessin;
     public Interface_graphique(double width , double height){
          this.setPrefSize(width, height);
          treillis =new Treillis();
          
         ToggleGroup tgState = new ToggleGroup() ;
         bpoint= new RadioButton("POINT");
         bpoint.setDisable(true);
         bpoint.setToggleGroup(tgState);
         bcreateP=new Button ("Create Point");
         bcreateNS=new Button("Create Noeud Simple");
         bcreateSeg=new Button("Create segment");
         bcreateBar=new Button("Create Barre");
         bsave= new Button("Save");
         bsave.setStyle("-fx-background-color: MediumSeaGreen");
         
         
         
         bsegment = new RadioButton("SEGMENT");
         bsegment.setDisable(true);
         bsegment.setToggleGroup(tgState);
         bnoeudS =new RadioButton("Noeud SIMPLE");
         bnoeudS.setToggleGroup(tgState);
         bnoeudS.setDisable(true);
         bnoeudAS = new RadioButton (" Appui simple");
         bnoeudAS.setDisable(true);
         bnoeudAS.setToggleGroup(tgState);
         bnoeudAD=new RadioButton ("Appui double");
         bnoeudAD.setToggleGroup(tgState);
         bnoeudAD.setDisable(true);
         bcouleur = new Button("Couleur");
         bclear = new Button("Clear");
         bclear.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
         bclear.setStyle("-fx-background-color: Red");
         bTT=new Button("Triangle terrain");
         bST=new Button("Segment Terrain");
         bTreillis=new Button("Nouveau Treillis");
         bTreillis.setStyle("-fx-text-fill: #0000ff");
         
         ly=new Label("ordonne y");
         ly.setFont(new Font("Arial", 12));
         ly.setStyle("-fx-font-weight: bold;");
         lx=new Label("abscisse x");
         lx.setFont(new Font("Arial", 12));
         lx.setStyle("-fx-font-weight: bold;");
         
         lSegPoint1=new Label("Numero du premier point");
         lSegPoint1.setStyle("-fx-font-weight: bold;");
         lSegPoint2=new Label("Numero du deuxieme point");
         lSegPoint2.setStyle("-fx-font-weight: bold;");
         
         tpointx =new TextField();
         tpointx.setPromptText(" x ");
         
         tpointy=new TextField();
         tpointy.setPromptText("y ");
         
         tSegPoint1=new TextField();
         tSegPoint1.setPromptText("indice Point1 ");
         
         tSegPoint2=new TextField();
         tSegPoint2.setPromptText("indice Point 2");
         
         h1=new HBox(bpoint , bsegment,bnoeudS,bnoeudAS,bnoeudAD);
         h5 = new HBox(lx,tpointx,ly,tpointy,bcreateP,bcreateNS);
         h5.getStyleClass().add("jfx-decorator-buttons-container");
         h5.setBackground(new Background(new BackgroundFill(Color.BEIGE,
    CornerRadii.EMPTY,
    Insets.EMPTY)));
         h5.setSpacing(5);
         
         h3= new VBox(bTreillis,bTT,bST,bclear,bsave);
         h3.setSpacing(5);
         h4=new VBox(h1,h5);
         h2=new HBox(lSegPoint1,tSegPoint1,lSegPoint2,tSegPoint2,bcreateSeg,bcreateBar);
         h2.getStyleClass().add("jfx-decorator-buttons-container");
         h2.setBackground(new Background(new BackgroundFill(Color.BEIGE,
    CornerRadii.EMPTY,
    Insets.EMPTY)));
         
         
         
         
         this.setBottom(h2);
         this.setTop(h4);
         this.setRight(h3);
         this.setWidth(500);
         this.setHeight(600);
         this.zonedessin=new CanvasResizable(this,500,400);
         this.setCenter(zonedessin);
         
         bsegment.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        if(bsegment.isSelected()){
        zonedessin.drawLine();
    }
    }
    });
    bpoint.setOnAction(new EventHandler<ActionEvent>(){
        
        @Override public void handle(ActionEvent e){
            if(bpoint.isSelected()){
        zonedessin.placePoint();
    }
        }
    });
    bclear.setOnAction(new EventHandler<ActionEvent>(){
        @Override public void handle(ActionEvent e){
            zonedessin.clear();
            Disable();
            
        }
    });
    //creer un nouveau treillis 
    bTreillis.setOnAction(new EventHandler<ActionEvent>(){
        @Override public void handle(ActionEvent e){
            Enable();
             treillis = new Treillis();
        }
        
    });
    bcreateBar.setOnAction(new EventHandler<ActionEvent>(){
        @Override public void handle(ActionEvent e){
            int indice1=Integer.parseInt(tSegPoint1.getText());
            int indice2=Integer.parseInt(tSegPoint2.getText());
            Noeud_simple n1=(Noeud_simple)treillis.listNoeud.get(indice1);
            Noeud_simple n2=(Noeud_simple)treillis.listNoeud.get(indice2);
            //System.out.println(n1.getId());
           // System.out.println(n2.getId());
            Barre b=new Barre(n1,n2);
            b.drawBarre(zonedessin.canvas.getGraphicsContext2D());
            addBarre(b);
        }
    });
          //creer un point en entrant ses coordonnes  
    bcreateP.setOnAction(new EventHandler<ActionEvent>(){
         @Override public void handle(ActionEvent e){
        Point p=new Point(Double.parseDouble(tpointx.getText()),Double.parseDouble(tpointy.getText()));
        
        p.draw(zonedessin.canvas.getGraphicsContext2D());
       addPointMain(p);
       
        
    }
     });
    //creer un segment a partir des indices de deux points
    bcreateSeg.setOnAction(new EventHandler<ActionEvent>(){
            @Override
             public void handle(ActionEvent e){
                 int indice1=Integer.parseInt(tSegPoint1.getText());
                 int indice2=Integer.parseInt(tSegPoint2.getText());
                
                 Point p1=(Point)treillis.listPoint.get(indice1);
                 Point p2=(Point)treillis.listPoint.get(indice2);
                 
                 Segment_terrain s = new Segment_terrain(p1,p2);
                 s.DrawSegment(zonedessin.canvas.getGraphicsContext2D());
                 System.out.println(p1.getPx());
                 System.out.println(p2.getPx());
                 
                 
             }
    });
    //creer un noeud simple en saisissant les coordonnes
     bcreateNS.setOnAction(new EventHandler<ActionEvent>(){
         @Override public void handle(ActionEvent e){
        Noeud_simple n=new Noeud_simple(Double.parseDouble(tpointx.getText()),Double.parseDouble(tpointy.getText()));
        
        n.drawNoeud(zonedessin.canvas.getGraphicsContext2D());
        addNoeudSimple(n);
        
    }
     });
    //placer un noeud simple avec la souris
    bnoeudS.setOnAction(new EventHandler<ActionEvent>(){
        @Override public void handle(ActionEvent e){
            if(bnoeudS.isSelected()){
            zonedessin.placeNoeudSimple();
        }
        }
    });
     
bsave.setOnAction(new EventHandler<ActionEvent>(){
        @Override public void handle (ActionEvent e){
            try{
            treillis.save();
        }catch (IOException ioe) {
	   ioe.printStackTrace();
        }
        }
});
     }
     //enable acces to buttons
     public void Enable(){
         bpoint.setDisable(false);
         bsegment.setDisable(false);
         bnoeudS.setDisable(false);
         bnoeudAS.setDisable(false);
         bnoeudAD.setDisable(false);
     
     }
     //disable acces to buttons
     public void Disable(){
         bpoint.setDisable(true);
         bsegment.setDisable(true);
         bnoeudS.setDisable(true);
         bnoeudAS.setDisable(true);
         bnoeudAD.setDisable(true);
         
     }
     //associer un identificateur a un point 
     public void addPointMain(Point p){
         treillis.getNum().getOrCreateKey(p);
         p.setId(treillis.getNum().getOrCreateKey(p));
         treillis.addPoint(p);
         System.out.println("la taille da la list est "+treillis.listPoint.size());
         
     }
     //associer un identificateur a un noeud simple
     public void addNoeudSimple(Noeud_simple n){
         treillis.getNum().getOrCreateKey(n);
         n.setId(treillis.getNum().getOrCreateKey(n));
         treillis.addNoeud(n);
         
     }
     //associer un identificateur a une barre
     public void addBarre(Barre b){
         treillis.getNum().getOrCreateKey(b);
         b.setId( treillis.getNum().getOrCreateKey(b));
         treillis.addBarre(b);
         
     }
}
