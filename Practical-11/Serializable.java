import java.io.*;

public class Serializable implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int rollNumber;
    private transient String password;

    public Serializable(String name, int rollNumber, String password) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.password = password;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Create objects to save.
        Serializable[] students = {
            new Serializable("Amit", 101, "secret1"),
            new Serializable("Neha", 102, "secret2")
        };
         System.out.println("Values before loading:");
        for (Serializable student : students) {
            System.out.println(student.name + ", Roll No: " + student.rollNumber
                    + ", Password: " + student.password);
        }

        File file = new File("students.ser");

        // Save the array to a file.
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
            output.writeObject(students);
        }

        // Read the array into fresh objects.
        Serializable[] loadedStudents;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
            loadedStudents = (Serializable[]) input.readObject();
        }

        System.out.println("Values after loading:");
        for (Serializable student : loadedStudents) {
            System.out.println(student.name + ", Roll No: " + student.rollNumber
                    + ", Password: " + student.password);
        }

        System.out.println("\nThe transient password is not saved and becomes null.");
    }
}
