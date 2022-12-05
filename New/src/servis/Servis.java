package servis;

import java.util.List;

public interface Servis<T> {
    T findItem(int id);
    List<T> printAll();
    double sold(int id ,int kolvo);
    T update(int id);
    public void add(T target);
    public void delit(T target);
}
