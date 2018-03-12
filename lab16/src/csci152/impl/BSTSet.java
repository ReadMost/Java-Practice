/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Set;

/**
 *
 * @author Rauan Amangeldiyev
 * @param <T>
 */
public class BSTSet<T extends Comparable> implements Set{
    
    private TreeNode<T> root;
    private int size;
    
    public BSTSet(){
        root = null;
        size = 0;
    }
    
    @Override
    public void add(Object value) {
        TreeNode<T> temp = new TreeNode(value);
        if(size == 0){
         root = temp;
         size++;
        }else {
         TreeNode<T> temp1 = compareS(root, (T) value);
            if(temp1 != null){
                if(temp1.getValue().compareTo((T)value)<0){
                    temp1.setRight(temp);
                }else temp1.setLeft(temp);
                size++;
            }
            
        }
        
    }
    
    private TreeNode compareS(TreeNode<T> t, T value){
        TreeNode<T> temp;
        if(value.compareTo(t.getValue())<0 && t.getLeft()!=null){
            temp = compareS(t.getLeft(), value);
        }else if(value.compareTo(t.getValue())>0 && t.getRight()!=null){
            temp = compareS(t.getRight(), value);
        }else if(value.equals(t.getValue())) return null;
        else return t;
        return temp;
    }
    @Override
    public boolean contains(Object value) {
    TreeNode<T> temp1 = compareS(root, (T) value);
        return temp1 == null;
    }

    @Override
    public boolean remove(Object value) {
     
    if(contains(value)){
        TreeNode parent = removeHelper1(root,(T) value);
        TreeNode current=null;
        boolean check = false;
        if(value.equals(parent.getRight().getValue())){ 
            current = parent.getRight();
            check = false;
        }
        else if(value.equals(parent.getLeft().getValue())){
            current = parent.getLeft();
            check = true;
        }
        
        if(current.getLeft()== null && current.getRight()==null){
            if(check)  parent.setLeft(null);
            else parent.setRight(null);
           
            
        }else if(current.getLeft()!= null && current.getRight()!=null){
            TreeNode last = removeLast(current.getRight());
            TreeNode parentOfLast = removeHelper1(current.getRight(), (T) last.getValue());
            if(last.getRight()!=null){
                parentOfLast.setLeft(last.getRight());
            }else parentOfLast.setLeft(null);
            
            last.setLeft(current.getLeft());
            last.setRight(current.getRight());
            if(check) parent.setLeft(last);
            else parent.setRight(last);
        } else if(current.getLeft()!= null && current.getRight()==null){
             if(check) parent.setLeft(current.getLeft());
            else parent.setRight(current.getLeft());
        }else if(current.getLeft()== null && current.getRight()!=null){
             if(check) parent.setLeft(current.getRight());
            else parent.setRight(current.getRight());
        }
         size--;
   return true;
    }
    else return false;
    }
    
     private TreeNode removeLast(TreeNode<T> t){
        TreeNode<T> temp = null;
        if(t.getLeft()!=null){
            temp = removeLast(t.getLeft());
        }
        else if(t.getLeft()==null) return t;
        
        return temp;
    }
    
    private TreeNode removeHelper(TreeNode<T> t, T value){
        TreeNode<T> temp = null;
        if(value.compareTo(t.getValue())<0 && t.getLeft()!=null){
            temp = removeHelper(t.getLeft(), value);
        }else if(value.compareTo(t.getValue())>0 && t.getRight()!=null){
            temp = removeHelper(t.getRight(), value);
        }else if(value.equals(t.getValue())) return t;
        
        return temp;
    }
    private TreeNode removeHelper1(TreeNode<T> t, T value){
        TreeNode<T> temp = t;
        
        if(value.compareTo(t.getValue())<0 && t.getLeft()!=null && !value.equals(t.getLeft().getValue())){
            temp = removeHelper1(t.getLeft(), value);
        }else if(value.compareTo(t.getValue())>0 && t.getRight()!=null && !value.equals(t.getRight().getValue())){
            temp = removeHelper1(t.getRight(), value);
        }else if(value.equals(t.getRight().getValue()) || value.equals(t.getLeft().getValue())) temp = t;
       
        return temp;
    }
    
    @Override
    public Object removeAny() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSize() {
      return size;
    }

    @Override
    public void clear() {
    root = null;
    size = 0;
    }
    
    @Override
    public String toString(){
       return toStringHelper(root);
    }
    
    private String toStringHelper(TreeNode<T> t){
        if(t == null){
            return " ";
        }
        return toStringHelper(t.getLeft()) + 
                t.getValue() + 
                toStringHelper(t.getRight());
    }
}
