/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.IntStack;
import csci152.adt.Stack;
/**
 *
 * @author Rauan Amangeldiyev
 * @param <T>
 */
public class ArrayStack<T> implements Stack<T>{

    private T[] values, values1;
    private int size, general;
    
    public ArrayStack(){
        general = 10;
        values = (T[])new Object[general];
        size = 0;
    }
    
    @Override
    public void push(T value) {
        
    if(size == general){
      values1 = (T[])new Object[general];
        for(int i = 0; i< general; i++){
          values1[i] = values[i];
      }
        
      general*=2;
      values = (T[])new Object[general];
         for(int i = 0; i< general/2; i++){
          values[i] = values1[i];
      }
    }
       
    values[size] = value;
    size++;
    }

    @Override
    public T pop() throws Exception {
        if(size == 0){
            throw new Exception("In array no item to pop!!!");}
        else {T result = values[size-1];
    size--;
    return result
            ;}
    }

    @Override
    public int getSize() {
     return size;
    }

    @Override
    public void clear() {
        values = (T[]) new Object[general];
//    for(int i=size;i>=0;i--){
//        values[i] = 0;
//    }
    size = 0;
    }
    
    public String toString(){
        if(size <= 0){
            size = 0;
            return "bottom[]top";
        }
        
        else{
        String s="bottom[";
      for(int i=0; i<size-1; i++)
        {s += (values[i] + ",");} 
        s += values[size-1] + "]top";
        return s;
        }
    }
    
}
