package p11;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {

	public static void main(String[] args) {
		Class clazz = User1.class;
		Method[] m = clazz.getMethods();
		for(Method m1:m){
			System.out.println(m1);
		}
		Field[] f = clazz.getDeclaredFields();
		for(Field f1:f)
			System.out.println(f1);

	}

}
