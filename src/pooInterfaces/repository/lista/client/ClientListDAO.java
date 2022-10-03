package pooInterfaces.repository.lista.client;
//3

import pooInterfaces.modelo.Cliente;
import pooInterfaces.repository.CrudMergeRepository;
import pooInterfaces.repository.Direccion;

import java.util.List;

public interface ClientListDAO extends CrudMergeRepository<Cliente> {

    public List<Cliente> listar();

    public List<Cliente> listar(int desde, int hasta);

    public List<Cliente> listar(String campo, Direccion direccion);

    public Cliente getByID(Integer id);

    public void create(Cliente cliente);

    public void update(Cliente cliente);

    public void delete(Integer id);

    public int count();
}


