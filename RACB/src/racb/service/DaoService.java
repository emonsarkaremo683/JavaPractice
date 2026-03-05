
package racb.service;

import java.util.List;

/**
 *
 * @author Admin
 * @param <E>
 */
public interface DaoService <E> {
    void saveData(E e);
    void updateData(E e);
    List<E> showAllData();
    void delete(int id);
    E findDataById(int id);
    String findNameById(int id);
    int findIdByName(String name);
    
}
