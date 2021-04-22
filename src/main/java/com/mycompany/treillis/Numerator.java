/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.treillis;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cz
 */
public class Numerator {
    protected  Map<Integer,Object> keytoObj;
    protected Map<Object,Integer> objtoKey;
    protected int nextKey;
    
    public Numerator(int cle){
        this.nextKey =cle;
        keytoObj=new HashMap();
        objtoKey=new HashMap();
    }
    public boolean estpresent(Object obj){
        return(this.objtoKey.get(obj)!=null);
    }
    public int getOrCreateKey(Object obj){
        if (this.objtoKey.get(obj)!=null){
            return this.objtoKey.get(obj);
            
        }
        else {
            this.objtoKey.put(obj, nextKey);
            this.keytoObj.put(nextKey,obj);
            nextKey++;
            return nextKey-1;
        }
    }
}
