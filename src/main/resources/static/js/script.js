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

    var  cpusNumber = document.getElementById("cpusNumber");
    var  ramsNumber = document.getElementById("ramsNumber");
    var  gpusNumber = document.getElementById("gpusNumber");
    var  psusNumber = document.getElementById("psusNumber");
    var  disksNumber = document.getElementById("disksNumber");
    var  casesNumber = document.getElementById("casesNumber");
    var  motherboardsNumber = document.getElementById("motherboardsNumber");
    var  configurationsNumber = document.getElementById("configurationsNumber");
    var  cpuVendorsNumber = document.getElementById("cpuVendorsNumber");
    var  gpuVendorsNumber = document.getElementById("gpuVendorsNumber");
    var  psuVendorsNumber = document.getElementById("psuVendorsNumber");
    var  ramVendorsNumber = document.getElementById("ramVendorsNumber");
    var  ramVersionsNumber = document.getElementById("ramVersionsNumber");
    var  ramFreqsNumber = document.getElementById("ramFreqsNumber");
    var  motherboardVendorsNumber = document.getElementById("motherboardVendorsNumber");
    var  diskVendorsNumber = document.getElementById("diskVendorsNumber");
    var  socketsNumber = document.getElementById("socketsNumber");
    var  videoInterfacesNumber = document.getElementById("videoInterfacesNumber");
    var  diskInterfacesNumber = document.getElementById("diskInterfacesNumber");
    var  ordersNumber = document.getElementById("ordersNumber");

    var form = new FormData();
    form.append("cpusNumber",  cpusNumber.value);
    form.append("ramsNumber",  ramsNumber.value);
    form.append("gpusNumber",  gpusNumber.value);
    form.append("psusNumber",  psusNumber.value);
    form.append("disksNumber",  disksNumber.value);
    form.append("casesNumber",  casesNumber.value);
    form.append("motherboardsNumber",  motherboardsNumber.value);
    form.append("configurationsNumber",  configurationsNumber.value);
    form.append("cpuVendorsNumber",  cpuVendorsNumber.value);
    form.append("gpuVendorsNumber",  gpuVendorsNumber.value);
    form.append("psuVendorsNumber",  psuVendorsNumber.value);
    form.append("ramVendorsNumber",  ramVendorsNumber.value);
    form.append("ramVersionsNumber",  ramVersionsNumber.value);
    form.append("ramFreqsNumber",  ramFreqsNumber.value);
    form.append("motherboardVendorsNumber",  motherboardVendorsNumber.value);
    form.append("diskVendorsNumber",  diskVendorsNumber.value);
    form.append("socketsNumber",  socketsNumber.value);
    form.append("videoInterfacesNumber",   videoInterfacesNumber.value);
    form.append("diskInterfacesNumber",  diskInterfacesNumber.value);
    form.append("ordersNumber",  ordersNumber.value);
    post('POST', "/generator", form, empty());
}

function empty(){
}