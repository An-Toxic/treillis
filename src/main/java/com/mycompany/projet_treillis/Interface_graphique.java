/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.projet_treillis;

import com.mycompany.treillis.Appui_double;
import com.mycompany.treillis.Appui_simple;
import com.mycompany.treillis.Barre;
import com.mycompany.treillis.Noeud;
import com.mycompany.treillis.Noeud_appui;
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
import com.mycompany.treillis.Triangle_terrain;
import com.mycompany.treillis.TypeBar;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
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
    
    
    protected GridPane PaneDialogError;
    protected GridPane PaneDialog;
    protected GridPane PaneDialogAS;
    protected GridPane PaneDialogSave;
    protected GridPane PaneDialogLoad;
    protected GridPane PaneDialogAD;
    
    protected Dialog<String> dialogError;
    protected Dialog<String> dialogTT;
    protected Dialog<String> dialogAS;
    protected Dialog<String> dialogSave;
    protected Dialog<String> dialogLoad;
    protected Dialog<String> dialogAD;
    
    protected ButtonType bcancel;
    protected ButtonType type;
    
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
    protected Button bsaveFile;
    protected Button bload;
    protected Button bcreateTT;
    protected Button bcreateNAS;
    protected Button bcreateNAD;
    protected Button bAppuiSimple;
    protected Button bAppuiDouble;
    protected Button bloadFile;
    protected Button bmatrice;
    
    protected TextField tpointx;
    protected TextField tpointy;
    protected TextField tSegPoint1;
    protected TextField tSegPoint2;
    protected TextField tTriangle1;
    protected TextField tTriangle2;
    protected TextField tTriangle3;
    protected TextField tAppuiTT;
    protected TextField tAppuiPos;
    protected TextField tAppuiNumero;
    protected TextField tAppui2TT;
    protected TextField tAppui2Pos;
    protected TextField tAppui2Numero;
    
    protected TextField tsave;
    protected TextField tload;
    
            
    
    protected VBox h3;
    protected HBox h1;
    protected HBox h2;
    protected VBox h4;
    protected HBox h5;
    protected VBox h6;
    protected VBox h7;
    protected VBox h8;
    
    protected Label lerror;
    protected Label lx;
    protected Label ly;
    protected Label lSegPoint1;
    protected Label lSegPoint2;
    
    public CanvasResizable zonedessin;
     public Interface_graphique(){
         
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
         bAppuiSimple=new Button("Appui Simple");
         bAppuiDouble=new Button("Appui Double");
         
         
        
         
         
         bload=new Button("Load");
         bload.setStyle("-fx-background-color: Aqua");
         bcreateTT=new Button("Create Triangle");
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
         bcreateNAS=new Button("Create Appui Simple");
         bcancel=ButtonType.CANCEL;
         bsaveFile=new Button("save file");
         bsaveFile.setStyle("-fx-background-color: MediumSeaGreen");
         bloadFile=new Button("load file");
         bloadFile.setStyle("-fx-background-color: Aqua");
         bcreateNAD=new Button("create Appui double");
         bmatrice=new Button("Calculer matrice");
         
         
         lerror=new Label("ERREUR DE SAISIE");
         lerror.setStyle("-fx-font-weight: bold;");
         lerror.setTextFill(Color.RED);
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
         
         tTriangle1=new TextField();
         tTriangle1.setPromptText("indice pt1");
         
         tTriangle2=new TextField();
         tTriangle2.setPromptText("indice pt2");
         
         tTriangle3=new TextField();
         tTriangle3.setPromptText("indice pt3");
         
         tAppuiTT=new TextField();
         tAppuiTT.setPromptText("indice TT");
         
         tAppui2TT=new TextField();
         tAppui2TT.setPromptText("indice TT");
         
         tAppuiNumero=new TextField();
         tAppuiNumero.setPromptText("numero ");
         
         tAppui2Numero=new TextField();
         tAppui2Numero.setPromptText("numero");
         
         tAppuiPos=new TextField();
         tAppuiPos.setPromptText("position du noeud");
         
         tAppui2Pos=new TextField();
         tAppui2Pos.setPromptText("position du noeud");
         
         tsave=new TextField();
         tsave.setPromptText("C:\\USERS\\..\\filename.txt");
         
         tload=new TextField();
         tload.setPromptText("C:\\USER\\...\\filename.txt");
       
         PaneDialog=new GridPane();
         PaneDialog.setPrefSize(300, 300);
         PaneDialogAS=new GridPane();
         PaneDialogAS.setPrefSize(300, 300);
         PaneDialogError=new GridPane();
         PaneDialogError.setPrefSize(200, 100);
         PaneDialogSave=new GridPane();
         PaneDialogSave.setPrefSize(200, 100);
         PaneDialogLoad=new GridPane();
         PaneDialogLoad.setPrefSize(200, 100);
         PaneDialogAD=new GridPane();
         PaneDialogAD.setPrefSize(300, 300);
         
         
         h1=new HBox(bpoint , bsegment,bnoeudS,bnoeudAS,bnoeudAD);
         h5 = new HBox(lx,tpointx,ly,tpointy,bcreateP,bcreateNS);
         h5.getStyleClass().add("jfx-decorator-buttons-container");
         h5.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW,
    CornerRadii.EMPTY,
    Insets.EMPTY)));
         h5.setSpacing(5);
         
         h3= new VBox(bTreillis,bTT,bAppuiSimple,bAppuiDouble,bclear,bsaveFile,bloadFile,bmatrice);
         h3.setSpacing(5);
         h3.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW,
    CornerRadii.EMPTY,Insets.EMPTY)));
         h4=new VBox(h1,h5);
         h2=new HBox(lSegPoint1,tSegPoint1,lSegPoint2,tSegPoint2,bcreateSeg,bcreateBar);
         h2.setSpacing(5);
         h2.getStyleClass().add("jfx-decorator-buttons-container");
         h2.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW,
    CornerRadii.EMPTY,
    Insets.EMPTY)));
         h6=new VBox(tTriangle1,tTriangle2,tTriangle3,bcreateTT);
         h6.setSpacing(5);
         h7=new VBox(tAppuiTT,tAppuiNumero,tAppuiPos,bcreateNAS);
         h7.setSpacing(5);
         h8=new VBox(tAppui2TT,tAppui2Numero,tAppui2Pos,bcreateNAD);
         
         PaneDialog.getChildren().add(h6);
         dialogTT=new Dialog<String>();
         dialogTT.getDialogPane().getButtonTypes().add(bcancel);
         dialogTT.getDialogPane().setContent(PaneDialog);
         dialogTT.setTitle("Create a Triangle Terrain");
         dialogTT.setResizable(true);
         
         PaneDialogAS.getChildren().add(h7);
         dialogAS=new Dialog<String>();
         dialogAS.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
         dialogAS.getDialogPane().setContent(PaneDialogAS);
         dialogAS.setTitle("Create Noeud Appui Simple");
         dialogAS.setResizable(true);
         
         PaneDialogAD.getChildren().add(h8);
         dialogAD=new Dialog<String>();
         dialogAD.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
         dialogAD.getDialogPane().setContent(PaneDialogAD);
         dialogAD.setTitle("create Noeud Appui Double");
         dialogAD.setResizable(true);
         
         PaneDialogError.getChildren().add(lerror);
         dialogError=new Dialog<String>();
         dialogError.setTitle("ERREUR");
         type=new ButtonType("Ok", ButtonData.OK_DONE);
         dialogError.setContentText("Erreur de saisie");
         dialogError.getDialogPane().getButtonTypes().add(type);
         dialogError.getDialogPane().setContent(PaneDialogError);
         dialogError.setResizable(true);
         dialogError.setHeaderText("Information Alert");
         
         PaneDialogSave.add(tsave,0,0);
         PaneDialogSave.add(bsave,0,3);
         dialogSave=new Dialog<String>();
         dialogSave.setTitle("Save");
         dialogSave.setHeaderText("Choose file path to save");
         dialogSave.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
         dialogSave.getDialogPane().setContent(PaneDialogSave);
         
         PaneDialogLoad.add(tload,0,0);
         PaneDialogLoad.add(bload,0,3);
         dialogLoad =new Dialog<String>();
         dialogLoad.setTitle("Load");
         dialogLoad.setHeaderText("Choose file path to load from");
         dialogLoad.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
         dialogLoad.getDialogPane().setContent(PaneDialogLoad);
         
         
         
         
         
         
         
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
    bmatrice.setOnAction(new EventHandler<ActionEvent>(){
        @Override public void handle(ActionEvent e){
            treillis.calculMatrice1();
        }
    });
    bclear.setOnAction(new EventHandler<ActionEvent>(){
        @Override public void handle(ActionEvent e){
            zonedessin.clear();
            Disable();   
        }
    });
    bload.setOnAction(new EventHandler<ActionEvent>(){
        @Override public void handle(ActionEvent e){
            try{
                String s=tload.getText();    
            treillis.load(zonedessin.canvas.getGraphicsContext2D(),s);
        
            }catch (IOException ioe) {
	   ioe.printStackTrace();
           showError();
        }
        }
    });
    bsaveFile.setOnAction(new EventHandler<ActionEvent>(){
        @Override public void handle(ActionEvent e){
            dialogSave.showAndWait();
        }
    });
    bloadFile.setOnAction(new EventHandler<ActionEvent>(){
        @Override public void handle(ActionEvent e){
            dialogLoad.showAndWait();
        }
    });
    bTT.setOnAction(new EventHandler<ActionEvent>(){
        @Override public void handle(ActionEvent e){
            dialogTT.showAndWait();
        }
    });
    bAppuiSimple.setOnAction(new EventHandler<ActionEvent>(){
        @Override public void handle(ActionEvent e){
            dialogAS.showAndWait();
        }
    });
    bAppuiDouble.setOnAction(new EventHandler<ActionEvent>(){
        @Override public void handle(ActionEvent e){
            dialogAD.showAndWait();
        }
        });
    //creer un nouveau treillis 
    bTreillis.setOnAction(new EventHandler<ActionEvent>(){
        @Override public void handle(ActionEvent e){
            Enable();
             treillis = new Treillis();
        }
        
    });
    //creer une barre a partir des indices de deux noeuds
    bcreateBar.setOnAction(new EventHandler<ActionEvent>(){
        @Override public void handle(ActionEvent e){
            int indice1=Integer.parseInt(tSegPoint1.getText());
            int indice2=Integer.parseInt(tSegPoint2.getText());
            try{
            Noeud n1=(Noeud)treillis.listNoeud.get(indice1);
            
            Noeud n2=(Noeud)treillis.listNoeud.get(indice2);
            
            //System.out.println(n1.getId());
           // System.out.println(n2.getId());
           
           //assurer l'unicite de la barre
           Barre b=new Barre(n1,n2);
           int i=0;
           for(Barre barre:treillis.listBar){
               
               if(b.equals(barre)){
                   i++;
               }
           }
          if(i==0){
            b.drawBarre(zonedessin.canvas.getGraphicsContext2D());
            addBarre(b);
            addTypebar(b.getType());
           }
        }
        catch(Exception io){
            showError();
        }
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
    bcreateNAS.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e){
            int indiceTT=Integer.parseInt(tAppuiTT.getText());
            double pos=Double.parseDouble(tAppuiPos.getText());
            int numero=Integer.parseInt(tAppuiNumero.getText());
            
            Triangle_terrain t=treillis.listTriangle.get(indiceTT);
            
            Appui_simple n=new Appui_simple(t,numero,pos);
            addAppui(n);
            n.drawNoeud(zonedessin.canvas.getGraphicsContext2D());
        }
    });
    bcreateNAD.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e){
            int indiceTT=Integer.parseInt(tAppui2TT.getText());
            double pos=Double.parseDouble(tAppui2Pos.getText());
            int numero=Integer.parseInt(tAppui2Numero.getText());
            
            Triangle_terrain t=treillis.listTriangle.get(indiceTT);
            
            Appui_double n=new Appui_double(t,numero,pos);
            addAppui(n);
            n.drawNoeud(zonedessin.canvas.getGraphicsContext2D());
        }
            
        });
    //creer un tiangle terrain a partir des indices des points
    bcreateTT.setOnAction(new EventHandler<ActionEvent>(){
        @Override 
        public void handle(ActionEvent e){
            int indice1 =Integer.parseInt(tTriangle1.getText());
            int indice2 =Integer.parseInt(tTriangle2.getText());
            int indice3=Integer.parseInt(tTriangle3.getText());
            try{
            Point p1=(Point) treillis.listPoint.get(indice1);
            Point p2=(Point)treillis.listPoint.get(indice2);
            Point p3=(Point)treillis.listPoint.get(indice3);
            
            
            Triangle_terrain t =new Triangle_terrain(p1,p2,p3);
            t.drawTriangle(zonedessin.canvas.getGraphicsContext2D());
            addTT(t);
            }catch(Exception io){
                showError();
            }
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
     //le bouton save permet de sauvegarder les donner dans un fichier texte
bsave.setOnAction(new EventHandler<ActionEvent>(){
        @Override public void handle (ActionEvent e){
            try{
                String s =tsave.getText();   
            treillis.save(s);
        }catch (IOException ioe) {
	   ioe.printStackTrace();
           showError();
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
     public void addAppui(Noeud_appui n){
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
     public void addTT(Triangle_terrain t){
         treillis.getNum().getOrCreateKey(t);
         t.setId( treillis.getNum().getOrCreateKey(t));
         treillis.addTriangle(t);
         
     }
     public void addTypebar(TypeBar type){
         treillis.getNum().getOrCreateKey(type);
         type.setId( treillis.getNum().getOrCreateKey(type));
         treillis.addTypebar(type);
     }
    public void showError(){
        this.dialogError.showAndWait();   
    }
    
     
     }

