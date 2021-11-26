window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_pacient_form');
    formulario.addEventListener('submit', function (event) {
        let pacientId = document.querySelector('#pacient_id').value;
        const formData = {
            id: document.querySelector('#pacient_id').value,
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
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })

    function findBy(id) {
          const url = '/pacients'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let pacient = data;
              document.querySelector('#pacient_id').value = pacient.id;
              document.querySelector('#nombre').value = pacient.name;
              document.querySelector('#apellido').value = pacient.lastname;
              document.querySelector('#dni').value = pacient.dni;
              document.querySelector('#fechaEntrada').value = pacient.entryDate;
              document.querySelector('#calle').value = address.street;
              document.querySelector('#numero').value = address.number;
              document.querySelector('#localidad').value = address.district;
              document.querySelector('#provincia').value = address.province;

              document.querySelector('#div_pacient_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }