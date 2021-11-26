window.addEventListener('load', function () {

(function(){
  event.preventDefault();
  const url = '/dentists/list';
  const settings = {
    method: 'GET'
}
  fetch(url,settings)
  .then(response => response.json())
  .then(data => {
     for(dentist of data){

       let deleteButton = '<button' +
                                  ' id=' + '\"' + 'btn_delete_' + dentist.id + '\"' +
                                  ' type="button" onclick="deleteBy('+dentist.id+')" class="btn btn-danger btn_delete">' +
                                  '&times' +
                                  '</button>';

      let get_More_Info_Btn = '<button' +
                                  ' id=' + '\"' + 'btn_id_' + dentist.id + '\"' +
                                  ' type="button" onclick="findBy('+dentist.id+')" class="btn btn-info btn_id">' +
                                  dentist.id +
                                  '</button>';

      let tr_id = 'tr_' + dentist.id;
      let dentistRow = '<tr id=\"' + tr_id + "\"" + '>' +
                '<td>' + get_More_Info_Btn + '</td>' +
                '<td class=\"td_first_name\">' + dentist.name.toUpperCase() + '</td>' +
                '<td class=\"td_last_name\">' + dentist.lastname.toUpperCase() + '</td>' +
                '<td>' + deleteButton + '</td>' +
                '</tr>';
      $('#dentistTable tbody').append(dentistRow);
    };

})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/dentists_list.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})


})