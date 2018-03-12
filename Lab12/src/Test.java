

import csci152.adt.SortedQueue;

import csci152.impl.LinkedListSortedQueue;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rauan Amangeldiyev
 */
public class Test {
    public static void main(String[] str){
     /*   LinkedListSortedQueue<Integer> n =  new LinkedListSortedQueue();
     for(int i=5; i<=915;i+=10){
         n.insert(i);
     }
         try{
             int t;
              for(int i=5; i<=915;i+=10){
         t = n.dequeue();
     }
        
         }catch(Exception ex){
             System.out.println(ex.getMessage());
         }
        System.out.println(n);
        System.out.println(n.getSize());
   */
     SortedQueue<Student> n = new LinkedListSortedQueue();
     Student s1,s2, s3,s4,s5;
             
             s1= new Student("A", 1);
             s2= new Student("B", 2);
             s3= new Student("C", 4);
             s4= new Student("D", 3);
             s5= new Student("E", 5);
    n.insert(s1);
    n.insert(s2);
    n.insert(s3);
    n.insert(s4);
    n.insert(s5);
    try{
        Student t;
        t = n.dequeue();
    }catch(Exception ex){
        System.out.println(ex.getMessage());
    }
        System.out.println(n);
    }
}
