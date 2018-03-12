/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;
import csci152.adt.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rauan Amangeldiyev
 */
public class LLQueueSet<T> implements Set{
    private LinkedListQueue n;
    
    public LLQueueSet(){
        n = new LinkedListQueue<>();
    }
    
    @Override
    public void add(Object value) {
        if(!contains(value))
            n.enqueue(value);
    }

    @Override
    public boolean contains(Object value) {
    for(int i = 0; i<n.getSize(); i++){
        try{
            T t = (T) n.dequeue();
            n.enqueue(t);
            
            if(t.equals(value))
                return true;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }return false;
    }

    @Override
    public boolean remove(Object value) {
   if(contains(value)){
       for(int i =0; i<n.getSize();i++){
           T t;
           try {
               t = (T) n.dequeue();
               if(t!=value)
                n.enqueue(t);
           } catch (Exception ex) {
               System.out.println(ex.getMessage());
           }
        
           
       }return true;}
   else return false;
    }

    @Override
    public Object removeAny() throws Exception {
    if(n.getSize()==0){
        throw new Exception("The size is zero");
    }
    else{
        return n.dequeue();
    }
    }

    @Override
    public int getSize() {
   return n.getSize();
    }

    @Override
    public void clear() {
    n.clear();
    }
    
    public String toString(){
        return n.toString();
    }
    
}
