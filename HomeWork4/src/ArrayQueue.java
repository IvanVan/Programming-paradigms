/**
 * Created by Vanya on 03.03.2017.
 */
public class ArrayQueue extends AbstractQueue implements Queue {
    //enqueue – добавить элемент в очередь;
    //element – первый элемент в очереди;
    //dequeue – удалить и вернуть первый элемент в очереди;
    //size – текущий размер очереди;
    //isEmpty – является ли очередь пустой;
    //clear – удалить все элементы из очереди.

    private int begin = 0, end = 0;

    private Object[] array = new Object[10];

    protected ArrayQueue makeCopy() {
        return new ArrayQueue();
    }

    protected void add(Object element) {
        ensureCapacity();
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

    protected Object getFirst() {
        return array[begin];
    }

    protected void doDeque() {
        array[begin] = null;
        begin++;
        begin %= array.length;
    }

    protected void doClear() {
        array = new Object[10];
        begin = 0;
        end = 0;
    }
}
