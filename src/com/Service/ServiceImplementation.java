package com.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Model.Department;
import com.Model.Employee;
import com.Util.hibernateUtil;

public class ServiceImplementation implements ServiceInterface {

    SessionFactory sf = hibernateUtil.getConnection();
    Scanner sc = new Scanner(System.in);
    Session s = sf.openSession();

    @Override
    public void addEmployeeWithDepartment() {
        Session s = sf.openSession();
        Transaction tx = null;

        try {
            System.out.println("Enter the Department Name: ");
            Department dept = new Department();
            dept.setDeptName(sc.next());

            System.out.println("How many employees does this department have?");
            int numEmployees = sc.nextInt();

            for (int i = 1; i <= numEmployees; i++) {
                Employee emp = new Employee();
                System.out.println("Enter details for Employee " + i);
                System.out.println("Enter the Employee Name: ");
                emp.setEmpName(sc.next());
                emp.setDepartment(dept);
                dept.getEmployees().add(emp);
            }

            tx = s.beginTransaction();
            s.save(dept);
            tx.commit();
            System.out.println("Department and employees added successfully!");
        } catch (InputMismatchException e) {
            if (tx != null) tx.rollback();
            System.out.println("Invalid input. Please enter correct values.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void getEmployeeAndDepartmentDetails() {
        Session s = sf.openSession();

        try {
            System.out.println("Enter the Employee ID: ");
            int id = sc.nextInt();
            Employee emp = s.get(Employee.class, id);
            if (emp != null) {
                System.out.println("---------------------------------------------------------");
                System.out.println("--------------Employee With Department Details----------------");
                System.out.println("Employee Name: " + emp.getEmpName());
                System.out.println("Department Name: " + emp.getDepartment().getDeptName());
                System.out.println("---------------------------------------------------------");
            } else {
                System.out.println("Invalid ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getDepartmentDetails() {
        Session s = sf.openSession();

        try {
            System.out.println("Enter the Department ID: ");
            int id = sc.nextInt();
            Department dept = s.get(Department.class, id);
            if (dept != null) {
                System.out.println("---------------------------------------------------------");
                System.out.println("--------------Department Details----------------------");
                System.out.println("Department Name: " + dept.getDeptName());
                System.out.println("Employees: " + dept.getEmployees());
                System.out.println("---------------------------------------------------------");
            } else {
                System.out.println("Invalid ID");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type. Please enter a valid number.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployeeAndDepartmentDetails() {
        Session s = sf.openSession();
        Transaction tx = null;

        try {
            System.out.println("Enter the Employee ID: ");
            int id = sc.nextInt();
            Employee emp = s.get(Employee.class, id);
            if (emp != null) {
                System.out.println("Enter new Employee Name (current: " + emp.getEmpName() + "): ");
                emp.setEmpName(sc.next());

                Department dept = emp.getDepartment();
                System.out.println("Enter new Department Name (current: " + dept.getDeptName() + "): ");
                dept.setDeptName(sc.next());

                tx = s.beginTransaction();
                s.saveOrUpdate(emp);
                s.saveOrUpdate(dept);
                tx.commit();
                System.out.println("Employee and department details updated successfully!");
            } else {
                System.out.println("Invalid ID");
            }
        } catch (InputMismatchException e) {
            if (tx != null) tx.rollback();
            System.out.println("Invalid input type. Please enter a valid number.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployeeWithDepartment() {
        Session s = sf.openSession();
        Transaction tx = null;

        try {
            System.out.println("Enter the Employee ID: ");
            int id = sc.nextInt();
            Employee emp = s.get(Employee.class, id);
            if (emp != null) {
                tx = s.beginTransaction();
                s.delete(emp);
                tx.commit();
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Invalid ID");
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void listAllEmployeesAndDepartments() {
        Session s = sf.openSession();

        try {
            List<Employee> employees = s.createQuery("from Employee", Employee.class).list();
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchEmployeeByName() {
        Session s = sf.openSession();

        try {
            System.out.println("Enter the Employee Name: ");
            String name = sc.next();
            List<Employee> employees = s.createQuery("from Employee where empName like :name", Employee.class)
                    .setParameter("name", "%" + name + "%").list();
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDepartmentDetails() {
        Session s = sf.openSession();
        Transaction tx = null;

        try {
            System.out.println("Enter the Department ID: ");
            int id = sc.nextInt();
            Department dept = s.get(Department.class, id);
            if (dept != null) {
                System.out.println("Enter new Department Name (current: " + dept.getDeptName() + "): ");
                dept.setDeptName(sc.next());

                tx = s.beginTransaction();
                s.saveOrUpdate(dept);
                tx.commit();
                System.out.println("Department details updated successfully!");
            } else {
                System.out.println("Invalid ID");
            }
        } catch (InputMismatchException e) {
            if (tx != null) tx.rollback();
            System.out.println("Invalid input type. Please enter a valid number.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
