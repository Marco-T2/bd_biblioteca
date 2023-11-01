<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="es">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Libros</title>
    </head>

    <body>
        <div class="container">
            <h1>Formulario de libros</h1>

            <form action="LibroControlador" method="post">
                <input type="hidden" name="id" value="${libro.id}"/>
                <div class="form-group">
                    <label for="" class="form-label">Titulo</label>
                    <input type="text" class="form-control" name="titulo" value="${libro.titulo}" placeholder="Escriba la título">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Autor</label>
                    <input type="text" class="form-control" name="autor" value="${libro.autor}" placeholder="Escriba la autor">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Disponible</label>
                    <input type="text" class="form-control" name="disponible" value="${libro.disponible}" placeholder="Escriba la diponible">
                </div>

                <div class="form-group">
                    <label for="" class="form-label">Categoria</label>

                    <select name="id_categoria" class="form-control">
                        <option value="">--seleccione--</option>
                        <c:forEach var="item" items="${lista_categoria}">
                            <option value="${item.id_categoria}" <c:if test="${libro.id_categoria == item.id_categoria}" > selected </c:if> > ${item.categoria} </option>

                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    </body>

</html>