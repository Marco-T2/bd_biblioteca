<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"/>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>Biblioteca</title>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Categoria</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="categorias"/>
            </jsp:include>
            <br>
            <a href="CategoriaControlador?action=add" class="btn btn-primary btn-sn"><i class="fa-regular fa-square-plus"></i> Nuevo</a>
            <br>
            <br>
            <table class="table table-striped table-hover">
                <tr>
                    <th>Id</th>
                    <th>Nombre categoria</th>
                    <th colspan="2">Opciones</th>
                    
                </tr>
                <c:forEach var="item" items="${categorias}">
                    <tr>
                        <td>${item.id_categoria}</td>
                        <td>${item.categoria}</td>
                        <td><a href="CategoriaControlador?action=edit&id_categoria=${item.id_categoria}"><i class="fa-solid fa-file-pen"></i></a></td>
                        <td><a href="CategoriaControlador?action=delete&id_categoria=${item.id_categoria}" onclick="return(confirm('Está seguro de eliminar ?'))"> <i class="fa-solid fa-trash-can"></i></a></td>
                    </tr>                    
                </c:forEach>
            </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
</html>