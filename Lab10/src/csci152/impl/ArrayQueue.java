/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;


import csci152.adt.Queue;

/**
 *
 * @author Rauan Amangeldiyev
 * @param <T>
 */
public class ArrayQueue<T> implements Queue<T> {
 
    
   
     private T[] values;
    private int size, front, back,s;
    
    public ArrayQueue(){
        s=5;
        values = (T[]) new Object[s];
        size = 0;
        front = -1;
        back = -1;
    }
    @Override
    public void enqueue(T value){
       if(front != (back+1)%s){
           if(size==0) front++;
          back = (back+1)%s;
           values[back] = value;
          size++;
      } else {
           T[] temp = (T[]) new Object[2*s];
           for(int i = 0; i<s; i++){
               temp[i] = values[(front+i)%s];
           }
           values = (T[]) new Object[s*2];
           for(int i = 0; i<s; i++){
               values[i] = temp[i];
           }
           front = 0;
           values[s] = value;
           size++;
           back = s;
           s*=2;
           
       }
        
        
    }

    @Override
    public T dequeue() throws Exception {
        T r;
        if(size == 0) throw new Exception("queque is empty");
        else {
            r = values[front];
            values[front] = null;
            front = (front+1)%s;
            size--;
        }
    return r;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        values = (T[]) new Object[5];
        size = 0;
        front = -1;
        back = -1;
    }
    
    @Override
    public String toString(){        
        String result ="";
        int f = front;
        for(int i =0; i<size; i++) {
            result += String.valueOf(values[f])+" ";
            f = (f+1<values.length) ? f+1 : 0;   
        }
        
        return result;
    }
}


