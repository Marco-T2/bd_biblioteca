package com.emergente.dao;

import com.emergente.modelo.Libro;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDAOimpl extends ConexionDB implements LibroDAO {

    @Override
    public void insertar(Libro libro) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO libros (titulo,autor,disponible,id_categoria) values (?,?,?,?)");
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getDisponible());
            ps.setInt(4, libro.getId_categoria());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.deconectar();
        }
    }

    @Override
    public void update(Libro libro) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE libros SET titulo=?, autor=?, disponible=?, id_categoria=? WHERE id=?");
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getDisponible());
            ps.setInt(4, libro.getId_categoria());
            ps.setInt(5, libro.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.deconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM libros WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.deconectar();
        }
    }

    @Override
    public Libro getById(int id) throws Exception {
        //Creamos un objeto y la instanciamos como nuevo objeto
        Libro l = new Libro();
        try {
            this.conectar();
            String sql = "select * from libros where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                l.setId(rs.getInt("id"));
                l.setTitulo(rs.getString("titulo"));
                l.setAutor(rs.getString("autor"));
                l.setDisponible(rs.getString("disponible"));
                l.setId_categoria(rs.getInt("id_categoria"));

            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.deconectar();
        }
        return l;
    }

    @Override
    public List<Libro> getAll() throws Exception {
        //Creamos una coleccion de clientes y la instanciamos como nuevo objeto
        List<Libro> lista = null;
        try {
            this.conectar();
            String sql = "select l.*,c.categoria from libros l left JOIN categoria c on l.id_categoria=c.id_categoria";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Libro>();
            while (rs.next()) {
                Libro l = new Libro();

                l.setId(rs.getInt("id"));
                l.setTitulo(rs.getString("titulo"));
                l.setAutor(rs.getString("autor"));
                l.setDisponible(rs.getString("disponible"));
                l.setId_categoria(rs.getInt("id_categoria"));
                l.setCategoria(rs.getString("categoria"));
                lista.add(l);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.deconectar();
        }
        return lista;
    }
}
