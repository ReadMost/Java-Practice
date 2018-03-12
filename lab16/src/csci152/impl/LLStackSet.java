/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Set;
import csci152.adt.Stack;

/**
 *
 * @author Rauan Amangeldiyev
 */
public class LLStackSet<T> implements Set<T> {
private LinkedListStack<T> stack;

public LLStackSet(){
stack = new LinkedListStack<>();
}

@Override
public void add(T value) {
if(!contains(value)){
stack.push(value);
}
}

@Override
public boolean contains(T value) {
Stack<T> temp = new LinkedListStack<>();
boolean res=false;

while(stack.getSize()!=0){
try {
T x = stack.pop();
temp.push(x);
if(x.equals(value)){
res= true;
}
} catch (Exception ex) {
System.out.println(ex.getMessage());
}
}
while(temp.getSize()!=0){
try {
stack.push(temp.pop());
} catch (Exception ex) {
System.out.println(ex.getMessage());
}
}
return res;

}

@Override
public boolean remove(T value) {
Stack<T> temp = new LinkedListStack<>();
boolean res=false;

while(stack.getSize()!=0){
try {
T x = stack.pop();
temp.push(x);
if(x.equals(value)){
temp.pop();
res= true;
}
} catch (Exception ex) {
System.out.println(ex.getMessage());
}
}
while(temp.getSize()!=0){
try {
stack.push(temp.pop());
} catch (Exception ex) {
System.out.println(ex.getMessage());
}
}
return res;

}

@Override
public T removeAny() throws Exception {
if(stack.getSize()==0){
throw new Exception ("Set is empty");
}else{
return stack.pop();
}
}

@Override
public int getSize() {
return stack.getSize();
}

@Override
public void clear() {
stack.clear();
}

public String toString(){
return stack.toString();
}}

