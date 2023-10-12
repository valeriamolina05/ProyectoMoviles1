const loginContainer = document.getElementById('login');
        const registroContainer = document.getElementById('registro');

        document.querySelector('.register-link a').addEventListener('click', function(event) {
            event.preventDefault();
            loginContainer.style.display = 'none';
            registroContainer.style.display = 'block';
        });

        document.querySelector('#registro-form .register-link a').addEventListener('click', function(event) {
            event.preventDefault();
            registroContainer.style.display = 'none';
            loginContainer.style.display = 'block';
        });


    

function validarLogin() {
    var tipo = document.getElementById("tipo").value;
    var documento = document.getElementById("documento").value;
    var contrasena = document.getElementById("contrasena").value;

    if (tipo === "" || documento === "" || contrasena === "") {
        Swal.fire({
            icon: 'error',
            title: 'Campos vacíos',
            text: 'Por favor, complete todos los campos.'
        });
        return false;
    }

    return true;
}

function validarRegistro() {
    var tipo = document.getElementById("registro-tipo").value;
    var documento = document.getElementById("registro-documento").value;
    var nombre = document.getElementById("registro-nombre").value;
    var correo = document.getElementById("registro-correo").value;
    var ubicacion = document.getElementById("registro-ubicacion").value;

    if (tipo === "" || documento === "" || nombre === "" || correo === "" || ubicacion === "") {
        Swal.fire({
            icon: 'error',
            title: 'Campos vacíos',
            text: 'Por favor, complete todos los campos.'
        });
        return false;
    }


    return true;
}


          
