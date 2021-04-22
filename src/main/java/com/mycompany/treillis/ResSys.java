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
public class ResSys {
    public Matrice sol;
    public boolean isSolUnique;
        
        public ResSys(Matrice solution , boolean unique){
            this.isSolUnique=unique ;
            this.sol=solution;
        }
        
  public String toString(){
     String s = this.sol.toString();
          String res=s+"  "+"solution unique =="+this.isSolUnique;
      return  res;
  }
      
      
  }
    
    

