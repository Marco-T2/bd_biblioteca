package com.emergente.controlador;

import com.emergente.dao.CategoriaDAO;
import com.emergente.dao.CategoriaDAOimpl;
import com.emergente.dao.LibroDAO;
import com.emergente.dao.LibroDAOimpl;
import com.emergente.modelo.Categoria;
import com.emergente.modelo.Libro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LibroControlador", urlPatterns = {"/LibroControlador"})
public class LibroControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            LibroDAO dao = new LibroDAOimpl();
            CategoriaDAO daoCategoria = new CategoriaDAOimpl();
            int id;
            List<Categoria> lista_categorias = null;
            Libro libro = new Libro();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    lista_categorias = daoCategoria.getAll();
                    request.setAttribute("lista_categoria", lista_categorias);
                    request.setAttribute("libro", libro);
                    request.getRequestDispatcher("frmlibro.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    libro = dao.getById(id);
                    lista_categorias = daoCategoria.getAll();
                    request.setAttribute("lista_categoria", lista_categorias);

                    // Colocar como atributo
                    request.setAttribute("libro", libro);
                    // Transferir el control a frmventa.jsp
                    request.getRequestDispatcher("frmlibro.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("LibroControlador");
                    break;
                case "view":
                    //Obtener la lista de registros
                    List<Libro> lista = dao.getAll();
                    request.setAttribute("libros", lista);
                    request.getRequestDispatcher("libro.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error Fatal" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String disponible = request.getParameter("disponible");
        int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));

        Libro libro = new Libro();

        libro.setId(id);
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setDisponible(disponible);
        libro.setId_categoria(id_categoria);

        if (id == 0) {
            //Nuevo
            LibroDAO dao = new LibroDAOimpl();
            try {
                // Nuevo registro
                dao.insertar(libro);
                response.sendRedirect("LibroControlador");
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            //Editar
            LibroDAO dao = new LibroDAOimpl();
            try {
                dao.update(libro);
                response.sendRedirect("LibroControlador");
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
    }

}
