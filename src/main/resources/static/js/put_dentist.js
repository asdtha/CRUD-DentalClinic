window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_dentist_form');
    formulario.addEventListener('submit', function (event) {
        let dentistId = document.querySelector('#dentist_id').value;
        const formData = {
            id: document.querySelector('#dentist_id').value,
            name: document.querySelector('#nombre').value,
            lastname: document.querySelector('#apellido').value,
            licenseNumber: document.querySelector('#matricula').value,

        };

        const url = '/dentists';
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
          const url = '/dentists'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let dentist = data;
              document.querySelector('#dentist_id').value = dentist.id;
              document.querySelector('#nombre').value = dentist.name;
              document.querySelector('#apellido').value = dentist.lastname;
              document.querySelector('#matricula').value = dentist.licenseNumber;


              document.querySelector('#div_dentist_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }