function submitForm(event) {
    // Prevenir el comportamiento de envío de formulario predeterminado
    event.preventDefault();

    var form = document.getElementById("userForm");
    var formData = new FormData(form);

    // Enviar datos al servidor de validación
    fetch('http://localhost:8081/api/validation/user', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            name: formData.get('name'),
            lastName: formData.get('lastName'),
            dni: formData.get('dni'),
            birthday: formData.get('birthday'),
            profession: formData.get('profession')
        })
    })
    .then(response => {
        if (response.ok) {
            // Si la validación es exitosa, enviar datos al servidor CRUD
            sendToCRUD(formData);
        } else {
            console.error('Error en la validación del usuario');
            alert('La carga del usuario falló. Revisa los datos ingresados');
        }
    })
    .catch(error => console.error('Error en la solicitud al servidor de validación:', error));

    // Evitar que el formulario se envíe de forma tradicional
    return false;
}

function sendToCRUD(formData) {
    // Enviar datos al servidor CRUD
    fetch('http://localhost:8080/api/users', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            name: formData.get('name'),
            lastName: formData.get('lastName'),
            dni: formData.get('dni'),
            birthday: formData.get('birthday'),
            profession: formData.get('profession')
        })
    })
    .then(response => {
        if (response.ok) {
            console.log('Usuario creado exitosamente');
            window.location.href = 'http://localhost:8082'
            // Puedes redirigir a otra página o realizar otras acciones
        } else {
            console.error('Error al crear usuario en el servidor CRUD');
        }
    })
    .catch(error => console.error('Error en la solicitud al servidor CRUD:', error));
}
