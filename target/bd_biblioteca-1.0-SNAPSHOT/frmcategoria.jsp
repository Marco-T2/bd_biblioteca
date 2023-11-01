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
            <h1>Formulario de categoria</h1>
            <br>
            <form action="CategoriaControlador" method="post">
                <input type="hidden" name="id_categoria" value="${categoria.id_categoria}">
                <div class="mb-3">
                    <label  class="form-label">Nombre de Categoria</label>
                    <input type="text" class="form-control" name="categoria" value="${categoria.categoria}" placeholder="Escriba  nombre de categoria">
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>


        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
</html>