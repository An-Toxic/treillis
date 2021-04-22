/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.treillis;

/**
 *
 * @author cz
 */
public class ResGauss {
    int rang ;
    int sigPerm ;
        
    public ResGauss(int a , int b){
        this.rang=a ;
        this.sigPerm=b;
    
    }
    public String toString(){
        String s=("[resultat trouve: rang = "+this.rang+"; sigPerm = "+this.sigPerm+"]");
    return s;
    }
    
    }
    

