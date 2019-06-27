var xhr = new XMLHttpRequest();

function post(method, path, body, callback) {
    if (!xhr) {
        return;
    }
    xhr.open(method, path, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
            callback(xhr);
        }
    };
    xhr.send(body);
}

function readParams() {
    var popular = document.getElementById("popular");
    var price = document.getElementById("price");
    var available = document.getElementById("available");
    var form = new FormData();
    form.append("popular", popular.value);
    form.append("price", price.value);
    form.append("available", available.value);
    post('POST', "/filtering", form, empty());
}

function empty(){
}