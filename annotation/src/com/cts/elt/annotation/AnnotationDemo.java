package com.cts.elt.annotation;

@MyAnnotation1("this isannotation1")
public class AnnotationDemo {
    
    @MyAnnotation2(description = "this is annotation2", isAnnotation = true)
    public void sayHello() {
        System.out.println("hello world!");
    }
}
