package pooInterfaces.abstractas.lista;

import pooInterfaces.abstractas.GenericListDAO;
import pooInterfaces.exceptions.checked.ReadDataAccessException;
import pooInterfaces.modelo.Producto;
import pooInterfaces.repository.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ProductList extends GenericListDAO<Producto> {

    @Override
    public void update(Producto producto) throws ReadDataAccessException {
        Producto product = getByID(producto.getId());
        product.setDescripcion(producto.getDescripcion());
        product.setPrecio(producto.getPrecio());
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

    public static int ordenar(String campo, Producto a, Producto b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "descripcion" -> resultado = a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" -> resultado = a.getPrecio().compareTo(b.getPrecio());
        }
        return resultado;
    }
}
