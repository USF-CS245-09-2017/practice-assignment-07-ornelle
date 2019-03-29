public class LinkedList<T> implements List<T> {
    private class Node <T>{
        Node <T> next;
        Object data;
        Node(T data){
            this.data = data;
            next= null;
        }
        public void setNext(Node n){
            this.next=n;
        }
        public Node<T> getNext(){
            return next;
        }
        public void setData(T n){
            this.data = n;
        }
        public T getData(){
            return  (T) data;
        }
    }
    int size;
    Node<T> head = null;

    public LinkedList (){
        Node<T> head = null;
        int size=0;
    }

    public void add(T item){

        if ( size==0) {
            head = new Node(item);
        }
        else{
            Node<T> current= head;
            while(current.getNext()!= null){
                current= current.getNext();
            }
            Node<T> n =new Node(item);
            current.setNext(n);
        }
        size++;
    }

    public void add(int pos, T item){
        Node<T> newN= new Node(item);
        if (pos == 0)
        {
            newN.setNext(head);
            head= newN;
        }
        Node<T>  curr = head;
        for (int i = 0; i < pos-1 ; i++) { //locate node just before insertion point
            curr.getNext();  //curr now points to the node just before insetion
        }
        //insert new node
        newN.setNext(curr.getNext());
        curr.setNext(newN);
        size++; //update size
    }

    public T get(int pos){
        if(pos> size)
            return null;
        Node<T> current= head;
        for(int i=0; i<pos; i++)
        {
            current= current.getNext();
        }
        return current.getData();
    }

    public T remove(int pos){
        if(pos==0){
            Node <T> curr =head;
            head = head.getNext();
            size--;
            return curr.getData();
        }
        if (pos> size){
            return null;
        }
        Node <T> curr =head;
        for(int i=0; i<pos-1; i++){ //locates node just before one to be deleted
            curr = curr.next; //curr pointing to the ith node
        }
        Node<T> remove = curr.getNext(); //stopping
        curr.setNext(remove.getNext());
        size--;
        return remove.getData();
//        Node<T> prev= this.head, cur = this.head.next;
//        if(size== 0 || cur == null){
//            return null;
//        }
//        while(cur.data!=null && !cur.data.);
    }
    public int size(){
        return size;
    }
}
