
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
public class Test1 {
    public static void main(String[] str){
      IntQueue a = new ArrayIntQueue();
      
      a.enqueue(5);
      a.enqueue(3);
      
        try{
//       int r = a.pop();
//      r = a.pop();
        }
            catch(Exception ex){
                    System.out.println(ex.getMessage());
                    }
       // a.clear();
        System.out.println(a);
    }
}
