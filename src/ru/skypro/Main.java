package ru.skypro;

public class Main {

    public static void main(String[] args) {

        Employee[] fellowWorker = new Employee[10];

        fellowWorker[0] = new Employee("Sophia", "Prohorova", "Artemovna", 48_000, "5");
        fellowWorker[1] = new Employee("Egor", "Frolov", "Mihailovich", 42_000, "1");
        fellowWorker[2] = new Employee("Sergey", "Vasilyev", "Konstantinovich", 53_000, "2");
        fellowWorker[3] = new Employee("Alexander", "Belyaev", "Kirillovich", 46_000, "3");
        fellowWorker[4] = new Employee("Polina", "Makarova", "Maximovna", 56_000, "4");
        fellowWorker[5] = new Employee("Alena", "Minaeva", "Antonovna", 45_000, "2");
        fellowWorker[6] = new Employee("Mihail", "Borisov", "Georgievich", 52_000, "3");
        fellowWorker[7] = new Employee("Artem", "Novikov", "Lvovich", 56_000, "5");
        fellowWorker[8] = new Employee("Konstantin", "Belov", "Alexandrovich", 52_000, "4");
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
        salaryIndexation(fellowWorker, 0.05);
        delimiter();
        highestAndLowestSalary(fellowWorker);
        delimiter();
        overallPaymentWithinADepartment(fellowWorker);
        delimiter();
        averagePaymentWithinADepartment(fellowWorker);
        delimiter();
        salaryIndexationWithinADepartment(fellowWorker, 2, 0.5); // (массив, отдел, индексация)
        highestAndLowestSalary(fellowWorker);
        delimiter();
        fullInformationAboutEmployeesForASpecificDepartment(fellowWorker, 2);
        delimiter();
        getListOfEmployeesWhichSalaryIsLess(fellowWorker, 100_000);

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

    public static void salaryIndexation(Employee[] fellowWorker, double indexation) {
        for (Employee employee : fellowWorker) {
            employee.setEmployeeSalary(employee.getEmployeeSalary() * (1 + indexation));
            System.out.println(employee.toString() + " (assuming there was an indexation)");
        }
    }

    public static void highestAndLowestSalary(Employee[] fellowWorker) {
        for (int i = 1; i <= 5; i++) {
            double max = 0;
            double min = 1_000_000;
            for (Employee employee : fellowWorker) {
                if (employee.getEmployeeDepartment().equals(String.valueOf(i)) && employee.getEmployeeSalary() > max) {
                    max = employee.getEmployeeSalary();
                }
                if (employee.getEmployeeDepartment().equals(String.valueOf(i)) && employee.getEmployeeSalary() < min) {
                    min = employee.getEmployeeSalary();
                }
            }
            System.out.println("The highest wage for the department " + "'" + i + "'" + " is: " + max + " (after indexation)");
            System.out.println("The lowest wage for the department " + "'" + i + "'" + " is: " + min + " (after indexation)");
        }
    }

    public static void overallPaymentWithinADepartment(Employee[] fellowWorker) {
        for (int i = 1; i <= 5; i++) {
            double payment = 0;
            for (Employee employee : fellowWorker) {
                if (employee.getEmployeeDepartment().equals(String.valueOf(i))) {
                    payment += employee.getEmployeeSalary();
                }
            }
            System.out.println("Total payment per month for the department " + "'" + i + "'" + " is " + payment + " (after indexation)");
        }
    }

    public static void averagePaymentWithinADepartment(Employee[] fellowWorker) {
        for (int i = 1; i <= 5; i++) {
            int count = 0;
            double payment = 0;
            for (Employee employee : fellowWorker) {
                if (employee.getEmployeeDepartment().equals(String.valueOf(i))) {
                    payment += employee.getEmployeeSalary();
                    count++;
                }
            }
            System.out.println("Average payment per month for the department " + "'" + i + "'" + " is " + payment/count + " (average indexation)");
        }
    }

    public static void salaryIndexationWithinADepartment(Employee[] fellowWorker,int i, double indexation) {
        for (Employee employee : fellowWorker) {
            if (employee.getEmployeeDepartment().equals(String.valueOf(i))) {
                employee.setEmployeeSalary(employee.getEmployeeSalary() * (1 + indexation));
            }
        }
    }

    public static void fullInformationAboutEmployeesForASpecificDepartment(Employee[] fellowWorker, int i) {
        System.out.println("Department " + "'" + i + "':");
        for (Employee employee : fellowWorker) {
            if (employee.getEmployeeDepartment().equals(String.valueOf(i))) {
              System.out.println("Full name: " + employee.getEmployeeFullName() +  ", currently works with a salary of " + employee.getEmployeeSalary() + ";");
            }
        }
    }

    public static void getListOfEmployeesWhichSalaryIsLess(Employee[] fellowWorker, int gap) {
        System.out.println("The list of employees with a salary less than " + gap + " are:");
        for (Employee employee : fellowWorker) {
            if (employee.getEmployeeSalary() < gap) {
                System.out.println("ID " + employee.getEmployeeId() + ": " + employee.getEmployeeFullName() + ", " + employee.getEmployeeSalary());
            }
        }
    }
}






