package pooInterfaces.repository;

import pooInterfaces.modelo.Cliente;

import java.util.List;

public interface PageableRepository<T> {

    List<T> listar(int desde,int hasta);
}
