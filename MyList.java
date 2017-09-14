/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.chainedlist;

/**
 *
 * @author DianaAlessa
 */
public class MyList <T> {
    Node first;
    Node last;
    Node pointer;
    
    //Constructor
    MyList(){
        first = null;
        last = null;
        pointer = null;
    }
    
    MyList(int d){
        Node node = new Node(d);
        first = node;
        last = node;  
        node.next = null;
    }
    
    //Metodos para realizar 
    public boolean isEmpty(){ //Que pasa si esta vacío
       return first==null;
        /*if(first==null && last==null){
            return true;
        }
        else return false;*/
    }
    
    public void insertFirst(int d){ //Insertar el inicio de la lista
        Node node = new Node(d);
        if (isEmpty()){ //If is true
           // MyList.this.equals(d);
        first=node;
        last=node;  
        node.next=null;
        } else { //Caso: lista con elementos
            node.next=first;
            first=node;
        }
    }
    
    public void insertLast(T n){  //Insertar el final de la lista
        Node node = new Node (n);
        if (isEmpty()){ //Caso: lista vacía
            first=node;
            last=node;
            node.next=null;
        } else { //Caso: lista con elemento
            last.next=node; //
            last=node;
        }
    }
   
    public void deleteFirst(){  //Eliminar al inicio 
        if(!isEmpty()){
            if(first.next==null){//Si la lista solamente tiene un elemento
                first=null;
                last=null;
            } else { //Si la lista tiene más de un elemento
                first=first.next;
            }
        }
    }
    
    public void deleteLast(){//Eliminar al final
        if(!isEmpty()){
            if(first==last){//Si la lista solamente tiene un elemento
               first=last=null;
            }
        }else{ //Buscamos dentro del arreglo 
            pointer = first;//colocar apuntador en el primer sitio para que empiece a recorrer
                while(pointer.next!=last){ //Recorre la lista y se detiene en el elemento anterior al final
                    pointer=pointer.next;
                }
                last=pointer;
                last.next=null;
                pointer=null;
                
            }
    }
    
    public boolean deleteNode(T n){ //Eliminar nodo
        Node p = fetchBack(n);
        if(p!=null){
              if (p.data==n){//Si fue el primer o el único elemento de la lista
                deleteFirst();
             }else { //Si está dentro de la lista
                p.next=p.next.next;
            }
              return true;
        }
        return false;
    }
    
    public Node fetch (T n){
        //Si no está vacía la lista
        if(!isEmpty()){
            if(first.data==n)return first; //Si n es el primero
            Node p = fetchBack(n); //Se regresa el primero
            if(p!=null){ //Si no es nulo
                if(p.data!=n){ //Si p es diferente a n
                    return p.next; //Se regresa el siguiente a n
                }
            }
        }
        return null;
    }
    
    public Node fetchBack (T n){
        pointer = first;
        if(!isEmpty()){
               if(first==last){//Si la lista solo tiene un elemento
                   if(first.data==n){//Si es el elemento que busco
                       return first;//Se devuelve a si mismo
                   } else return null;
               }else { //Si hay más elementos en la lista                   
                  if(first.data==n){//Si el elemento que busco es el primero
                  return first;
                  }else{
                      pointer = first;
                        while(pointer.next!=null){ //Recorre la lista y se detiene en el elemento anterior al final
                             if(pointer.data==n){
                                 return pointer;                           
                            }
                             pointer = pointer.next;
                        }
                   }
               }
        }
           return null;
    }
    
    
}