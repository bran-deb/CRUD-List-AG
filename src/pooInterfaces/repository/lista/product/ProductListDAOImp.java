package pooInterfaces.repository.lista.product;

import pooInterfaces.exceptions.unchecked.ReadDataAccessException;
import pooInterfaces.exceptions.unchecked.WriteDataAccessException;
import pooInterfaces.modelo.Producto;
import pooInterfaces.repository.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ProductListDAOImp implements ProductListDAO {

    private final List<Producto> dataSource;

    public ProductListDAOImp() {
        this.dataSource = new ArrayList<>();
    }

    public static int ordenar(String campo, Producto a, Producto b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "descripcion" -> resultado = a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" -> resultado = a.getPrecio().compareTo(b.getPrecio());
        }
        return resultado;
    }

    @Override
    public List<Producto> listar() {
        return dataSource;
    }

    @Override
    public List<Producto> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public List<Producto> listar(String campo, Direccion direccion) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if (direccion == Direccion.ASC) {
                resultado = ordenar(campo, a, b);
            } else if (direccion == Direccion.DESC) {
                resultado = ordenar(campo, b, a);
            }
            return resultado;
        });
        return listaOrdenada;
    }

    @Override
    public Producto getByID(Integer id) {
        if (id == null) {
            throw new ReadDataAccessException("Id invalido debe ser: <0");
        }
        Producto productById = null;
        for (Producto producto : dataSource) {
            if (producto.getId() != null && producto.getId().equals(id)) {
                productById = producto;
                break;
            }
        }
        if (productById == null) {
            throw new ReadDataAccessException("No existe el producto con id: " + id);
        }
        return productById;
    }

    @Override
    public void create(Producto producto) {
        if (producto == null) {
            throw new WriteDataAccessException("Error al insertar un producto");
        }
        this.dataSource.add(producto);
    }

    @Override
    public void update(Producto producto) {
        Producto product = this.getByID(producto.getId());
        product.setDescripcion(producto.getDescripcion());
        product.setPrecio(producto.getPrecio());
    }

    @Override
    public void delete(Integer id) {
        Producto product = this.getByID(id);
        this.dataSource.remove(product);
    }

    @Override
    public int count() {
        return this.dataSource.size();
    }
}
