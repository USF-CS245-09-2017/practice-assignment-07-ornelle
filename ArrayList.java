
public class ArrayList<T> implements List<T> { //generic type once chosen it'll be that throughout the whole program

    private int length; //also tells where our current index is
    private Object [] vals;

    public ArrayList(){
        length=0;
        vals= new Object [10];
    }

    public void add(T item){
        if(length==vals.length) {
            doubleSize();
        }
        vals[length]=item;
        length++;
    }
    public void add(int pos, T item){
        if(length==vals.length){
            doubleSize();
        }
        for(int i=length;i>pos;i--){
            vals[i]=vals[i-1];
        }
        vals[pos]=item;
        ++length;
    }
    public T get(int pos){
        return (T)vals[pos];
    }

    public T remove(int pos){
        if(pos >length)
            return null;
        T removing= (T) vals[pos];
        for(; pos < length-1; pos++)
        {
            vals[pos]= vals[pos+1]; //shifting by 1 to the left
         }
        length--;

        return removing;
    }

    public int size(){
        return length;
    }

    private void doubleSize(){
        Object [] temp = new Object [vals.length*2];
        for (int i = 0; i < vals.length; i++) {
            temp[i]= vals[i];
        }
        vals=temp;
    }
}
