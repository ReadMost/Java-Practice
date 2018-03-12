/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;


import csci152.adt.SortedQueue;


/**
 *
 * @author Rauan Amangeldiyev
 * @param <T>
 */
public class LinkedListSortedQueue<T extends Comparable> implements SortedQueue<T> {

      private Node<T> front;
     
    private int size;
    
    public LinkedListSortedQueue(){
        
        front = null;
        size = 0;
    }
  
     @Override
    public void insert(T value) {
     Node<T> NewNode = new Node(value);
     if(size == 0 ){
        front = NewNode;
        size++;
    }else{
           if(value.compareTo(front.getValue())<=0){
               NewNode.setLink(front);
               front = NewNode;
               size++;
           }else{
                 Node<T> before = front;
               Node<T> after = front.getLink();
               for(int i=1; i<=size;i++){
                   if(i==size){
                       NewNode.setLink(after);
                       before.setLink(NewNode);
                       size++;
                       break;
                   }
                   else if(value.compareTo(after.getValue())<=0){
                       NewNode.setLink(after);
                       before.setLink(NewNode);
                       size++;
                       break;
                   }else{
                       before = after;
                       after = after.getLink();
                   }
               }
           }
                    
        }
          
    }
    
    @Override
    public T dequeue() throws Exception {
      T result;
        if(size == 0){
          throw new Exception("ERRORRRRRR, QUEUE is Empty");
      }else if(size == 1){
        result = front.getValue();
         
          front = null;
    }else{
          result = front.getValue();
          front = front.getLink();
      }
       
        size--;
       return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        front = null;
      
        size = 0;
    }
    
    public String toString(){
        String result = "";
        Node current = front;
        while(current!=null){
            result += current+" ";
            current = current.getLink();
        }
        return getSize() + "||  " + result;
    }

    
    public boolean isEmpty() {
        return size == 0;
    }

   
}
