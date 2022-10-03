package pooInterfaces.repository.lista.product;

import pooInterfaces.modelo.Producto;
import pooInterfaces.repository.CrudMergeRepository;
import pooInterfaces.repository.Direccion;

import java.util.List;

public interface ProductListDAO extends CrudMergeRepository<Producto> {

    List<Producto> listar();

    List<Producto> listar(int desde, int hasta);

    List<Producto> listar(String campo, Direccion direccion);

    Producto getByID(Integer id);

    void create(Producto producto);

    void update(Producto producto);

    void delete(Integer id);

    int count();
}
