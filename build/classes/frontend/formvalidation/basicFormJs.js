(() => {
    window.onload=init;
})();

var request;

function init(){
    request = new XMLHttpRequest();

    const submit = document.querySelector("#submit");
    const update = document.querySelector("#update");

    initializeRequest();

    initializeTable();

    submit.addEventListener("click", () => {
        request.open("GET", generateRequestURL());
        request.send();
    });

    update.addEventListener("click", () => {
        request.open("GET", generateUpdateRequestURL());
        request.send();
    });
}

function initializeTable(){
    request.open("GET", "http://localhost:5000/INITIALIZE_TABLE");
    request.send();
}

function initializeRequest(){
    request.addEventListener("loadend",(event) => {
         if(request.status == 200 && request.readyState == 4){
            console.log("Done");
            response();
         }else{
            console.log("Error");
         }
    });
}

function response(){
    var response = request.response;
    switch(response){
        case "EMPTY_FIELD":
            alert("Please fill up all the fields");
            break;
        case "INVALID_NAME_CHARACTER":
            alert("Only alphabets allowed in name");
            break;
        case "LOW_NAME_CHARACTER":
            alert("Name has to be at least of 3 characters long");
            break;
        case "NEGATIVE_AGE":
            alert("Age cannot be of negative value");
            break;
        default:
            const responseType = response.split(",");

            switch(responseType[0]){
                case "ADD_DATA":
                    addRow(responseType[1], responseType[2], responseType[3]);
                    emptyFields();
                    break;
                case "UPDATE_DATA":
                    emptyFields();
                    deleteTable();
                    initializeTable();
                    break;
                default:
                //table initialize
                    const row = response.split("/");
                     row.splice(-1);
                     row.forEach(element => {
                        var data = element.split(",");
                        addRow(data[0], data[1], data[2]);
                     });
            }
    }

}

function generateRequestURL(){
    var request = "http://localhost:5000/";
    var name=document.querySelector("#fname").value;
    var age=document.querySelector("#age").value;
    var id=document.getElementById("dataTable").rows.length;
    request = request + "id=" + id + "&/name=" + name + "&/age=" + age;
    return request;
}

function generateUpdateRequestURL(){
    var request = "http://localhost:5000/";
        var name=document.querySelector("#updateName").value;
        var age=document.querySelector("#updateAge").value;
        var id=document.querySelector("#updateId").value;
        request = request + "id=" + id + "&/name=" + name + "&/age=" + age;
        return request;
}

function addRow(id, name, age){
    var table = document.getElementById("dataTable");
    var row = table.insertRow(-1);
    var firstCell = row.insertCell(0);
    var secondCell = row.insertCell(1);
    var thirdCell = row.insertCell(2);

    firstCell.innerText = id;
    secondCell.innerText = name;
    thirdCell.innerText = age;

    row.addEventListener("click", () => {
        var updateId = document. getElementById("updateId");
        var updateName = document.getElementById("updateName");
        var updateAge = document.getElementById("updateAge");

        updateId.value = id;
        updateName.value = name;
        updateAge.value = age;

    });
}

function emptyFields(){
    var name = document.getElementById("fname");
    var age = document.getElementById("age");
    var updateName = document.getElementById("updateName");
    var updateAge = document.getElementById("updateAge");
    var updateId = document.getElementById("updateId");
    name.value = "";
    age.value = "";
    updateName.value = "";
    updateAge.value = "";
    updateId.value = "";
}

function deleteTable(){
    var table = document.getElementById("dataTable");
    while(table.rows.length > 1){
        table.deleteRow(1);
    }
}