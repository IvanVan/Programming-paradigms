import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Vanya on 03.03.2017.
 */
public abstract class AbstractQueue implements Queue {
    protected int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    protected abstract void add(Object element);

    protected abstract Queue makeCopy();

    public void enqueue(Object element) {
        assert element != null;

        add(element);
        size++;
    }

    protected abstract void doClear();

    public void clear() {
        size = 0;
        doClear();
    }

    protected abstract Object getFirst();

    public Object element() {
        return getFirst();
    }

    protected abstract void doDeque();

    public Object dequeue() {
        assert size > 0;

        Object ret = getFirst();
        size--;
        doDeque();
        return ret;
    }

    public Queue filter(Predicate<Object> predicate){
        int last = size;
        Queue retQueue = this.makeCopy();
        for (int i = 0; i < last; i++) {
            Object nowElement = this.dequeue();
            if (predicate.test(nowElement)){
                retQueue.enqueue(nowElement);
            }
            this.enqueue(nowElement);
        }
        return retQueue;
    }

    public Queue map(Function<Object, Object> function){
        int last = size;
        Queue retQueue = this.makeCopy();
        for (int i = 0; i < last; i++) {
            Object curObject = this.dequeue();
            Object applyFun = function.apply(curObject);
            retQueue.enqueue(applyFun);
            this.enqueue(curObject);
        }
        return retQueue;
    }
}
