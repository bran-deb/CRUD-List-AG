package pooInterfaces.abstractas;


import pooInterfaces.exceptions.checked.DuplicateRecordDataAccessException;
import pooInterfaces.exceptions.checked.ReadDataAccessException;
import pooInterfaces.exceptions.checked.WriteDataAccessException;
import pooInterfaces.modelo.BaseEntity;

import java.util.ArrayList;
import java.util.List;

//
public abstract class GenericListDAO<T extends BaseEntity> implements CrudMergeRepository<T> {

    protected final List<T> dataSource;

    public GenericListDAO() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public T getByID(Integer id) throws ReadDataAccessException {
        if (id == null || id <= 0) {
            throw new ReadDataAccessException("Id invalido debe ser >0");
        }
        T clientById = null;
        for (T cliente : dataSource) {
            if (cliente.getId() != null && cliente.getId().equals(id)) {
                clientById = cliente;
                break;
            }
        }

        if (clientById == null) {
            throw new ReadDataAccessException("No existe el registro con id: " + id);
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
    public void create(T t) throws WriteDataAccessException {
        if (t == null) {
            throw new WriteDataAccessException("Error al insertar un objeto");
        }
        if (this.dataSource.contains(t)){
            throw new DuplicateRecordDataAccessException("Error, objeto con id: "+t.getId()+" ya existe");
        }
        this.dataSource.add(t);
    }

    @Override
    public void delete(Integer id) throws ReadDataAccessException {
        T client = this.getByID(id);
        this.dataSource.remove(client);
    }

    @Override
    public int count() {
        return this.dataSource.size();
    }
}
