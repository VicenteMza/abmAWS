document.addEventListener("DOMContentLoaded", function(){
    loadUsers();
});

function loadUsers(){
    fetch('http://localhost:8080/api/users')
    .then(response => {
        if(!response.ok){
            throw new Error(`Error= ${response.status}`);
        }
        return response.json();
    })
    .then(users => {
        if (!Array.isArray(users)) {
            throw new Error('Invalid response format. Expected an array.');
        }
        console.log(users);
        const tableBody = document.getElementById('userTableBody');
        tableBody.innerHTML= '';

        users.forEach(user => {
            const row = createRow(user);
            tableBody.appendChild(row);
            
        });
    })
    .catch(error => console.error('Error al recuperar usuarios:' + error))
}
function createRow(user){
    const row = document.createElement('tr');
    row.innerHTML= `
    <td>${user.id}</td>
    <td>${user.name}</td>
    <td>${user.lastName}</td>
    <td>${user.dni}</td>
    <td>${user.birthdate}</td>
    <td>${user.profession}</td>
    <td>
        <button onclick="editUser(${user.id})">Edit</button>
        <button onclick="deleteUser(${user.id})">Delete</button>
    </td>
`;
return row;
}