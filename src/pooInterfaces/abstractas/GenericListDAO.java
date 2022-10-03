package pooInterfaces.abstractas;


import pooInterfaces.modelo.BaseEntity;
import pooInterfaces.repository.CrudMergeRepository;

import java.util.ArrayList;
import java.util.List;

//
public abstract class GenericListDAO<T extends BaseEntity> implements CrudMergeRepository<T> {

    protected final List<T> dataSource;

    public GenericListDAO() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public T getByID(Integer id) {
        T clientById = null;
        for (T cliente : dataSource) {
            if (cliente.getId() != null && cliente.getId().equals(id)) {
                clientById = cliente;
                break;
            }
        }
        return clientById;
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public void create(T t) {
        this.dataSource.add(t);
    }

    @Override
    public void delete(Integer id) {
        T client = this.getByID(id);
        this.dataSource.remove(client);
    }

    @Override
    public int count() {
        return this.dataSource.size();
    }
}
