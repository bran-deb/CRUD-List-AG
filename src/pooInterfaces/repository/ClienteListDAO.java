package pooInterfaces.repository;

public interface ClienteListDAO
        extends OrderRepository,
        PageableRepository,
        CrudRepository, CountableRepository {

}
