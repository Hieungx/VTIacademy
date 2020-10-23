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
var counter = 0;

function Employee(name, department, phone) {
    this.id = ++counter;
    this.name = name;
    this.department = department;
    this.phone = phone;
}

function initEmployees() {
    if (null == employees || employees.length == 0) {
        //init Data
        employees.push(new Employee("Huan", "Administration", "2113-1231"));
        employees.push(new Employee("Jonhny Dang", "Custom Service", "123-3213-22"));
        employees.push(new Employee("Peter Paker", "Human Resources", "212-332-112-2"));
    }
}

function buildTable() {
    // Sau 2s đổ data vào
    setTimeout(function name(params) {

        $('tbody').empty();
        initEmployees();

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

    }, 500);
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
    var name = document.getElementById("name").value;
    var department = document.getElementById("department").value;
    var phone = document.getElementById("phone").value;

    // TODO validate
    // then fali validate => return

    employees.push(new Employee(name, department, phone));

    hideModal();
    showSuccessAlert();
    buildTable();

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

    // get index from employee's id
    var index = employees.findIndex(x => x.id == id);

    // update employee
    employees[index].name = name;
    employees[index].department = department;
    employees[index].phone = phone;

    hideModal();
    showSuccessAlert();
    buildTable();
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

function deleteEmployee() {
    // TODO validate

    // get index from employee's id
    var index = employees.findIndex(x => x.id == id);
    employees.splice(index, 1); // delete và dồn các phần tử lại

    showSuccessAlert();
    buildTable();
}

function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
        $("#success-alert").slideUp(500);
    });
}