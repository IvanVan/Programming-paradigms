/**
 * Created by Vanya on 03.03.2017.
 */
public class LinkedQueue extends AbstractQueue implements Queue {

    private Node begin;
    private Node end;

    @Override
    protected void add(Object element) {
        if (size == 0) {
            begin = new Node(element);
            end = begin;
        } else {
            Node newEnd = new Node(element);
            end.next = newEnd;
            end = newEnd;
        }
    }

    protected Object getFirst() {
        return begin.value;
    }

    @Override
    protected void doDeque() {
        begin = begin.next;
        if (size == 1) {
            end = null;
        }
    }

    @Override
    public void doClear() {
        begin = null;
        end = null;
    }

    protected LinkedQueue makeCopy() {
        return new LinkedQueue();
    }
}
