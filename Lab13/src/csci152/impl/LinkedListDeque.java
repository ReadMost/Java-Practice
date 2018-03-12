/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Deque;


/**
 *
 * @author Rauan Amangeldiyev
 * @param <T>
 */
public class LinkedListDeque<T> implements Deque<T> {
    private DoublyLinkedNode<T> back;
    private DoublyLinkedNode<T> front;
    private int size;
    public LinkedListDeque(){
        back = null;
        front = null;
        size = 0;
    }
    @Override
    public void pushToFront(T value) {
    DoublyLinkedNode<T> n = new DoublyLinkedNode(value);
        if(size == 0){
        back = n;
        front = n;
        size++;
    }
        else{
            front.setPrevious(n);
            n.setNext(front);
            n.setPrevious(null);
            front = n;
            size++;
        }
    }

    @Override
    public void pushToBack(T value) {
         DoublyLinkedNode<T> n = new DoublyLinkedNode(value);
    if(size == 0){
        back = n;
        front = n;
        size++;
    }
    else{
        back.setNext(n);
        n.setPrevious(back);
        n.setNext(null);
        back = n;
        size++;
    }
    }

    @Override
    public T popFromFront() throws Exception {
    T result;
    if(size == 0)
        throw new Exception("sizeeeee is 0");
    else if(size == 1){
        result = back.getValue();
        size--;
        back = null;
        front = null;
    } else
    {
        result = front.getValue();
        front = front.getNext();
        size--;
    }
    return result;
            }

    @Override
    public T popFromBack() throws Exception {
    T result;
    if(size == 0)
        throw new Exception("sizeeeee is 0");
    else if(size == 1){
        result = back.getValue();
        size--;
        back = null;
        front = null;
    } else
    {
        result = back.getValue();
        back = back.getPrevious();
        size--;
    }
    return result;
    }

    @Override
    public int getSize() {
    return size;
    }

    @Override
    public void clear() {
    back = null;
    front = null;
    size = 0;
    }
    
    public String toString(){
        String result = "";
        DoublyLinkedNode current = front;
        while(current!= null){
            result += current+" ";
            current = current.getNext();
        }
        return getSize() + "||  " + result;
    }
}
