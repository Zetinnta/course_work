package ru.skypro;

public class Main {

    public static void main(String[] args) {

        Employee[] fellowWorker = new Employee[10];

        fellowWorker[0] = new Employee("Sophia", "Prohorova", "Artemovna", 48_000, "1");
        fellowWorker[1] = new Employee("Egor", "Frolov", "Mihailovich", 42_000, "1");
        fellowWorker[2] = new Employee("Sergey", "Vasilyev", "Konstantinovich", 53_000, "2");
        fellowWorker[3] = new Employee("Alexander", "Belyaev", "Kirillovich", 46_000, "1");
        fellowWorker[4] = new Employee("Polina", "Makarova", "Maximovna", 56_000, "3");
        fellowWorker[5] = new Employee("Alena", "Minaeva", "Antonovna", 45_000, "3");
        fellowWorker[6] = new Employee("Mihail", "Borisov", "Georgievich", 52_000, "3");
        fellowWorker[7] = new Employee("Artem", "Novikov", "Lvovich", 56_000, "2");
        fellowWorker[8] = new Employee("Konstantin", "Belov", "Alexandrovich", 52_000, "2");
        fellowWorker[9] = new Employee("Valeria", "Petrova", "Andreevna", 50_000, "1");

        minimumSalary(fellowWorker);
        delimiter();
        maximumSalary(fellowWorker);
        delimiter();
        fellowWorker[0].toString();
        listOfEmployees(fellowWorker);
        delimiter();
        System.out.println("General payment per month: " + overallPayment(fellowWorker));
        delimiter();
        System.out.println("Average salary: " + overallPayment(fellowWorker) / fellowWorker.length);
        delimiter();
        System.out.println("List of employees:");
        fullNameOfEmployees(fellowWorker);
        delimiter();

    }

    public static void delimiter() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
    }

    public static void minimumSalary(Employee[] fellowWorker) {
        double minimum = fellowWorker[0].getEmployeeSalary();
        for (int i = 1; i < fellowWorker.length; i++) {
            if (fellowWorker[i].getEmployeeSalary() < minimum) {
                minimum = fellowWorker[i].getEmployeeSalary();
            }
        }
        System.out.println("Minimum salary: " + minimum);
    }

    public static void maximumSalary(Employee[] fellowWorker) {
        double maximum = fellowWorker[0].getEmployeeSalary();
        for (int i = 1; i < fellowWorker.length; i++) {
            if (fellowWorker[i].getEmployeeSalary() > maximum) {
                maximum = fellowWorker[i].getEmployeeSalary();
            }
        }
        System.out.println("Maximum salary: " + maximum);
    }

    public static void listOfEmployees(Employee[] fellowWorker) {
        for (Employee employee : fellowWorker) {
            System.out.println(employee.toString());
        }
    }

    public static double overallPayment(Employee[] fellowWorker) {
        double payment = 0;
        for (Employee employee : fellowWorker) {
            payment += employee.getEmployeeSalary();
        }
        return payment;
    }

    public static void fullNameOfEmployees(Employee[] fellowWorker) {
        int i = 1;
        for (Employee employee : fellowWorker) {
            if (i == fellowWorker.length) {
                System.out.println(i + ") " + employee.getEmployeeFullName() + ".");
                break;
            }
            System.out.println(i + ") " + employee.getEmployeeFullName() + ";");
            i++;
        }
    }
}


