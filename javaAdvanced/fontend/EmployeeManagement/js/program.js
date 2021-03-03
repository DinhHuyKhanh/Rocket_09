$(function() {
    //$(".header").load("header.html");

    //ktra login, nếu có thì load home.html, ko thì load login.html
    $(".main").load("login.html");
    $(".footer").load("footer.html");
});

function clickNavLogin() {
    $(".main").load("login.html");
}

function login() {
    $(".main").load("home.html");
}

function clickNavHome() {
    $(".main").load("home.html");
}

function clickNavViewListEmployees() {

    if (status1 == 1) {
        $(".main").load("viewlistemployees.html");
        buildTable(0);
    } else {
        $(".main").load("login.html");
    }
}

var employees = [];

function Employee(id, name, totalMember) {
    this.id = id;
    this.name = name;
    this.totalMember = totalMember;
}

var page = 0;

function getListEmployees(page) {
    var search = "";
    var pageNumber = 1;
    var pageSize = 5;
    if (page == 0) {
        pageNumber = 1;
        pageSize = 100;
    } else {
        search = document.getElementById("search").value;
        pageSize = 5;
        pageNumber = page;
    }

    var minTotalMember = document.getElementById("minTotalMember").value;
    var maxTotalMember = document.getElementById("maxTotalMember").value;
    // call API from server
    $.get("http://localhost:8080/api/v1/departments?search=" + search + "&pageNumber=" + pageNumber + "&pageSize=" + pageSize + "&minMember=" + minTotalMember + "&maxMember=" + maxTotalMember, function(data, status) {

        // reset list employees
        employees = [];

        // error
        if (status == "error") {
            // TODO
            alert("Error when loading data");
            return;
        }

        // success
        parseData(data);
        fillEmployeeToTable();
    });
}

function parseData(data) {
    employees = data;

    // data.forEach(function(item) {
    //     employees.push(new Employee(item.id, item.name));
    // });
}

function fillEmployeeToTable() {
    employees.forEach(function(item) {
        $('tbody').append(
            '<tr>' +
            '<td>' + item.id + '</td>' +
            '<td>' + item.name + '</td>' +
            '<td>' + item.totalMember + '</td>' +
            '<td>' +
            '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
            '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
            '</td>' +
            '</tr>')
    });
}

function buildTable(page) {
    $('tbody').empty();
    getListEmployees(page);
}

function openAddModal() {
    resetForm();
    openModal();
}

function resetForm() {
    document.getElementById("id").value = "";
    document.getElementById("name").value = "";
    document.getElementById("totalMember").value = "";
}

function openModal() {
    $('#myModal').modal('show');
}

function hideModal() {
    $('#myModal').modal('hide');
}

function addEmployee() {

    // get data
    var name = document.getElementById("name").value;
    var totalMember = document.getElementById("totalMember").value;
    // TODO validate
    // then fail validate ==> return;

    var employee = {
        name: name,
        totalMember: totalMember
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/departments',
        type: 'POST',
        data: JSON.stringify(employee), // body
        contentType: "application/json", // type of body (json, xml, text)
        // dataType: 'json', // datatype return
        success: function(data, textStatus, xhr) {
            hideModal();
            showSuccessAlert();
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}


function openUpdateModal(id) {

    // get index from employee's id
    var index = employees.findIndex(x => x.id == id);

    // fill data
    document.getElementById("id").value = employees[index].id;
    document.getElementById("name").value = employees[index].name;
    document.getElementById("totalMember").value = employees[index].totalMember;

    openModal();
}

function save() {
    var id = document.getElementById("id").value;

    if (id == null || id == "") {
        addEmployee();
    } else {
        updateEmployee();
    }
}

function updateEmployee() {
    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;
    var totalMember = document.getElementById("totalMember").value;

    // TODO validate
    // then fail validate ==> return;

    var employee = {
        name: name,
        totalMember: totalMember
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + id,
        type: 'PUT',
        data: JSON.stringify(employee),
        contentType: "application/json",
        success: function(result) {
            // success
            hideModal();
            showSuccessAlert();
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}


function openConfirmDelete(id) {
    // get index from employee's id
    var index = employees.findIndex(x => x.id == id);
    var name = employees[index].name;

    var result = confirm("Want to delete " + name + "?");
    if (result) {
        deleteEmployee(id);
    }
}

function deleteEmployee(id) {
    // TODO validate
    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + id,
        type: 'DELETE',
        success: function(result) {
            // success
            showSuccessAlert();
            buildTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
        $("#success-alert").slideUp(500);
    });
}

function User(id, email, username, password, firstName, lastName, phone) {
    this.id = id;
    this.email = email;
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
}



var status1;

function check() {

    var uname = document.getElementById("uname").value;
    var psw = document.getElementById("psw").value;
    status1 = 0;
    $.get("http://localhost:8080/api/v1/users/name=" + uname, function(data, status) {

        // reset list employees
        user = [];

        // error
        if (status == "error") {
            // TODO
            alert("Error when loading data");
            status1 = 0;
            return;
        }
        if (data.username == uname && psw == data.password) {
            alert("thanh cong");
            status1 = 1;

        }


    });

}

function login() {
    status1 = check();
    if (status1 == 0) {
        alert("login that bai");
        return;
    } else {
        $(".main").load("viewlistemployees.html");
        buildTable(0);
    }
}