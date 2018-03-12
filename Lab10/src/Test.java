
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
public class Test {
  //  public static void main(String[] str){
//       Stack<Integer> n = new LinkedListStack();
//        n.push(5);
//        n.push(4);
//        n.push(6);
//        n.push(8); 
//        try{int t;
//           // t = n.pop();
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        System.out.println(n);
//    }


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
             if(max>=cof) counter++;
             max =cof;
         }
        
      }
       while(temp.getSize()!=0){
            counter1++;
       try{st.push(temp.pop());}
       catch(Exception e){
           System.out.println(e.getMessage());
       }
       }
      return (counter1 == counter+1);
    }
    public static void main(String[] str){
        Stack<Double> n = new LinkedListStack();
        n.push(1.0);
        n.push(7.1);
        n.push(7.0);
        n.push(10.0);
        System.out.println(isIncreasing(n));
        System.out.println(n);
    }
}
