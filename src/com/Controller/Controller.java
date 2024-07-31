package com.Controller;

import java.util.Scanner;

import com.Service.ServiceImplementation;
import com.Service.ServiceInterface;

public class Controller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ServiceInterface service = new ServiceImplementation();

        while (true) {
            System.out.println("---------------------------------------------------------");
            System.out.println("1. Add Employee with Department");
            System.out.println("2. Get Employee and Department Details");
            System.out.println("3. Get Department Details");
            System.out.println("4. Update Employee and Department Details");
            System.out.println("5. Delete Employee with Department");
            System.out.println("6. List All Employees and Departments");
            System.out.println("7. Search Employee by Name");
            System.out.println("8. Update Department Details");
            System.out.println("9. Exit");
            System.out.println("---------------------------------------------------------");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    service.addEmployeeWithDepartment();
                    break;
                case 2:
                    service.getEmployeeAndDepartmentDetails();
                    break;
                case 3:
                    service.getDepartmentDetails();
                    break;
                case 4:
                    service.updateEmployeeAndDepartmentDetails();
                    break;
                case 5:
                    service.deleteEmployeeWithDepartment();
                    break;
                case 6:
                    service.listAllEmployeesAndDepartments();
                    break;
                case 7:
                    service.searchEmployeeByName();
                    break;
                case 8:
                    service.updateDepartmentDetails();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please enter a valid option.");
            }
        }
    }
}
