$(function() {
    $(".header").load("header.html");
    $(".main").load("home.html");
    $(".footer").load("footer.html");
});

function clickNavHome() {
    $(".main").load("home.html");
}

function clickViewListEmployees() {
    $(".main").load("viewlistemployees.html");
    buildTable();
}

var employees = [];

function Employee(id, name, department, phone) {
    this.id = id;
    this.name = name;
    this.department = department;
    this.phone = phone;
}

function getListEmployees() {
    // if (null == employees || employees.length == 0) {
    //     //init Data
    //     employees.push(new Employee("Huan", "Administration", "2113-1231"));
    //     employees.push(new Employee("Jonhny Dang", "Custom Service", "123-3213-22"));
    //     employees.push(new Employee("Peter Paker", "Human Resources", "212-332-112-2"));
    // }

    // call API from server
    $.get("https://5f8d9c4a4c15c40016a1df38.mockapi.io/employees", function(data, status) {
        // reset list
        employees = [];

        // error
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        //success
        parseData(data);
        fillEmployeeToTable();
    });
}

function parseData(data) {
    data.forEach(function(item) {
        employees.push(new Employee(item.id, item.name, item.department, item.phone));
    });
}

function fillEmployeeToTable() {
    employees.forEach(function(item) {
        $('tbody').append(
            '<tr>' +
            '<td>' + item.name + '</td>' +
            '<td>' + item.department + '</td>' +
            '<td>' + item.phone + '</td>' +
            '<td>' +
            '<a class="edit" title="Edit" data-toggle="tooltip" onClick ="openUpdateModal(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
            '<a class="delete" title="Delete" data-toggle="tooltip" onClick = "openConfirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
            '</td>' +
            '</tr>')
    });
}

function buildTable() {
    $('tbody').empty();
    getListEmployees();
}

function openAddModal() {
    resetForm();
    openMoldal();
}

function resetForm() {
    document.getElementById("id").value = "";
    document.getElementById("name").value = "";
    document.getElementById("department").value = "";
    document.getElementById("phone").value = "";
}

function openMoldal() {
    $('#myModal').modal('show');
}

function hideModal() {
    $('#myModal').modal('hide');
}

function addEmployee() {

    // get data
    var name = document.getElementById("name").value;
    var department = document.getElementById("department").value;
    var phone = document.getElementById("phone").value;

    // TODO validate
    // then fali validate => return

    var employee = {
        name: name,
        department: department,
        phone: phone
    }

    $.post("https://5f8d9c4a4c15c40016a1df38.mockapi.io/employees", employee, function(data, status) {
        // error
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        // success
        hideModal();
        showSuccessAlert();
        buildTable();
    })
}


function openUpdateModal(id) {

    // get index from employee's id
    var index = employees.findIndex(x => x.id == id);

    // fill data
    document.getElementById("id").value = employees[index].id;
    document.getElementById("name").value = employees[index].name;
    document.getElementById("department").value = employees[index].department;
    document.getElementById("phone").value = employees[index].phone;


    openMoldal();
}

function save() {
    var id = document.getElementById("id").value;
    if (id == null || id == "") {
        addEmployee()
    } else {
        updateEmployee();
    }
}

function updateEmployee() {
    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;
    var department = document.getElementById("department").value;
    var phone = document.getElementById("phone").value;

    // TODO validate
    // then fali validate => return

    var employee = {
        name: name,
        department: department,
        phone: phone
    }

    $.ajax({
        url: 'https://5f8d9c4a4c15c40016a1df38.mockapi.io/employees/' + id,
        type: 'PUT',
        data: employee,
        success: function(result) {
            // do something with the result
            //success
            hideModal();
            showSuccessAlert();
            buildTable();
        }
    });

    // get index from employee's id
    // var index = employees.findIndex(x => x.id == id);

    // // update employee
    // employees[index].name = name;
    // employees[index].department = department;
    // employees[index].phone = phone;


}


function openConfirmDelete(id) {
    // get index from employee's id
    var index = employees.findIndex(x => x.id == id);
    var name = employees[index].name;

    var result = confirm("Bạn chắc chắn muốn xóa nhân viên " + name + " chứ?");
    if (result) {
        deleteEmployee(id);
    }
}

function deleteEmployee(id) {
    // TODO validate
    $.ajax({
        url: 'https://5f8d9c4a4c15c40016a1df38.mockapi.io/employees/' + id,
        type: 'DELETE',
        success: function(result) {
            // do something with the result
            //success
            showSuccessAlert();
            buildTable();
        }
    });



    // get index from employee's id
    // var index = employees.findIndex(x => x.id == id);
    // employees.splice(index, 1); // delete và dồn các phần tử lại
}

function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
        $("#success-alert").slideUp(500);
    });
}