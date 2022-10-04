package pooInterfaces.abstractas;
//1

import pooInterfaces.exceptions.checked.DataAccessException;

import java.util.List;

//protocolos (métodos de la interfase)
public interface CrudRepository<T> {

    List<T> listar();

    T getByID(Integer id) throws DataAccessException;

    void create(T t) throws DataAccessException;

    void update(T t) throws DataAccessException;

    void delete(Integer id) throws DataAccessException;
}
