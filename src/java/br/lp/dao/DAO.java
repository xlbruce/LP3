package br.lp.dao;

import br.lp.javabeans.User;
import java.util.List;

/**
 * Inteface generica para prover acesso ao banco de dados
 * @author 31409695
 */
public interface DAO<E> {
    
    public boolean insert(E obj);
    
    public boolean update(E old, E newObj);
    
    public boolean delete(E obj);
    
    public List<E> read();
    
}
