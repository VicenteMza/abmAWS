window.onload = function () {
    fillProfessionOptions();
};

function fillProfessionOptions() {
    var professionSelect = document.getElementById('profession');

    // Realiza una solicitud para obtener las opciones de profesión
    fetch('http://localhost:8080/api/users/profession')
        .then(response => response.json())
        .then(data => {
            // Llena el menú desplegable con las opciones obtenidas
            data.forEach(description => {
                var optionElement = document.createElement('option');
                optionElement.value = description;
                optionElement.text = description;
                professionSelect.appendChild(optionElement);
            });
        })
        .catch(error => console.error('Error al obtener las opciones de profesión:', error));
}