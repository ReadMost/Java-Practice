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
import csci152.adt.IntStack;
import csci152.impl.ArrayIntQueue;
import csci152.impl.ArrayIntStack;

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
   public static int evenCount(IntStack stk) throws Exception{ 
int ans = 0; 
IntStack temp = new ArrayIntStack(); 
while(stk.getSize()>0){ 
int top = stk.pop(); 
if(top % 2 == 0)ans++; 
temp.push(top); 
} 

while(temp.getSize()>0){ 
stk.push(temp.pop()); 
} 
return ans; 

} 

public static IntStack copyStack(IntStack orig) throws Exception{ 
IntStack temp = new ArrayIntStack(), ans = new ArrayIntStack(); 

while(orig.getSize() > 0){ 
temp.push(orig.pop()); 
} 

while(temp.getSize() > 0){ 
int top = temp.pop(); 
ans.push(top); 
orig.push(top); 
} 

return ans; 
} 

public static IntQueue copyQueue(IntQueue orig) throws Exception{
IntQueue ans = new ArrayIntQueue(); 

for(int i=0;i<orig.getSize();i++){ 
int next = orig.dequeue(); 
ans.enqueue(next); 
orig.enqueue(next); 
} 

return ans; 

} 

public static void reverseStack(IntStack toRev) throws Exception{ 
IntQueue temp = new ArrayIntQueue(); 

while(toRev.getSize() > 0){ 
temp.enqueue(toRev.pop()); 
} 

while(temp.getSize() > 0){ 
toRev.push(temp.dequeue()); 
} 
} 

public static void reverseQueue(IntQueue toRev) throws Exception{
IntStack temp = new ArrayIntStack(); 

while(toRev.getSize() > 0){ 
temp.push(toRev.dequeue()); 
} 

while(temp.getSize() > 0){ 
toRev.enqueue(temp.pop()); 
} 
} 

public static boolean isPalindrome(IntQueue q) throws Exception{ 
IntQueue temp = copyQueue(q); 
reverseQueue(temp); 
boolean ans = true; 
for(int i=0;i<q.getSize();i++){ 
int next = q.dequeue(); 
if(next != temp.dequeue())ans = false; 

q.enqueue(next); 
} 
return ans; 
} 

public static void insert(IntStack st, int pos, int val) throws Exception{ 

if(st.getSize() == pos)st.push(val); 

else { 
int cur = st.pop(); 
insert(st,pos,val); 
st.push(cur); 
} 
} 

public static IntStack merge(IntStack s1, IntStack s2) throws Exception{ 
reverseStack(s1); 
reverseStack(s2); 
IntStack ans = new ArrayIntStack(); 
while(s1.getSize()>0 || s2.getSize()>0){ 
if(s2.getSize() == 0)ans.push(s1.pop()); 
else if(s1.getSize() == 0)ans.push(s2.pop()); 
else{ 
int f = s1.pop(),s = s2.pop(); 
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

IntStack stk = new ArrayIntStack(); 
IntStack stk1 = new ArrayIntStack(); 
for(int i=0;i<10;i++){ 
stk.push(i); 
} 
for(int i=10;i>0;i--){ 
stk1.push(i); 
}
IntStack newstk; 
System.out.println("Even: " + evenCount(stk)); 

newstk = copyStack(stk); 
System.out.println("Copy of the stack: " + newstk); 

stk = merge(stk, newstk); 
System.out.println("Merging two stacks: " + stk); 

insert(stk, 5, 100); 

System.out.println("Inserting 100 to pos 5: " + stk); 

IntQueue que = new ArrayIntQueue(); 
//
//for(int i=1;i<=5;i++){ 
//que.enqueue(i); 
//} 
//for(int i=4;i>0;i--){ 
//que.enqueue(i); 
//} 
//
//System.out.println(que + " | Is Palindrome: " + isPalindrome(que)); 
} 

}