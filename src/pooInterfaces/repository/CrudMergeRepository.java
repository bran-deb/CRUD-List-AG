package pooInterfaces.repository;
//2
public interface CrudMergeRepository<T>
        extends CrudRepository<T>,
        PageableRepository<T>,
        OrderRepository<T>,
        CountableRepository {

}
