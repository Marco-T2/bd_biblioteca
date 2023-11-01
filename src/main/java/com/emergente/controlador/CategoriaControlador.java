package com.emergente.controlador;

import com.emergente.dao.CategoriaDAO;
import com.emergente.dao.CategoriaDAOimpl;
import com.emergente.modelo.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CategoriaControlador", urlPatterns = {"/CategoriaControlador"})
public class CategoriaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            Categoria c = new Categoria();
            int id;
            CategoriaDAO dao = new CategoriaDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("categoria", c);
                    request.getRequestDispatcher("frmcategoria.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id_categoria"));
                    c = dao.getById(id);
                    // Colocar como atributo
                    request.setAttribute("categoria", c);
                    // Transferir el control a frmproducto.jsp
                    request.getRequestDispatcher("frmcategoria.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id_categoria"));
                    dao.delete(id);
                    response.sendRedirect("CategoriaControlador");
                    break;
                case "view":
                    //obtener la lista de objetos (registros)
                    List<Categoria> lista = dao.getAll();
                    request.setAttribute("categorias", lista);
                    request.getRequestDispatcher("categoria.jsp").forward(request, response);
                    break;
                default:

                    break;
            }

        } catch (Exception e) {
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_categoria"));
        String categoria = request.getParameter("categoria");


        Categoria cat = new Categoria();

        cat.setId_categoria(id);
        cat.setCategoria(categoria);


        CategoriaDAO dao = new CategoriaDAOimpl();
        if (id == 0) {
            try {
                // Nuevo registro
                dao.insertar(cat);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }
        } else {
            try {
                // Edicion de registro
                dao.update(cat);
            } catch (Exception ex) {
                System.out.println("Error al editar " + ex.getMessage());
            }
        }
        response.sendRedirect("CategoriaControlador");

    }

}
