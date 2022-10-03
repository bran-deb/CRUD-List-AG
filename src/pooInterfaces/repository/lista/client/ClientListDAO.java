package pooInterfaces.repository.lista.client;
//3

import pooInterfaces.modelo.Cliente;
import pooInterfaces.repository.CrudMergeRepository;
import pooInterfaces.repository.Direccion;

import java.util.List;

public interface ClientListDAO extends CrudMergeRepository<Cliente> {

    List<Cliente> listar();

    List<Cliente> listar(int desde, int hasta);

    List<Cliente> listar(String campo, Direccion direccion);

    Cliente getByID(Integer id);

    void create(Cliente cliente);

    void update(Cliente cliente);

    void delete(Integer id);

    int count();
}


