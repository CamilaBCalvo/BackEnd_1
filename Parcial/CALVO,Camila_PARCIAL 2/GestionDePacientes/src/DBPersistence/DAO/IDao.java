package DBPersistence.DAO;

import java.util.List;

public interface IDao <T> {
    public T crear (T t) throws Exception;
    public void eliminar(int id);
    public T buscar(int id);
    public void modificar(T t);
    public List<T> buscarTodos();
}
