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
        front = s;
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
        front = s;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            return "bottom[]top";
        }
        
        else{
        String se="bottom[";
        int f = front;
      for(int i=0; i<size-1; i++)
        {se += (array[f] + ",");
        f = (f+1<array.length) ? f+1 : 0;} 
        se += array[size] + "]top";
        
        return se;
        }
    }
    */
    
    
     private int[] values;
    private int size, front, back;
    
    public ArrayIntQueue(){
        values = new int[5];
        size = 0;
        front = -1;
        back = -1;
    }
    @Override
    public void enqueue(int value){
        int back1 = ((back +1)<values.length) ? back +1 : 0;
        
        if(back1== front){
            int[] newAr = new int[size+5];
            for (int i=0; i<values.length; i++){                
                newAr[i] = values[front];
                front = (front+1<values.length) ? front+1 : 0;                
            }
            front=0;
            back = values.length;
            values = newAr;
            values[back] = value;
            size++;
            
        } else{
            if(front<0) front++;
            values[back1] = value;
            back = back1;
            size++;
        }
        
    }

    @Override
    public int dequeue() throws Exception {
        if(size == 0) throw new Exception("queque is empty");
        int result = values[front];
        size--;
        if(front == back) this.clear();
        front = (front+1)< values.length ? front+1 : 0;
        
        return result;
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


