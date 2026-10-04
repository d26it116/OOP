package Form_Validator;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static List<String> validate(Object object) {

        List<String> errors = new ArrayList<>();

        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {

            field.setAccessible(true);

            try {
                Object value = field.get(object);

                // Check @NotBlank
                if (field.isAnnotationPresent(NotBlank.class)) {

                    if (value == null || value.toString().trim().isEmpty()) {
                        errors.add(field.getName() + " cannot be blank");
                    }
                }

                // Check @MaxLength
                if (field.isAnnotationPresent(MaxLength.class)) {

                    MaxLength annotation =
                            field.getAnnotation(MaxLength.class);

                    int maxLength = annotation.value();

                    if (value != null &&
                        value.toString().length() > maxLength) {

                        errors.add(field.getName()
                                + " must not exceed "
                                + maxLength
                                + " characters");
                    }
                }

            } catch (IllegalAccessException e) {
                errors.add("Cannot access field: " + field.getName());
            }
        }

        return errors;
    }
}