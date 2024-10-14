
package ma.projet.dao;

import java.util.List;

public interface IDao<T> {
    boolean create(T o);
    List<T> getAll();
     T getById(int n);
    
}
