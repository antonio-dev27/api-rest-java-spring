var urlBaseCita = "/api/Citas";

var consultarCita = function(){
    $.ajax({
        url: urlBaseCita + "/all",
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            console.log(respuesta);
            actualizarTabla(respuesta);
        },
        error: function (xhr, status) {
            console.log(xhr);
            console.log(status);
            alert('ha sucedido un problema');
        }
    });
}

var actualizarTabla = function (items) {
    var tabla = `<table class="table striped">
                  <tr>
                    <th>ID</th>
                    <th>FECHA INICIO</th>
                    <th>FECHA FIN </th>
                    <th>ESPECIALIDAD</th>
                    <th>DOCTOR</th>
                    <th>PACIENTE</th>
                  </tr>`;


    for (var i = 0; i < items.length; i++) {
        tabla += `<tr>
                   <td>${items[i].id_cita}</td>
                   <td>${items[i].fechaInicio}</td>
                   <td>${items[i].fechaInicio}</td>
                   <td>${items[i].fechaFin}</td>
                   <td>${items[i].especialidad.nombre}</td>
                   <td>${items[i].doctor.nombre}</td>
                   <td>${items[i].paciente.nombre}</td>
                   <td>
                    <button type="button" class="btn btn-sm btn-success" onclick="editar(${items[i].id}, '${items[i].fechaInicio}, '${items[i].fechaFin}, '${items[i].especialidad.nombre}, '${items[i].doctor.nombre}, '${items[i].paciente.nombre})">
                        Editar
                    </button>
                    <button type="button" class="btn btn-sm btn-danger" onclick="eliminar(${items[i].id})">
                        Eliminar
                    </button>
                   </td>
                </tr>`;
    }
    tabla += `</table>`;

    $("#tabla").html(tabla);
}

$(document).ready(function () {
    console.log("document ready");
    consultarCita();
});

var nuevaCita = function () {
    $("#tituloModalCita").html('Nueva Cita');
    $("#id").val('');
    $("#fechaInicio").val('');
    $("#fechaFin").val('');
    $("#especialidad").val('');
    $("#doctor").val('');
    $("#paciente").val('');
    $('#modalCita').modal('show');
}

var cerrarModal = function () {
    $('#modalCita').modal('hide');
}

var mostrarMensaje = function (mensaje) {
    $("#mensaje").html(mensaje);
    $('#modalMensaje').modal('show');
}

var cerrarModalMensaje = function(){
    $('#modalMensaje').modal('hide');
}

var guardarCambios = function () {
    var payload;
    var method;
    var id = $("#id").val();
    var msg;
    var ruta;
    if (id !== 'undefined' && id !== null && id.length > 0) {
        ruta = urlBaseEspecialidad + "/update";
        payload = {
            id: +$("#id").val(),
            nombre: $("#nombre").val(),
        };
        method = "PUT";
        msg = "Se ha actualizado la Especialidad";
    } else {
        ruta = urlBaseEspecialidad + "/save";
        payload = {
            nombre: $("#nombre").val(),
            apellido: $("#apellido").val(),
        };
        method = "POST";
        msg = "Se ha creado la Especialidad";
    }

    console.log("guardando ", payload)
    console.log("ruta ", ruta)
    console.log("method ", method)

    $.ajax({
        url: ruta,
        type: method,
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(payload),
        statusCode: {
            201: function () {
                mostrarMensaje(msg);
                cerrarModal();
                consultarEspecialidad();
            }
        },
    });
}

var editar = function (id, nombre) {
    $("#tituloModalEspecialidad").html('Actualizar Especialidad');
    $("#id").val(id);
    $("#nombre").val(nombre);
    $('#modalEspecialidad').modal('show');
}

var eliminar = function (id) {
    console.log("eliminando id: " + id)
    $.ajax({
        url: urlBaseEspecialidad + "/" + id,
        type: 'DELETE',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        statusCode: {
            204: function () {
                mostrarMensaje('Se ha eliminado la Especialidad');
                cerrarModal();
                consultarEspecialidad();
            }
        },
    });
}
