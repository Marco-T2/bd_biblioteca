package com.emergente.dao;

import com.emergente.modelo.Categoria;
import com.emergente.modelo.Libro;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOimpl extends ConexionDB implements CategoriaDAO {

    @Override
    public void insertar(Categoria categoria) throws Exception {
        try {
            //Como es una extencion de conectar se paso todos los metodos para utilizar
            this.conectar();
            String sql = "insert into categoria (categoria) values (?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //Del objeto cliente vamos obteniendo los valores
            ps.setString(1, categoria.getCategoria());
            ps.executeUpdate();
            //Recomendable usar un try cath
        } catch (Exception e) {
            throw e;
        } finally {
            this.deconectar();
        }
    }

    @Override
    public void update(Categoria categoria) throws Exception {
        try {
            //Como es una extencion de conectar se paso todos los metodos para utilizar
            this.conectar();
            String sql = "update categoria set categoria=? where id_categoria=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //Del objeto cliente vamos obteniendo los valores
            ps.setString(1, categoria.getCategoria());
            ps.setInt(2, categoria.getId_categoria());
            ps.executeUpdate();
            //Recomendable usar un try cath
        } catch (Exception e) {
            throw e;
        } finally {
            this.deconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            //Como es una extencion de conectar se paso todos los metodos para utilizar
            this.conectar();
            String sql = "delete from categoria where id_categoria=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //Del objeto cliente vamos obteniendo los valores
            ps.setInt(1, id);
            ps.executeUpdate();
            //Recomendable usar un try cath
        } catch (Exception e) {
            throw e;
        } finally {
            this.deconectar();
        }
    }

    @Override
    public Categoria getById(int id) throws Exception {
        //Creamos un objeto y la instanciamos como nuevo objeto
        Categoria cat = new Categoria();
        try {
            //Como es una extencion de conectar se paso todos los metodos para utilizar
            this.conectar();
            String sql = "select * from categoria where id_categoria =?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //Del objeto cliente vamos obteniendo los valores
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            //Si hay un registro entonces lo leemos y lo pondremos el el objeto cat
            if (rs.next()) {
                cat.setId_categoria(rs.getInt("id_categoria"));
                cat.setCategoria(rs.getString("categoria"));
            }
            //Recomendable usar un try cath
        } catch (Exception e) {
            throw e;
        } finally {
            this.deconectar();
        }
        return cat;
    }

    @Override
    public List<Categoria> getAll() throws Exception {
                //Creamos una coleccion de clientes y la instanciamos como nuevo objeto
        List<Categoria> lista= null;
        try {
            //Como es una extencion de conectar se paso todos los metodos para utilizar
            this.conectar();
            String sql = "select * from categoria";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            //Se tiene el resultado en rs    
            ResultSet rs = ps.executeQuery();
            
            //Iniciamos la lista
            lista = new ArrayList<Categoria>();
            
            //Cambiamos el if por while al ser mas de un registro
            while(rs.next()){
                //Instanciasmo un nuevo objeto
                Categoria cat = new Categoria();
                cat.setId_categoria(rs.getInt("id_categoria"));
                cat.setCategoria(rs.getString("categoria"));            
                lista.add(cat);
            }
            rs.close();
            ps.close();
            //Recomendable usar un try cath
        } catch (Exception e) {
            throw e;
        } finally {
            this.deconectar();
        }
        return lista;
        
    }

}
