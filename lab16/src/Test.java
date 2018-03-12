
import csci152.adt.Set;
import csci152.impl.BSTSet;
import csci152.impl.TreeNode;





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
   public static void main(String[] str) {
       Set<Integer> n = new BSTSet();
      
       n.add(5);
       n.add(12);
       n.add(3);
       n.add(6);
       n.add(14);
       n.add(2);
       n.add(-6);
       n.add(8);
       n.add(0);
       
       n.add(12);
       n.add(7);
       n.add(2);
       n.add(-8);
       n.add(5);
       
      
       System.out.println(n);
       System.out.println(n.getSize());
        boolean b = false;
       
//          b = n.remove(7);
//       
//       System.out.println(b);
//        System.out.println(n);
//        System.out.println(n.getSize());
//        
        
     
      Set m = new BSTSet();
       m.add(new Student("A", 1));
       m.add(new Student("B", 2));
       m.add(new Student("C", 3));
       m.add(new Student("D", 4));
       m.add(new Student("F", 5));
       System.out.println(m);
       
      
   }

}
