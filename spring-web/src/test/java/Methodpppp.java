import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class Methodpppp{
 public static void main(String[] args) throws Exception {
        
        Person person = new Person();
        Class c = person.getClass();
        
        //Class c2 = Class.forName("test.Person");
        //Person person2 = (Person)c2.newInstance();
        
        Method method = c.getDeclaredMethod("playGame");
        method.setAccessible(true);
        method.invoke(person);
        
        Field field = c.getDeclaredField("name");
        field.setAccessible(true);
        field.set(person,"John");
        method.invoke(person);
        
    }


}