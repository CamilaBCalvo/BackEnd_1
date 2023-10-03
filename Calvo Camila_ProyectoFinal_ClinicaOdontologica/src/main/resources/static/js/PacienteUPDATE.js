 const formulario = document.querySelector('#update_paciente_form');

    formulario.addEventListener('submit', function (event) {
        event.preventDefault()
        let pacienteId = document.querySelector('#paciente_id').value;

        const formData = {
            id: document.querySelector('#paciente_id').value,
            nombre: document.querySelector('#nombre1').value,
            apellido: document.querySelector('#apellido1').value,
            documento: document.querySelector('#documento1').value,
            fechaIngreso: document.querySelector('#fechaDeIngreso1').value,
            domicilio:{
                            id: document.querySelector('#domicilio_id1').value,
                            calle: document.querySelector('#calle1').value,
                            numero: document.querySelector('#numero1').value,
                            localidad: document.querySelector('#localidad1').value,
                            provincia: document.querySelector('#provincia1').value,
                                   },
            email: document.querySelector('#email1').value

        };

        const url = '/pacientes';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())
          window.location.reload()
    })


    function findBy(id) {
          const url = '/pacientes'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let paciente = data;
              document.querySelector('#paciente_id').value=paciente.id;
              document.querySelector('#nombre1').value=paciente.nombre;
              document.querySelector('#apellido1').value=paciente.apellido;
              document.querySelector('#documento1').value=paciente.documento;
              document.querySelector('#fechaDeIngreso1').value=paciente.fechaDeIngreso;
              document.querySelector('#domicilio_id1').value=paciente.domicilio.id;
              document.querySelector('#calle1').value=paciente.domicilio.calle;
              document.querySelector('#numero1').value=paciente.domicilio.numero;
              document.querySelector('#localidad1').value=paciente.domicilio.localidad;
              document.querySelector('#provincia1').value=paciente.domicilio.provincia;
              document.querySelector('#email1').value=paciente.email;
              document.querySelector('#div_paciente_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }