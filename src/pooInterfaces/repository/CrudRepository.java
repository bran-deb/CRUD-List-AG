package pooInterfaces.repository;
//1

import java.util.List;

//protocolos (métodos de la interfase)
public interface CrudRepository<T> {

    List<T> listar();

    T getByID(Integer id) ;

    void create(T t) ;

    void update(T t) ;

    void delete(Integer id) ;
}
