package com.emergente.dao;

import com.emergente.modelo.Libro;
import java.util.List;

public interface LibroDAO {
    
    public void insertar(Libro libro) throws Exception;   
    public void update (Libro libro) throws Exception;    
    public void delete(int id) throws Exception;  
    public Libro getById(int id)throws Exception;  
    public List<Libro> getAll()throws Exception;   
    
}
