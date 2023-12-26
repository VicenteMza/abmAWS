function deleteUser(id, name,lastName){
    var confirmDelete = confirm(`Estas seguro que quieres eliminar a ${name} ${lastName} ?`);
    if (!confirmDelete){
        return;
    }

    fetch(`http://localhost:8080/api/users/${id}`, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.ok) {
               alert(`El usuario ${name} ${lastName} fue eliminado exitosamente`);
        } else {
                alert('No se pudo eliminar el usuario. Inténtalo de nuevo.');
        }
    })
    .catch(error => console.error('Error al eliminar usuario:', error));
}