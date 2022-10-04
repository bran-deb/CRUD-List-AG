package pooInterfaces;
//5

import pooInterfaces.exceptions.unchecked.DataAccessException;
import pooInterfaces.modelo.Producto;
import pooInterfaces.repository.CrudMergeRepository;
import pooInterfaces.repository.lista.product.ProductListDAOImp;

import java.util.List;

import static pooInterfaces.repository.Direccion.ASC;
import static pooInterfaces.repository.Direccion.DESC;

public class TestRepositoryProduct {
    public static void main(String[] args) {

        try {
            CrudMergeRepository<Producto> repo = new ProductListDAOImp();
            repo.create(new Producto("mesa", 50.2));
            repo.create(new Producto("silla", 10));
            repo.create(new Producto("lampara", 15.5));
            repo.create(new Producto("notebook", 20));
            List<Producto> productos = repo.listar();
            productos.forEach(System.out::println);

            System.out.println("=======  paginable   =======");
            //cast de (CrudRepository)a(PageableRepository)
            List<Producto> paginable = repo.listar(2, 4);
            paginable.forEach(System.out::println);

            System.out.println("======  Ordenar asc  ========");
            List<Producto> productosOrdenAsc = repo.listar("nombre", ASC);
            productosOrdenAsc.forEach(System.out::println);

            System.out.println("======= Ordenar desc ========");
            List<Producto> productoListDesc = repo.listar("descripcion", DESC);
            productoListDesc.forEach(System.out::println);

            System.out.println("=======   Editable   ========");
            Producto lamparaActualizar = new Producto("lampara escritorio", 25);
            lamparaActualizar.setId(3);
            repo.update(lamparaActualizar);
            productos.forEach(System.out::println);

            System.out.println("=======    Delete    ========");
            repo.delete(2);
            repo.listar().forEach(System.out::println);

            System.out.println("=======    Total     ========");
            System.out.println("Total registro " + repo.count());

            repo.create(null);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
