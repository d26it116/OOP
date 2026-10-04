abstract class Employee{
    String name;
    int EmployeeId;

    Employee(String name , int EmployeeId){
        this.EmployeeId = EmployeeId;
        this.name = name;
    }

    void Display(){
        System.out.println("Name = "+this.name);
        System.out.println("Employee Id = "+this.EmployeeId);
    }
    abstract void calculateSalary();

}

class PermanentEmployee extends Employee{

    public PermanentEmployee(String name , int EmployeeId) {
        super(name,EmployeeId);
    }

    void calculateSalary(){
        System.out.println("Permanent employee salary: ₹50000");
    } 
    
}

class ContractEmployee extends Employee{

    public ContractEmployee(String name , int EmployeeId) {
        super(name,EmployeeId);
    }

    void calculateSalary(){
        System.out.println("Permanent employee salary: ₹12000");
    } 
    
}

public class Abstract{
    public static void main(String args[]){
        Employee emp1 = new PermanentEmployee("Aaryan",123);
        emp1.calculateSalary();

        Employee emp2 = new ContractEmployee("Aaryan",123);
        emp2.calculateSalary();
    }
}




// abstract class Vehicle{
//     String Brand;
//     int RegistrationNumber;

//     Vehicle(String Brand, int RegistrationNumber){
//         this.Brand = Brand;
//         this.RegistrationNumber = RegistrationNumber;
//     }

//     void displayVehicleDetails() {
//         System.out.println("Brand: " + Brand);
//         System.out.println("Registration Number: " + RegistrationNumber);
//     }   

//     abstract void Calculatemileage();
// }

// class Car extends Vehicle{
//     Car(String Brand, int RegistrationNumber) {
//         super(Brand, RegistrationNumber);
//     }
//     @Override
//     void Calculatemileage() {
//         System.out.println("Mileage of Car: 15 km/l");
//     }

// }

// class Bike extends Vehicle{
//     Bike(String Brand, int RegistrationNumber) {
//         super(Brand, RegistrationNumber);
//     }
//     @Override
//     void Calculatemileage() {
//         System.out.println("Mileage of Bike: 40 km/l");
//     }

// }

// public class Abstract{
//     public static void main(String args[]){
//         Vehicle car = new Car("Toyota", 12345);
//         car.displayVehicleDetails();
//         car.Calculatemileage();

//         Vehicle bike = new Bike("Honda", 67890);
//         bike.displayVehicleDetails();   
//         bike.Calculatemileage();
//     }
// }



