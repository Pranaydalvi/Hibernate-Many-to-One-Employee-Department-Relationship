# Hibernate Many-to-One Employee-Department Relationship

This project demonstrates a basic many-to-one relationship between `Employee` and `Department` entities using Hibernate. It includes various functionalities such as adding, viewing, updating, and deleting employees and departments, as well as listing and searching employees.

## Features

- Add Employee and Department
- View Employee and Department Details
- Update Employee and Department Information
- Delete Employee and Department Records
- List All Employees and Departments
- Search Employees by Name

## Technologies Used

- Java
- Hibernate ORM
- MySQL

## Project Structure

- `com.util`: Contains the Hibernate utility class for session management.
- `com.model`: Contains the entity classes `Employee` and `Department`.
- `com.service`: Contains the service interface and implementation for the business logic.
- `com.controller`: Contains the main controller class to interact with the user.

## Entity Relationship

- **Employee**: Represents an employee with a many-to-one relationship to the `Department`.
- **Department**: Represents a department which can have multiple employees.

## How to Run

1. **Clone the repository**:
   git clone https://github.com/yourusername/HibernateManyToOneEmployeeDepartment.git

2. **Create MySQL Database**:
  CREATE DATABASE employeedb;

3. **Configure hibernate.cfg.xml**:
  -Update the MySQL username and password.
  -Set the database URL.

4. **Run the Application**:

  Use your IDE to run the com.controller.Controller class.

## Usage

1. **Adding a Department**:
   - Select the option to add a department.
   - Enter the department details such as department name and location.

2. **Adding an Employee**:
   - Select the option to add an employee.
   - Enter the employee details such as name, email, and salary.
   - Choose the department to which the employee belongs.

3. **Viewing Details**:
   - Select the option to view employee or department details.
   - Enter the ID of the employee or department to fetch the details.

4. **Updating Details**:
   - Select the option to update employee or department information.
   - Enter the ID of the employee or department.
   - Enter the new details to update the records.

5. **Deleting Records**:
   - Select the option to delete an employee or department.
   - Enter the ID of the employee or department to delete the record.

6. **Listing All**:
   - Select the option to list all employees or departments.
   - View the list of all employees and departments in the system.

7. **Searching Employees**:
   - Select the option to search employees by name.
   - Enter the employee name to search and view the matching results.
