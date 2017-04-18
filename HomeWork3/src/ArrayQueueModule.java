/**
 * Created by Vanya on 25.02.2017.
 */
public class ArrayQueueModule {
    private static int size = 0, begin = 0, end = 0;

    private static Object[] array = new Object[10];

    public static int size() {
        return size;
    }


    public static void enqueue (Object element) {
        assert element != null;

        ensureCapacity();
        size++;
        array[end++] = element;
        end %= array.length;
    }

    private static void ensureCapacity() {
        if (size < array.length) {
            return;
        }
        Object[] newArray = new Object[array.length * 2];
        int howMuch = (begin + size) % array.length;
        System.arraycopy(array, begin, newArray, 0, size - howMuch);
        System.arraycopy(array, 0, newArray, size - howMuch, howMuch);
        //for (int i = 0, currentIdex = begin; i < array.length; i++, currentIdex++) {
        //    currentIdex %= array.length;
        //    newArray[i] = array[currentIdex];
        //}
        begin = 0;
        end = array.length;
        array = newArray;
    }

    public static Object element() {
        //assert size != 0;

        return array[begin];
    }

    public static Object dequeue() {
        //assert size != 0;

        size--;
        Object ret = array[begin];
        array[begin] = null;
        begin++;
        begin %= array.length;
        return ret;
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public static void clear() {
        array = new Object[10];
        begin = 0;
        end = 0;
        size = 0;
    }

    public static void push(Object element) {
        assert element != null;

        ensureCapacity();

        begin--;
        if (begin == -1){
            begin = array.length - 1;
        }
        array[begin] = element;
        size++;
    }

    public static Object peek() {
        int pos = end - 1;
        if (pos == -1){
            pos = array.length - 1;
        }
        return array[pos];
    }

    public static Object remove() {
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
