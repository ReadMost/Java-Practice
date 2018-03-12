//
//import csci152.adt.Stack;
//import csci152.impl.ArrayStack;
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
//        Stack a = new ArrayStack();
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



import csci152.adt.Queue;
import csci152.adt.Stack;
import csci152.impl.ArrayQueue;
import csci152.impl.ArrayStack;

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
   public static int evenCount(Stack stk) throws Exception{ 
int ans = 0; 
Stack temp = new ArrayStack(); 
while(stk.getSize()>0){ 
Integer top = (Integer) stk.pop(); 
if(top % 2 == 0) ans++; 
temp.push(top); 
} 

while(temp.getSize()>0){ 
stk.push(temp.pop()); 
} 
return ans; 

} 

public static Stack copyStack(Stack orig) throws Exception{ 
Stack temp = new ArrayStack(), ans = new ArrayStack(); 

while(orig.getSize() > 0){ 
temp.push(orig.pop()); 
} 

while(temp.getSize() > 0){ 
Integer top = (Integer) temp.pop(); 
ans.push(top); 
orig.push(top); 
} 

return ans; 
} 

public static Queue copyQueue(Queue orig) throws Exception{
Queue ans = new ArrayQueue(); 

for(int i=0;i<orig.getSize();i++){ 
Integer next = (Integer) orig.dequeue(); 
ans.enqueue(next); 
orig.enqueue(next); 
} 

return ans; 

} 

public static void reverseStack(Stack toRev) throws Exception{ 
Queue temp = new ArrayQueue(); 

while(toRev.getSize() > 0){ 
temp.enqueue(toRev.pop()); 
} 

while(temp.getSize() > 0){ 
toRev.push(temp.dequeue()); 
} 
} 

public static void reverseQueue(Queue toRev) throws Exception{
Stack temp = new ArrayStack(); 

while(toRev.getSize() >1){ 
temp.push(toRev.dequeue()); 
} 

while(temp.getSize() > 0){ 
toRev.enqueue(temp.pop()); 
} 
} 

public static boolean isPalindrome(Queue q) throws Exception{ 
Queue temp = copyQueue(q); 
reverseQueue(temp); 
boolean ans = true; 
for(int i=0;i<q.getSize();i++){ 
Integer next = (Integer) q.dequeue(); 
if(next != temp.dequeue())ans = false; 

q.enqueue(next); 
} 
return ans; 
} 

public static void insert(Stack st, int pos, int val) throws Exception{ 

if(st.getSize() == pos)st.push(val); 

else { 
Integer cur = (Integer) st.pop(); 
insert(st,pos,val); 
st.push(cur); 
} 
} 

public static Stack merge(Stack s1, Stack s2) throws Exception{ 
reverseStack(s1); 
reverseStack(s2); 
Stack ans = new ArrayStack(); 
while(s1.getSize()>0 || s2.getSize()>0){ 
if(s2.getSize() == 0)ans.push(s1.pop()); 
else if(s1.getSize() == 0)ans.push(s2.pop()); 
else{ 
Integer f = (Integer) s1.pop(),s = (Integer) s2.pop(); 
if(f < s){ 
ans.push(f); 
s2.push(s); 
} 
else { 
ans.push(s); 
s1.push(f); 
} 
} 
} 

return ans; 
} 

public static void main(String args[]) throws Exception{ 

Stack<Integer> stk = new ArrayStack(); 
Stack<Integer> stk1 = new ArrayStack(); 
for(int i=0;i<10;i++){ 
stk.push(i); 
} 
for(int i=10;i>0;i--){ 
stk1.push(i); 
}
Stack<Integer> newstk; 
System.out.println("Even: " + evenCount(stk)); 

newstk = copyStack(stk); 
System.out.println("Copy of the stack: " + newstk); 

stk = merge(stk, newstk); 
System.out.println("Merging two stacks: " + stk); 

insert(stk, 5, 100); 

System.out.println("Inserting 100 to pos 5: " + stk); 

Queue<Integer> que = new ArrayQueue(), que1 = new ArrayQueue(); 

for(int i=1;i<=4;i++){ 
que.enqueue(i); 
} 
for(int i=2;i>=1;i--){ 
que.enqueue(i); 
} 
//for(int i=4;i>0;i--){ 
//que.enqueue(i); 
//} 
//

    System.out.println("the copy of " + que + " is " + copyQueue(que));    

System.out.print(que + " | Is Reverse: "); 
    reverseQueue(que);
    System.out.println(que);

    boolean t = isPalindrome(que);
    System.out.println(que + " | Is Palindrome: "+ t); 


} 


}