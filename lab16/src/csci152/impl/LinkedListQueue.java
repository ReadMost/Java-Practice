/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;
import csci152.adt.Stack;

/**
 *
 * @author Rauan Amangeldiyev
 * @param <T>
 */
public class LinkedListQueue<T> implements Queue<T> {
/*
    private Node<T> top;
    private int size = 0;
    Node<T> n;
    public LinkedListStack(){
        top = null;
        size = 0;
         n = new Node(top);
    }
    @Override
    public void push(T value) {
       n.setValue(value);
       n.setLink(top);
       
       top = n;
       size++;
    }

    @Override
    public T pop() throws Exception {
       if(size==0)
        throw new UnsupportedOperationException("Emtyyyyy"); //To change body of generated methods, choose Tools | Templates.
       else {  
           T temp;
           temp = top.getValue();
           n.setLink(top.getLink());
       size--;
       return temp;
       }
       
    }

    @Override
    public int getSize() {
    return size;
    }

    @Override
    public void clear() {
      top = null;
        size = 0;
         n = new Node(top);
    }
    public String toString(){
        String s= "";
        Node<T> t;
        t = top;
        while(t !=null){
            s+= t.toString();
            t = t.getLink();
        };
        return s;
    }*/
      private Node<T> front;
      private Node<T> back;
    private int size;
    
    public LinkedListQueue(){
        
        front = null;
        back = null;
        size = 0;
    }
    @Override
    public void enqueue(T value) {
        Node<T> temp = new Node(value);
        if(size==0)front = temp;
        else{
          back.setLink(temp);  
        }
        back = temp;
        size++;
    }

    @Override
    public T dequeue() throws Exception {
      T result;
        if(size == 0){
          throw new Exception("ERRORRRRRR, QUEUE is Empty");
      }else if(size == 1){
        result = front.getValue();
          back = null;
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
        back = null;
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
