window.addEventListener('load', function () {

    const formulario = document.querySelector('#add_new_turno');

   formulario.addEventListener('submit', function (event) {
   event.preventDefault()
        const formDataPost = {
            fecha: document.querySelector('#fechaTurno').value,
            paciente_id: document.querySelector('#idPaciente').value,
            odontologo_id: document.querySelector('#idOdontologo').value,
        };
        const url = '/turnos';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formDataPost)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> Turno agregado </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 resetUploadForm();

            })
            .catch(error => {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente</strong> </div>'

                      document.querySelector('#response').innerHTML = errorAlert;
                      document.querySelector('#response').style.display = "block";
                      window.location.reload();})
    });
    function resetUploadForm(){
            document.querySelector('#fechaTurno').value = "";
            document.querySelector('#paciente').value = "";
            document.querySelector('#odontologo').value = "";

        }

    (function(){
         let pathname = window.location.pathname;
         if(pathname === "/"){
               document.querySelector(".nav .nav-item a:first").addClass("active");
            } else if (pathname == "/listarTurnos.html") {
                document.querySelector(".nav .nav-item a:last").addClass("active");
            }
   });
});