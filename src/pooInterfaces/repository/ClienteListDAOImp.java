package pooInterfaces.repository;

import pooInterfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteListDAOImp implements ClienteListDAO {

    private final List<Cliente> dataSource;

    public ClienteListDAOImp() {
        this.dataSource = new ArrayList<>();
    }

    public static int ordenar(String campo, Cliente a, Cliente b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }

    @Override
    public List<Cliente> listar() {
        return dataSource;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
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

    @Override
    public Cliente getClientByID(Integer id) {
        Cliente clientById = null;
        for (Cliente cliente : dataSource) {
            if (cliente.getId() != null && cliente.getId().equals(id)) {
                clientById = cliente;
                break;
            }
        }
        return clientById;
    }

    @Override
    public void create(Cliente cliente) {
        this.dataSource.add(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        Cliente client = this.getClientByID(cliente.getId());
        client.setNombre(cliente.getNombre());
        client.setApellido(cliente.getApellido());
    }

    @Override
    public void delete(Integer id) {
        Cliente client = this.getClientByID(id);
        this.dataSource.remove(client);
    }

    @Override
    public int count() {
        return this.dataSource.size();
    }
}
