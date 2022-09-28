package pooInterfaces;

import pooInterfaces.modelo.Cliente;
import pooInterfaces.repository.*;

import static pooInterfaces.repository.Direccion.DESC;
import static pooInterfaces.repository.Direccion.ASC;

import java.util.List;

public class TestRepository {
    public static void main(String[] args) {

        OrderPageableCrudRepository repo = new ClienteListRepository();
        repo.create(new Cliente("Jano", "Perez"));
        repo.create(new Cliente("Bea","Gonzales"));
        repo.create(new Cliente("Luci","Martinez"));
        repo.create(new Cliente("Andres","Guzman"));
        List<Cliente> clientes = repo.listar();
//        clientes.forEach(cliente-> System.out.println(cliente));
        clientes.forEach(System.out::println);

        System.out.println("=======  paginable   =======");
        //cast de (CrudRepository)a(PageableRepository)
        List<Cliente> paginable = ((PageableRepository)repo).listar(2,4);
        paginable.forEach(System.out::println);

        System.out.println("======  Ordenar asc  ========");
        List<Cliente> clientesOrdenAsc = ((OrderRepository)repo).listar("nombre", ASC);
        clientes.forEach(System.out::println);

        System.out.println("======= Ordenar desc ========");
        List<Cliente> clienteListDesc = ((OrderRepository)repo).listar("nombre", DESC);
        clienteListDesc.forEach(System.out::println);

        System.out.println("=======   Editable   ========");
        Cliente beaActualizar = new Cliente("Bea","Mena");
        beaActualizar.setId(2);
        repo.update(beaActualizar);
        clientes.forEach(System.out::println);

        System.out.println("=======    Delete    ========");
        repo.delete(2);
        repo.listar().forEach(System.out::println);

        System.out.println("=======    Total     ========");
        System.out.println("Total registro"+repo.count());

    }
}
