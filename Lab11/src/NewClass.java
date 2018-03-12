
import csci152.adt.Stack;
import csci152.impl.LinkedListStack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rauan Amangeldiyev
 */
public class NewClass {
    public static boolean isIncreasing(Stack<Double> st){
      Stack<Double> temp = new LinkedListStack();
      double k=1.0, max = 0;
      int counter = 0, counter1=0;
      
      while(st.getSize()!=0){
         double cof = 0;
          try{ cof = st.pop();
             temp.push(cof);
         }
         catch(Exception ex){
             System.out.println(ex.getMessage());
         }
         if(k==1.0){
             max = cof;
             k=2.0;
         }else{
             if(max>cof) counter++;
         }
         counter1++;
      }
       while(temp.getSize()!=0){
       try{st.push(temp.pop());}
       catch(Exception e){
           System.out.println(e.getMessage());
       }
       }
      return (counter1 == counter);
    }
    public static void main(String[] str){
        Stack<Double> n = new LinkedListStack();
        n.push(5.0);
        n.push(4.0);
        n.push(6.0);
        n.push(8.0);
        System.out.println(isIncreasing(n));
    }
}
