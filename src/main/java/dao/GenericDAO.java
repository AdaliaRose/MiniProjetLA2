/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author mac-clement
 */
public interface GenericDAO<T> {
    
    
    public boolean update(T object);
    public boolean create(T object);
    public boolean delete(T object);
    public boolean deleteAll();
    public T find(Integer id);
    public List<T> findAll();
    public void close();


}
