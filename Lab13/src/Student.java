/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rauan Amangeldiyev
 */
public class Student implements Comparable<Student>{
    private int id;
    private String name;
    public Student(String n, int i){
        name = n;
        id = i;
    }
    public void setID(int i){
        id = i;
    }
    public int getID(){
        return id;
    }
     public void setName(int i){
        id = i;
    }
    public String getName(){
        return name;
    }
     /* @Override
    public int compareTo(Student t) {
    if(id< t.getID())
        return -1;
    else if(id == t.getID())
        return 0;
    else return 1;
    }*/
    @Override
     public int compareTo(Student t) {
    return name.compareTo(t.getName());
    }
    
     public boolean equals(Object obj){
         if(obj instanceof Student){
             Student sobj = (Student)obj;
             return id == sobj.id && name.equals(sobj.name);
         }
         else return false;
     }
     
    public String toString(){
        return "Name of Student " + name+" id: "+ id;
    }

  
   

  

  
}
