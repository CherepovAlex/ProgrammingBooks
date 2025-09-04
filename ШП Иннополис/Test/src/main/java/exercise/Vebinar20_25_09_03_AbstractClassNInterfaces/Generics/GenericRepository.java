package exercise.Vebinar20_25_09_03_AbstractClassNInterfaces.Generics;

import java.util.List;

public interface GenericRepository<T> {

    // набор методов для работы с базой данных

    T getById(Integer id); // select * from table where id = ?id

    List<T> getAll();    // select * from table

    T create(T newRow); // insert into table(....) values()

    T update(T update, Integer id); // update table set .... where id = ?id

    void delete(T entity);  // delete from table where entity_id = entity.getId()

}
