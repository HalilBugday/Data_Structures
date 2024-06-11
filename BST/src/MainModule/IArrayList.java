package MainModule;

public interface IArrayList<T> {
   public void add(T item);
   public T get(int index);
   public int getCurrentSize();
   public boolean isEmpty();
}