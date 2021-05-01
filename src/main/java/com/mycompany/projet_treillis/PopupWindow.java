/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projet_treillis;

import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;

/**
 *
 * @author cz
 */
public class PopupWindow extends SplitPane{
    Label lerror;
    public PopupWindow(){
        this.setPrefSize(200, 200);
        lerror=new Label("ERROR");
        this.getChildren().add(lerror);
    }
    
    
}
