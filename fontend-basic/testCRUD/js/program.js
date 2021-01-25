$(function(){
    $(".header").load("header.html"); 
    $(".main").load("home.html");
    $(".footer").load("footer.html");
  });

  function moveHome(){
    $(".main").load("home.html");
  }

  function moveViewHome(){
    $(".main").load("main.html");
    showEmployee();
    // console.log(employee);
  }

  var employee = [];
  var counter=0;
  function Employee(name, department, phone)
  {
    this.id = ++counter;
    this.name = name; 
    this.department = department;
    this.phone = phone;
  }

  function createDataEmployee(){
    if(employee==null || employee.length==0){
      employee.push(new Employee("Nguyễn Thị Chinh","tester",1))
      employee.push(new Employee("Đinh Huy Khánh","DEV",2))
      employee.push(new Employee("Nguyễn Như Trọng","DEV",3))
      employee.push(new Employee("Đình Văn Tuấn","DEV",4))
      employee.push(new Employee("Khuất Bá Tiến","DEV",5))
    }
  }

  function  showEmployee(){
     setTimeout(function name(params){
      $("tbody").empty();
      createDataEmployee();
    employee.forEach(function(item){
      $("tbody").append(
      '<tr>'
      +'<td>'+item.name+'</td>'
      +'<td>'+item.department+'</td>'
      +'<td>'+item.phone+'</td>'
      +'<td>'
         +'<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal('+item.id+')"><i class="material-icons">&#xE254;</i></a>'
         +'<a class="delete" title="Delete" data-toggle="tooltip" onclick ="openConfirmDelete('+ item.id+')"><i class="material-icons">&#xE872;</i></a>'
      +'</td>'
      +'</tr>'
      )
    });
    },100);
  }

  function openModal(){
    $("#myModal").modal("show");
  }

  function openAddModal(){
    resetFrom();
    openModal();
  }
  function hideModal(){
    $('#myModal').modal('hide');
  }
  
  function resetFrom(){
    document.getElementById("id").value="";
    document.getElementById("name").value="";
    document.getElementById("department").value="";
    document.getElementById("phone").value="";

  }
  function openUpdateModal(id){
    var index = employee.findIndex(x => x.id == id)
    
    document.getElementById("id").value = employee[index].id;
    document.getElementById("name").value = employee[index].name;
    document.getElementById("department").value = employee[index].department;
    document.getElementById("phone").value = employee[index].phone;
    openModal();
  }

  function updateEmployee(){
    
    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;
    var department = document.getElementById("department").value;
    var phone = document.getElementById("phone").value;

    var index= employee.findIndex( x => x.id == id);

    
    employee[index].name = name;
    employee[index].department = department;
    employee[index].phone = phone;
    
    hideModal();
    showEmployee();
  }
  function addEmployee(){

    var name = document.getElementById("name").value;
    var department = document.getElementById("department").value;
    var phone = document.getElementById("phone").value;

    employee.push(new Employee(name,department, phone));

    hideModal();
    showSuccessAlert();
    showEmployee();
  }

  function save(){
    var id = document.getElementById("id").value;
    if(id == null || id =="")
    {
      addEmployee();
    }
    else {
      updateEmployee();
    }
  }
  function openConfirmDelete(id){
    var index = employee.findIndex(x => x.id ==id);
      var name = employee[index].name;
      var result  = confirm("Want to delete"+ name + "?");
      if(result){
        deleteEmployee(id)
      }
  }

  function deleteEmployee(id){
     var index = employee.findIndex(x=>x.id === id)
     employee.splice(index,1);
     showEmployee();
     showEmployee();
  }
  function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
        $("#success-alert").slideUp(500);
    });
}


