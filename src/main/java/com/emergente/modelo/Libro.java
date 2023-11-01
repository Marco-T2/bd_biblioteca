package com.emergente.modelo;

public class Libro {

    private int id;
    private String titulo;
    private String autor;
    private String disponible;
    private int id_categoria;

    //Para trabajar con tablas cuando se saque el listado de productos esto
    //adicionales te permitira mostrar los datos completos descripcion y otros
    private String categoria;

    public Libro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", disponible=" + disponible + ", id_categoria=" + id_categoria + ", categoria=" + categoria + '}';
    }
    
    

}
