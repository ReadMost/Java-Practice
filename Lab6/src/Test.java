//
//import csci152.adt.IntStack;
//import csci152.impl.ArrayIntStack;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author Rauan Amangeldiyev
// */
//public class Test {
//    public static void main(String[] str){
//        IntStack a = new ArrayIntStack();
//        a.push(1);
//        a.push(2);
//        a.push(3);
//        a.push(4);
//        a.push(5);
//        a.push(6);
//        a.push(7);
//        a.push(8);
//        a.push(9);
//        a.push(10);
//        a.push(11);
//        a.push(12);
//          a.push(1);
//        a.push(2);
//        a.push(3);
//        a.push(4);
//        a.push(5);
//        a.push(6);
//        a.push(7);
//        a.push(8);
//        a.push(9);
//        a.push(10);
//       
//        try{
////       int r = a.pop();
////      r = a.pop();
//        }
//            catch(Exception ex){
//                    System.out.println(ex.getMessage());
//                    }
//       // a.clear();
//        System.out.println(a);
//        System.out.println("size: " + a.getSize());
//    }
//}



import csci152.adt.IntQueue;
import csci152.impl.ArrayIntQueue;

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
      IntQueue a = new ArrayIntQueue();
      
      a.enqueue(1);
      a.enqueue(2);
      a.enqueue(3);
      a.enqueue(4);
    a.enqueue(5);
     
   
      
      
        try{
//       int r = a.pop();
//      r = a.pop();
int t =  a.dequeue();
t =  a.dequeue();

        }
            catch(Exception ex){
                    System.out.println(ex.getMessage());
                    }
           a.enqueue(6);
           a.enqueue(7);
       
     
       //a.clear();
        System.out.println(a);
    }
}