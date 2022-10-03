package pooInterfaces.abstractas.lista;


import pooInterfaces.abstractas.GenericListDAO;
import pooInterfaces.modelo.Cliente;
import pooInterfaces.repository.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ClienteList extends GenericListDAO<Cliente> {

    public static int ordenar(String campo, Cliente a, Cliente b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }

    public List<Cliente> listar(String campo, Direccion direccion) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
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

    public void update(Cliente cliente) {
        Cliente client = this.getByID(cliente.getId());
        client.setNombre(cliente.getNombre());
        client.setApellido(cliente.getApellido());
    }
}
