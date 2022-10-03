package pooInterfaces.repository;

import pooInterfaces.modelo.Cliente;

import java.util.List;

public interface OrderRepository<T> {

    List<T> listar(String campo,Direccion direccion);
}
