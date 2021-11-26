window.addEventListener('load', function () {

(function(){
  event.preventDefault();
  const url = '/pacients/list';
  const settings = { // en el obj de config le pasamos únicamente el tipo de request
    method: 'GET' // como es get no recibe body, no tenemos que mandarle nada más porque no recibe nada
}
  fetch(url,settings)
  .then(response => response.json())
  .then(data => {
     for(pacient of data){ // iteramos el response e inyectamos el html para crear una tabla

       let deleteButton = '<button' +
                                  ' id=' + '\"' + 'btn_delete_' + pacient.id + '\"' +
                                  ' type="button" onclick="deleteBy('+pacient.id+')" class="btn btn-danger btn_delete">' +
                                  '&times' +
                                  '</button>';

      let get_More_Info_Btn = '<button' +
                                  ' id=' + '\"' + 'btn_id_' + pacient.id + '\"' +
                                  ' type="button" onclick="findBy('+pacient.id+')" class="btn btn-info btn_id">' +
                                  pacient.id +
                                  '</button>';

      let tr_id = 'tr_' + pacient.id;
      let pacientRow = '<tr id=\"' + tr_id + "\"" + '>' +
                '<td>' + get_More_Info_Btn + '</td>' +
                '<td class=\"td_first_name\">' + pacient.name.toUpperCase() + '</td>' +
                '<td class=\"td_last_name\">' + pacient.lastname.toUpperCase() + '</td>' +
                '<td class=\"td_dni\">' + pacient.dni + '</td>' +
                '<td class=\"td_entry_date\">' + pacient.entryDate + '</td>' +
                '<td class=\"td_address\">' + pacient.address.street + ',' + pacient.address.number + ',' + pacient.address.district + ',' + pacient.address.province + '</td>' +
                '<td>' + deleteButton + '</td>' +
                '</tr>';
      $('#pacientTable tbody').append(pacientRow);
    };

})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/pacients_list.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})


})