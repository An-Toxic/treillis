/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.treillis;

import java.util.Scanner;

/**
 *
 * @author cz
 */
public class MatriceSolution extends Matrice {
    protected double[][]m;
    protected double []s;
    public MatriceSolution(int nbrEquations){
        super(nbrEquations);
        m=new double[nbrEquations+1][nbrEquations];
        s=new double[nbrEquations];
        
        
    }
    public void create(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner ob
       
        for(int i=0;i<nbrLig;i++){
            System.out.println("the equation "+i+"\n");
            for (int j = 0; j < nbrLig; j++)
			{
                             double coeffs=myObj.nextDouble();
                            System.out.print("coeff "+j+"=");
                            
                            m[j][i]=coeffs;
                            System.out.println(" ");
                        }
            System.out.println("deuxieme membre "+i+"=");
            m[nbrLig][i]=myObj.nextDouble();
            System.out.println(" ");
            //on a cree la matrice des inconnues avec les 2 membres;
            
        }
    }
    public void resultat(){
        this.resolution();
    }
    
}
