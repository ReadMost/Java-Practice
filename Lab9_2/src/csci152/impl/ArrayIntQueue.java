/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.IntQueue;

/**
 *
 * @author Rauan Amangeldiyev
 */
public class ArrayIntQueue implements IntQueue {
    
/*
    private int s,back, size, front, temp;
    private int[] array, array1;
    
    public ArrayIntQueue() {
        s = 3;
        array = new int[s];
        size = 0;
        front = 0;
        back = 0;
        temp = 0;
    }

    @Override
    public void enqueue(int value) {
//        int back1 = ((back+1)<s) ? back+1 : 0;
//        
//        if(back1 == front){
//          int[]  array1 = new int[s*2];
//            for(int i=0;i<s;i++){
//                array1[i] = array[front];
//                front = ((front+1)<s) ? front+1 : 0;
//            }
//front = 0;
//back = s;
//array = new int[s*2];
//array = array1;
//array[back] = value;
//size++;
//
//        }
//        else {
//            if(front<0)
//                front++;
//            array[back1] = value;
//            back = back1;
//            size++;
//        }

    if((back!=front && back!=(s)) || temp==0){
          array[back] = value;
          size++;
          back++;
      temp++;
      
    }
    else {
          array1 = new int[s*2];
        if(back==s){
        for(int i=0;i<s;i++){
         array1[i] = array[i];   
        }
       array = new int[s*2];
       for(int i=0;i<s;i++){
         array[i] = array1[i];   
        }
        array[s] = value;
        size++;
        back++;
        front = 0;
        s*=2;
            }
        else{
            for(int i = back; i<s; i++){
                array1[i-back] = array[i];
            }
            for(int i = 0; i<back; i++){
                array1[s-back+i] = array[i];
            }
            array = new int[s*2];
            array = array1;        
         array[s] = value;
        size++;
        back = s+1;
        front = 0;
        s*=2;
        } 
       
    }
        
    
   
    }

    @Override
    public int dequeue() throws Exception {
         if(size == 0) throw new Exception("queque is empty");
        int result = array[front];
        array[front]=0;
        size--;
        if(front == back) this.clear();
        front = (front+1)< array.length ? front+1 : 0;
        
        return result;
        
//       int y;
//        if(array[front]!=0){
//           if(front!=s-1){
//               y = array[front];
//               array[front] = 0;
//               front++;
//       }    else {
//               y = array[front];
//               array[front] = 0;
//               front=0;
//           }
//       }
//        else {
//        throw new Exception("there is no value");
//        }
//        return y;
    }

    @Override
    public int getSize() {
     return size; }

    @Override
    public void clear() {
    front = 0;
    back = 0;
    size = 0;
    array = new int[s];
    }
//public String toString(){
//      String r ="";
//        int f = front;
//        for(int i =0; i<s; i++) {
//            r += String.valueOf(array[f])+" ";
//            f = (f+1<array.length) ? f+1 : 0;   
//        }
//        
//        return r;
//        }
     public String toString(){
        if(size <= 0){
            size = 0;
            return "front[]back";
        }
        
        else{
        String se="front[";
        int f = front;
      for(int i=0; i<size; i++)
        {se += (array[f] + ",");
        f = (f+1<s) ? f+1 : 0;} 
        se += array[size] + "]back";
        
        return se;
        }
    }
    
    */
    
    
   
     private int[] values;
    private int size, front, back,s;
    
    public ArrayIntQueue(){
        s=5;
        values = new int[s];
        size = 0;
        front = -1;
        back = -1;
    }
    @Override
    public void enqueue(int value){
       if(front != (back+1)%s){
           if(size==0) front++;
          back = (back+1)%s;
           values[back] = value;
          size++;
      } else {
           int[] temp = new int[2*s];
           for(int i = 0; i<s; i++){
               temp[i] = values[(front+i)%s];
           }
           values = new int[s*2];
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
    public int dequeue() throws Exception {
        int r;
        if(size == 0) throw new Exception("queque is empty");
        else {
            r = values[front];
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
        values = new int[5];
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


