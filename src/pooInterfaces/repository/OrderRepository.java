package pooInterfaces.repository;

import pooInterfaces.modelo.Cliente;

import java.util.List;

public interface OrderRepository {

    List<Cliente> listar(String campo,Direccion direccion);
}
