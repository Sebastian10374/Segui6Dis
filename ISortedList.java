   
public interface ISortedList<T extends Comparable<T>> {
    public void insert(T elem);
    public boolean delete(T elem);
    public boolean search(T elem);
    public boolean isEmpty();
    public int size();
    public String toString();
}
