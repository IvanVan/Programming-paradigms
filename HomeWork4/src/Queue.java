import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Vanya on 03.03.2017.
 */
public interface Queue {
    //enqueue – добавить элемент в очередь;
    //element – первый элемент в очереди;
    //dequeue – удалить и вернуть первый элемент в очереди;
    //size – текущий размер очереди;
    //isEmpty – является ли очередь пустой;
    //clear – удалить все элементы из очереди.

	//I: size >= 0 && for i = 1..size e[i] != null

    //pre: element != null
    //post: e[size + 1] = element && for i = 1..size e'[i] = e[i] && size' = size + 1
    void enqueue(Object element);

    //pre: size > 0
    //post: R = e[1], for i = 1..size e'[i] = e[i] && size' = size
    Object element();

    //pre: size > 0
    //post: size' = size - 1 && R = e[1] && for i = (1..size') e'[i] = e[i + 1]
    Object dequeue();

    //pre: true
    //post: R = size && size' = size && for i = (1..size) e'[i] = e[i]
    int size();

    //pre: true
    //post: R = (size == 0) && for i = 1..size e'[i] = e[i] && size = size'
    boolean isEmpty();

    //pre: true
    //post: e = empty sequence && size = 0
    void clear();

    //pre: predicate != null
    //post: R &&
    //size' = size && 
    //for i = 1..n a'[i] = a[i]
    //good = 0 for i = 1..n if (predicate(a[i])) good += 1 &&
    //m = R.size = good &&
    //t - sequence && t.size == m && for i = 1..m-1 (t[i] < t[i + 1] && t[i + 1] <= n && t[i] > 0) && 
    //for i = 1..m perdicate(a[t[i])) == true &&
    //for i = 1..m R[i] = a[t[i]] &&
    Queue filter(Predicate<Object> predicat);

    //pre: for i = 1..size function(e[i]) != null
    //post: R && for i = 1..size R[i] = function(e[i]) && R.ssize == size && size' = size && for i = 1..size e'[i] = e[i]
    Queue map(Function<Object, Object> function);
}
