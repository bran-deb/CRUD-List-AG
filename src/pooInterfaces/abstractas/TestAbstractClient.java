package pooInterfaces.abstractas;
//5
import pooInterfaces.abstractas.lista.ClienteList;
import pooInterfaces.modelo.Cliente;
import pooInterfaces.repository.CrudMergeRepository;

import java.util.List;

import static pooInterfaces.repository.Direccion.ASC;
import static pooInterfaces.repository.Direccion.DESC;

public class TestAbstractClient {
    public static void main(String[] args) {

        CrudMergeRepository<Cliente> repo = new ClienteList();
        repo.create(new Cliente("Jano", "Perez"));
        repo.create(new Cliente("Bea", "Gonzales"));
        repo.create(new Cliente("Luci", "Martinez"));
        repo.create(new Cliente("Andres", "Guzman"));
        List<Cliente> clientes = repo.listar();
//        clientes.forEach(cliente-> System.out.println(cliente));
        clientes.forEach(System.out::println);

        System.out.println("=======  paginable   =======");
        //cast de (CrudRepository)a(PageableRepository)
//        List<Cliente> paginable = ((PageableRepository)repo).listar(2,4);
        List<Cliente> paginable = repo.listar(2, 4);
        paginable.forEach(System.out::println);

        System.out.println("======  Ordenar asc  ========");
//        List<Cliente> clientesOrdenAsc = ((OrderRepository)repo).listar("nombre", ASC);
        List<Cliente> clientesOrdenAsc = repo.listar("nombre", ASC);
        clientesOrdenAsc.forEach(System.out::println);

        System.out.println("======= Ordenar desc ========");
//        List<Cliente> clienteListDesc = ((OrderRepository)repo).listar("nombre", DESC);
        List<Cliente> clienteListDesc = repo.listar("nombre", DESC);
        clienteListDesc.forEach(System.out::println);

        System.out.println("=======   Editable   ========");
        Cliente beaActualizar = new Cliente("Bea", "Mena");
        beaActualizar.setId(2);
        repo.update(beaActualizar);
        clientes.forEach(System.out::println);

        System.out.println("=======    Delete    ========");
        repo.delete(2);
        repo.listar().forEach(System.out::println);

        System.out.println("=======    Total     ========");
        System.out.println("Total registro" + repo.count());
    }
}
