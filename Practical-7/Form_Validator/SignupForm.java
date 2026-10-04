package Form_Validator;
public class SignupForm {

    @NotBlank
    @MaxLength(20)
    private String name;

    
    @NotBlank
    @MaxLength(50)
    private String email;

    @NotBlank
    @MaxLength(10)
    private String password;

    public SignupForm(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}