package pooInterfaces.repository;

public interface OrderPageableCrudRepository
        extends OrderRepository,
        PageableRepository,
        CrudRepository, CountableRepository {

}
