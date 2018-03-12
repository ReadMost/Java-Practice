

import csci152.adt.Deque;
import csci152.adt.Set;
import csci152.adt.SortedQueue;
import csci152.impl.LLQueueSet;
import csci152.impl.LLStackSet;
import csci152.impl.LinkedListDeque;

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
    
 public static Set<String> union(Set<String> set1, Set<String> set2) throws Exception{
if(set1.getSize()==0){
return set2;
}else if(set2.getSize()==0){
return set1;
}

Set<String> res = new LLQueueSet();
LinkedListDeque<String> tempd = new LinkedListDeque<>() ; 
int a = set1.getSize();
int b = set2.getSize();
while(set1.getSize()!=0){
tempd.pushToFront(set1.removeAny());
}
while(set2.getSize()!=0){
tempd.pushToBack(set2.removeAny());
}
for(int i =0;i<a;i++){
String x = tempd.popFromFront();
res.add(x);
set1.add(x);
}
for(int i =0;i<b;i++){
String x = tempd.popFromBack();
res.add(x);
set2.add(x);
}
return res;

}
    
 public static boolean isSubset(Set<Integer> set1, Set<Integer> set2){
        int size = set1.getSize();
        for (int i = 0; i < size; i++) {
            try {
              Integer temp = set1.removeAny();
              set1.add(temp);
              if(!set2.contains(temp)) return false;  
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
        return true;
    }
    
  public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> result = new LLQueueSet();
        int size = set1.getSize();
        for (int i = 0; i < size; i++) {
            try {
                Integer temp = set1.removeAny();
                set1.add(temp);
                if(set2.contains(temp)) result.add(temp);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        return result;
        
    
}
 
 
    
    public static void main(String[] str) throws Exception{
    Student s = new Student("Rauan", 1);
     Student s1 = new Student("Erke", 2);
      Student s2 = new Student("Beka", 3);
       Student s3 = new Student("Sale", 4);
       
       Set<Student> set = new LLQueueSet();
       set.add(s);
       set.add(s1);
       set.add(s2);
       set.add(s3);
       
       set.remove(s2);
       
        System.out.println(set);
         set.add(s3);
       set.removeAny();
        System.out.println(set);
       
        
        
        Set<Student> LLL = new LLStackSet();
try{
LLL.removeAny();
}catch (Exception ex){
System.out.println(ex.getMessage());
}
System.out.println(LLL);
System.out.println("Size is "+LLL.getSize());

LLL.add(new Student("Bob", 123));
LLL.add(new Student( "Tommy", 2222));
LLL.add(new Student("Mickey", 555));
LLL.add(new Student("Stark", 6666));
LLL.add(new Student("Batman", 7777));
System.out.println(LLL);
System.out.println("Size is "+LLL.getSize());

LLL.remove(new Student("Stark", 6666));
System.out.println(LLL);
System.out.println("Size is "+LLL.getSize());

LLL.remove(new Student("Maxwell", 5555));
System.out.println(LLL);
System.out.println("Size is "+LLL.getSize());

LLL.add(new Student( "Bob", 123));
LLL.add(new Student( "Tommy", 2222));
System.out.println(LLL);
System.out.println("Size is "+LLL.getSize());


System.out.println(LLL.removeAny());
System.out.println(LLL.removeAny());
System.out.println(LLL);
System.out.println("Size is "+LLL.getSize());

LLL.clear();
System.out.println(LLL);
System.out.println("Size is "+LLL.getSize());



Set<Integer> p1 = new LLQueueSet();
p1.add(1);
p1.add(2);
p1.add(3);
p1.add(4);
Set<Integer> p2 = new LLQueueSet();
for(int i=1;i<11;i++){
p2.add(i);
}
//----------------------------------------------
 Set<Integer> sss2 = new LLQueueSet();
        Set<Integer> sss1 = new LLQueueSet();
        for(int i=0;i<9;i++){
            sss1.add(i*2);
        }
        for(int i=0;i<13;i++){
            sss2.add(i*2);
        }    
        
        System.out.println(isSubset(sss1, sss2));
        System.out.println(sss1);
        System.out.println(sss2);
        
        
        System.out.println("================");
        System.out.println("================");
        System.out.println("================");

        
        Set <String> ssss1 = new LLQueueSet();
        Set <String> ssss2 = new LLQueueSet();
        
        ssss1.add("Java");
        ssss1.add("Javascript");
        ssss1.add("Python");
        ssss1.add("SQL");
        ssss1.add("C#");
        ssss1.add("C++");
        ssss2.add("Java");
        ssss2.add("HTML");
        ssss2.add("CSS");
        ssss2.add("Ruby");
        
        System.out.println(union(ssss1,ssss2));

        System.out.println("================");
        System.out.println("================");
        System.out.println("================");

        
        System.out.println(intersection(sss1,sss2));

}}
