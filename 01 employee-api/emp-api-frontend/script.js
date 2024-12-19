const apiUrl = 'http://localhost:8080/api/employees';

// Fetch and display employees using axios from server which url is defined
const fetchEmployees = async () => {
    try {
        const response = await axios.get(apiUrl);
        const employees = response.data;
        const tableBody = document.querySelector("#employeeTable tbody");
        tableBody.innerHTML = "";
        employees.forEach(employee => {
            const row = `
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.salary}</td>
                    <td>${employee.department}</td>
                    <td>${employee.dateOfJoin}</td>
                    <td>
                        <button onclick="deleteEmployee(${employee.id})">Delete</button>
                    </td>
                </tr>
            `;
            tableBody.innerHTML += row;
        });
    } catch (error) {
        console.error("Error fetching employees:", error);
    }
};

//This code block will Add new employee to database
document.getElementById("employeeForm").addEventListener("submit", async (e) => {
    e.preventDefault();
    const employee = {
        name: document.getElementById("name").value,
        salary: document.getElementById("salary").value,
        department: document.getElementById("department").value,
        dateOfJoin: document.getElementById("dateOfJoin").value,
    };

    try {
        await axios.post(apiUrl, employee);
        fetchEmployees();

    } catch (error) {
        console.error("Error adding employee:", error);
    }
});

//this code block is used for deleting employee by its id
const deleteEmployee = async (id) => {
    try {
        await axios.delete(`${apiUrl}/${id}`);
        fetchEmployees();
    } catch (error) {
        console.error("Error deleting employee:", error);
    }
};

// Initial fetch
fetchEmployees();
