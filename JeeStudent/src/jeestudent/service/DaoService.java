
package jeestudent.service;

import java.util.List;


public interface DaoService<E> {
    
    void save(E e);
    void update(E e);
    List<E> findAll();
    void delete(int id);
    
}
