package Ex2_Methods.Problem7_ImmutableList;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Niki on 22.6.2016 г..
 */


public class ImmutableList1 {

    public static void main(String[] args) {
        Field[] fields = ImmutableList.class.getDeclaredFields();
        if (fields.length < 1) {
        }

        java.lang.reflect.Method[] methods = ImmutableList.class.getDeclaredMethods();
        List<Method> methodsReturnTypes = Arrays.stream(methods).filter(m -> {
            if (!m.getReturnType().getName().equalsIgnoreCase("ImmutableList")) {
                return false;
            }

            return true;
        }).collect(Collectors.toList());

        if (methodsReturnTypes.size() < 1) {
        }

    }
}
