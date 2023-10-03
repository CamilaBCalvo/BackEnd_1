const formulario = document.querySelector('#update_turno_form');

    formulario.addEventListener('submit', function (event) {
    event.preventDefault()
        let turnoId = document.querySelector('#turno_id').value;

        const formData = {
            id: document.querySelector('#turno_id').value,
            fechaTurno: document.querySelector('#fechaTurno1').value,
            idPaciente: document.querySelector('#idPaciente1').value,
            idOdontologo: document.querySelector('#idOdontologo1').value,

        };

        const url = '/turnos';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json());
          window.location.reload()

    })


    function findBy(id) {
          const url = '/turnos'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let odontologo = data;
              document.querySelector('#turno_id').value = turno.id;
              document.querySelector('#fechaTurno1').value = turno.fecha;
              document.querySelector('#idPaciente1').value = turno.paciente_id;
              document.querySelector('#idOdontologo1').value = turno.odontologo_id;
              document.querySelector('#div_turno_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
              window.location.reload();
          })
      }