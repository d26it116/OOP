import java.lang.reflect.Method;

public class MiniTestRunner {

    public static void runTests(Object object) {

        int count = 0;

        Method[] methods = object.getClass().getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(Run.class)) {

                try {
                    method.invoke(object);
                    count++;
                } catch (Exception e) {
                    System.out.println("Error running: "
                            + method.getName());
                }
            }
        }

        System.out.println("Total tests ran: " + count);
    }
}