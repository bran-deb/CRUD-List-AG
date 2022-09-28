package pooInterfaces.repository;

import pooInterfaces.modelo.Cliente;

import java.util.List;

//protocolos (métodos de la interfase)
public interface CrudRepository {

    List<Cliente> listar();

    Cliente getClientByID(Integer id);

    void create(Cliente cliente);

    void update(Cliente cliente);

    void delete(Integer id);
}
