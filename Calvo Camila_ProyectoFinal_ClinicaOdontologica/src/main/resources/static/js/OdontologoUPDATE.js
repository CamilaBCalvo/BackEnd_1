    const formulario = document.querySelector('#update_odontologo_form');

    formulario.addEventListener('submit', function (event) {
    event.preventDefault()
        let odontologoId = document.querySelector('#odontologo_id').value;

        const formData = {
            id: document.querySelector('#odontologo_id').value,
            nombre: document.querySelector('#nombre1').value,
            apellido: document.querySelector('#apellido1').value,
            matricula: document.querySelector('#matricula1').value,
        };

        const url = '/odontologos';
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
          const url = '/odontologos'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let odontologo = data;
              document.querySelector('#odontologo_id').value = odontologo.id;
              document.querySelector('#nombre1').value = odontologo.nombre;
              document.querySelector('#apellido1').value = odontologo.apellido;
              document.querySelector('#matricula1').value = odontologo.matricula;
              document.querySelector('#div_odontologo_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
              })
      }