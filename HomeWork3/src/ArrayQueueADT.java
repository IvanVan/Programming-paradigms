/**
 * Created by Vanya on 28.02.2017.
 */
public class ArrayQueueADT {
    private int begin = 0, end = 0, size = 0;

    private Object array[] = new Object[10];

    //enqueue – добавить элемент в очередь;
    //element – первый элемент в очереди;
    //dequeue – удалить и вернуть первый элемент в очереди;
    //size – текущий размер очереди;
    //isEmpty – является ли очередь пустой;
    //clear – удалить все элементы из очереди.

    public static void enqueue(ArrayQueueADT queue, Object element) {
        assert element != null;

        ensureCapacity(queue);
        queue.size++;
        queue.array[queue.end++] = element;
        queue.end %= queue.array.length;
    }

    private static void ensureCapacity(ArrayQueueADT queue) {
        if (queue.size < queue.array.length) {
            return;
        }
        int newLength = queue.array.length;
        Object[] newArray = new Object[newLength * 2];
        int howMuch = (queue.begin + queue.size) % queue.array.length;
        System.arraycopy(queue.array, queue.begin, newArray, 0, queue.size - howMuch);
        System.arraycopy(queue.array, 0, newArray, queue.size - howMuch, howMuch);
        //for (int i = 0, currentIndex = queue.begin; i < newLength; i++, currentIndex++) {
        //    currentIndex %= queue.array.length;
        //    newArray[i] = queue.array[currentIndex];
        //}
        queue.array = newArray;
        queue.begin = 0;
        queue.end = newLength;
    }

    public static void clear(ArrayQueueADT queue) {
        Object[] newArray = new Object[10];
        queue.array = newArray;
        queue.begin = 0;
        queue.end = 0;
        queue.size = 0;
    }

    public static Object element(ArrayQueueADT queue) {
        assert queue.size > 0;

        return queue.array[queue.begin];
    }

    public static Object dequeue(ArrayQueueADT queue) {
        assert queue.size > 0;

        queue.size--;
        Object ret = queue.array[queue.begin];
        queue.array[queue.begin] = null;
        queue.begin++;
        queue.begin %= queue.array.length;
        return ret;
    }

    public static int size(ArrayQueueADT queue) {
        return queue.size;
    }

    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }

    public static void push(ArrayQueueADT queue, Object element) {
        assert element != null;

        ensureCapacity(queue);

        queue.begin--;
        if (queue.begin == -1){
            queue.begin = queue.array.length - 1;
        }
        queue.array[queue.begin] = element;
        queue.size++;
    }

    public static Object peek(ArrayQueueADT queue) {
        int pos = queue.end - 1;
        if (pos == -1){
            pos = queue.array.length - 1;
        }
        return queue.array[pos];
    }

    public static Object remove(ArrayQueueADT queue) {
        queue.end--;
        if (queue.end == -1){
            queue.end = queue.array.length - 1;
        }
        Object ret = queue.array[queue.end];
        queue.array[queue.end] = null;
        queue.size--;
        return ret;
    }
}
