
import csci152.adt.Queue;
import csci152.adt.Stack;
import csci152.impl.LinkedListQueue;
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
public static boolean isBalanced(Queue<Character> q){
if(q.getSize() == 0)return true;
else{ int iteration =0;
    Queue<Character> c = new LinkedListQueue();
    Stack<Character> r = new LinkedListStack();
         
           while(q.getSize()>0){
               try{ char temp = q.dequeue();
                if(temp == '}' || temp == ')' || temp == ']' || temp == '{' || temp == '(' || temp == '['){
                c.enqueue(temp);
             if(temp == '}' || temp == ')' || temp == ']'){
               r.push(temp);
             }else{
                 if(temp=='{')if(r.pop() == '}')iteration++;
                 if(temp=='[')if(r.pop() == ']')iteration++;
                 if(temp=='(')if(r.pop() == ')')iteration++;
             } } }
           catch(Exception ex){
               System.out.println(ex.getMessage());
           }}

               while(c.getSize()>0){
                  try{ char temp = c.dequeue();
                  q.enqueue(temp);
           }catch(Exception ex){
               System.out.println(ex.getMessage());
           }   }
        System.out.println(iteration);
     return iteration== q.getSize()/2;
}
}
public static boolean isPalindrome(Queue<Character> q){
   int counter = 0;
   int s = q.getSize();
    if(q.getSize()==0)
        return true;
    else {  
            Queue<Character> c = new LinkedListQueue();
            Stack<Character> r = new LinkedListStack();
         
           while(q.getSize()>0){
               try{ char temp = q.dequeue();
               c.enqueue(temp);
               r.push(temp);
           }catch(Exception ex){
               System.out.println(ex.getMessage());
           }   
           }
           int iteration = 0;
           while(c.getSize()>0){
                  try{ char temp = c.dequeue();
                  if(s/2 > iteration)if(temp == r.pop())counter++;
                  q.enqueue(temp);
           }catch(Exception ex){
               System.out.println(ex.getMessage());
           }
                  iteration ++; 
           }
           
    return counter == s/2;
            }
    
}
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
//        Stack<Double> n = new LinkedListStack();
//        n.push(1.0);
//        n.push(7.1);
//        n.push(7.1);
//        n.push(10.0);
//        System.out.println(isIncreasing(n));
//        System.out.println(n);

            Queue<Character> m = new LinkedListQueue();
            
//            for(char i= 'a'; i<='d';i++){
//                m.enqueue(i);
//            }
//            m.enqueue('z');
//             for(char i= 'd'; i>='a';i--){
//                m.enqueue(i);
//            }
//            try{
//                  
//                    
//                    }catch(Exception ex){
//                        System.out.println(ex.getMessage());
//                    }
//           // m.clear();
//           System.out.println(isPalindrome(m));

            m.enqueue(']');
             m.enqueue(')');
              m.enqueue(']');
               m.enqueue('[');
                m.enqueue('(');
                   m.enqueue(']');
               m.enqueue('[');
                 m.enqueue('[');
                 System.out.println(isBalanced(m));
        System.out.println(m);
    }
}
