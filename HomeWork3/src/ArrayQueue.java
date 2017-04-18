/**
 * Created by Vanya on 28.02.2017.
 */
public class ArrayQueue {
    //enqueue – добавить элемент в очередь;
    //element – первый элемент в очереди;
    //dequeue – удалить и вернуть первый элемент в очереди;
    //size – текущий размер очереди;
    //isEmpty – является ли очередь пустой;
    //clear – удалить все элементы из очереди.

    private int begin = 0, end = 0, size = 0;

    private Object[] array = new Object[10];

    //I: end >= begin && size <= array.length  

    //pre: element != null
    //post: e[size] = element && for (i = 1..size) e'[i] = e[i]
    public void enqueue(Object element) {
        // element != null;

        ensureCapacity();
        size++;
        array[end++] = element;
        end %= array.length;
    }

    private void ensureCapacity() {
        if (size < array.length) {
            return;
        }
        Object[] newArray = new Object[size * 2];
        int howMuch = (begin + size) % array.length;
        System.arraycopy(array, begin, newArray, 0, size - howMuch);
        System.arraycopy(array, 0, newArray, size - howMuch, howMuch);
        //for (int i = 0, cur = begin; i < size; i++, cur++) {
        //   cur %= size;
        //    newArray[i] = array[cur];
        //}
        array = newArray;
        begin = 0;
        end = size;
    }

    //pre: true
    //post: R = e[1], for i = (0..size) e'[i] = e[i] && size' = size
    public Object element() {
        return array[begin];
    }


    //pre: size > 0
    //post: size' = size - 1 && R = e[1] && for i = (1..size') e'[1] = e[i + 1] 
    public Object dequeue() {
        // size != 0;

        Object ret = array[begin];
        array[begin] = null;
        size--;
        begin++;
        begin %= array.length;
        return ret;
    }


    //pre: true
    //post: R = size && size' = size && for i = (0..size) e'[i] = e[i]
    public int size() {
        return size;
    }


    //pre: true
    //post: R = size == 0 && for i = (1..size) e'[i] = e[i]
    public boolean isEmpty() {
        return size == 0;
    }

    //pre: true
    //post: e = empty sequence && size = 0
    public void clear() {
        Object[] newArray = new Object[10];
        array = newArray;
        begin = 0;
        end = 0;
        size = 0;
    }

    //pre: element != null
    //pref: for i = (1..size) e'[i + 1] = e[i] && size' = size + 1 && e[1] = element
    public void push(Object element) {
        assert element != null;

        ensureCapacity();

        begin--;
        if (begin == -1){
            begin = array.length - 1;
        }
        array[begin] = element;
        size++;
    }

    //pre:true
    //post: R = e[size] && e' = e
    public Object peek() {
        int pos = end - 1;
        if (pos == -1){
            pos = array.length - 1;
        }
        return array[pos];
    }

    //pre: size > 0
    //post: size' = size - 1 && for i = (1..size') e'[i] = e[i]
    public Object remove() {
        end--;
        if (end == -1){
            end = array.length - 1;
        }
        Object ret = array[end];
        array[end] = null;
        size--;
        return ret;
    }
}
