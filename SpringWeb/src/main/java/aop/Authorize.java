package aop;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD}) 
@Retention //어느범위에서유지할지?
(value = RetentionPolicy.RUNTIME)
public @interface Authorize {

}