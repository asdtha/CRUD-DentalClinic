window.addEventListener('load', function () {

    const formulario = document.querySelector('#add_new_pacient');
    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        const formData = { // cargado en html
            name: document.querySelector('#nombre').value,
            lastname: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            entryDate: document.querySelector('#fechaEntrada').value,
            address: {
                 street : document.querySelector('#calle').value,
                 number: document.querySelector('#numero').value,
                 district : document.querySelector('#localidad').value,
                 province : document.querySelector('#provincia').value,
            }
        };

        const url = '/pacients';
        const settings = {
            method: 'POST', //tipo de request
            headers: {
                'Content-Type': 'application/json',  // para que el controller pueda leer los datos que le enviamos y que son en formato json
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings) // le pasamos la url y la configuración
            .then(response => response.json()) // concatenamos un método a otro, en el primer then pasamos el response a json
            .then(data => { // en el segundo then manipulamos el dom inyectando el html
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong> Paciente agregado </strong></div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 resetUploadForm(); // limpiamos el formulario

            })
            .catch(error => { // hacemos un catch en caso de que ocurra un error en los métodos inyectando un mensaje en html
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong>Error intente nuevamente</strong> </div>'

                      document.querySelector('#response').innerHTML = errorAlert;
                      document.querySelector('#response').style.display = "block";
                     resetUploadForm();})
    });

    function resetUploadForm(){
        document.querySelector('#nombre').value = "";
        document.querySelector('#apellido').value = "";
        document.querySelector('#dni').value = "";
        document.querySelector('#fechaEntrada').value = "";
        document.querySelector('#calle').value = "";
        document.querySelector('#numero').value = "";
        document.querySelector('#localidad').value = "";
        document.querySelector('#provincia').value = "";
    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/pacients_list.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});