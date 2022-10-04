package pooInterfaces.abstractas;

import pooInterfaces.repository.CountableRepository;
import pooInterfaces.abstractas.CrudRepository;
import pooInterfaces.repository.OrderRepository;
import pooInterfaces.repository.PageableRepository;

//2
public interface CrudMergeRepository<T>
        extends CrudRepository<T>,
        PageableRepository<T>,
        OrderRepository<T>,
        CountableRepository {

}
