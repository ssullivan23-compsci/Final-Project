public class MyGenericDS<E> implements GenericOrderedCollection<E>{
    Node <E> end;
    int myCurrentLength=0;
    class Node<T>{
        T elem;
        Node next;
        public Node(T e){
            this.elem = e;
        }
    }
    public void append(E toAppend) {
            Node<E> toAdd = new Node<E>(toAppend);
            toAdd.next = end;
            end = toAdd;
            myCurrentLength+=1;
    }

    public E peek() {
        return end.elem;
    }

    public E pop() {
        E toReturn = end.elem;
        end = end.next;
        return toReturn;
    }

    public void remove(int index) {
        Node <E> n = end;
        Node <E> prev=null;
        int loops =myCurrentLength-index;
        if(loops==0){
            end = end.next;
        }
        for(int i=0;i<(loops);i++){
            if (i==loops-1){
                prev=n;
            }
            n=n.next;
        }
        prev.next=n.next;

    }


    public String toString() {
        String toReturn = "";
        Node n = end;
        if (end!= null){
            toReturn = (n.elem.toString()) + toReturn;
            n=n.next;
        } else{
            return toReturn;
        }
        while (n != null){
            toReturn =   n.elem.toString() + " " + toReturn ;
            n = n.next;
        }
        return toReturn;
    }

    public int length() {
        return myCurrentLength;
    }
    public static void main(String[] args){
        MyGenericDS ds = new MyGenericDS<String>();
        ds.append("Zero");
        ds.append("One");
        ds.append("Two");
        ds.append("Three");
        ds.append("Three");
        ds.remove(1);
        System.out.println(ds);
        System.out.println("hello");
    }
}
