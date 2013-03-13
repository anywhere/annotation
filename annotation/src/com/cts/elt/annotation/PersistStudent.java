package com.cts.elt.annotation;

import java.lang.reflect.Method;

public class PersistStudent {
    
    public static void main(String[] args) throws Exception {
        Object c = Class.forName("com.cts.elt.annotation.Student").newInstance();
        try {
            Method[] methods = c.getClass().getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].isAnnotationPresent(ValueBind.class)) {
                    ValueBind annotation = methods[i].getAnnotation(ValueBind.class);
                    String type = String.valueOf(annotation.type());
                    String value = annotation.value();
                    if (type.equals("INT")) {
                        methods[i].invoke(c, new Object[] { new Integer(value) });
                    } else {
                        methods[i].invoke(c, new Object[] { value });
                    }
                }
            }
            Student student = (Student) c;
            System.out.println("studentId====" + student.getStudentId() + "  studentnName====" + student.getName()
                    + "   student Age====" + student.getAge());
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}