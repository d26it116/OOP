package Form_Validator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        SignupForm form = new SignupForm(
                "",
                "verylongemailaddress@gmail.com",
                "password123"
        );

        List<String> errors = Validator.validate(form);

        if (errors.isEmpty()) {
            System.out.println("Form is valid");
        } else {
            System.out.println("Validation Errors:");

            for (String error : errors) {
                System.out.println(error);
            }
        }
    }
}