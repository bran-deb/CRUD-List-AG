package pooInterfaces.repository;

import pooInterfaces.modelo.Cliente;

import java.util.List;

public interface PageableRepository {

    List<Cliente> listar(int desde,int hasta);
}
