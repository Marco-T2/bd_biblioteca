<%
    String opcion = request.getParameter("opcion");
%>

<ul class="container text-center justify-content-center" ">
    <li class="nav-item">
        <a class="nav-link <%=(opcion.equals("libros") ? "active" : "")%> " href="LibroControlador">Libros</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <%=(opcion.equals("categorias") ? "active" : "")%>"  href="CategoriaControlador">Categoria</a>
    </li>

</ul>