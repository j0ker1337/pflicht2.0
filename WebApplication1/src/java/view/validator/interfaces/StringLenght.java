/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.validator.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import view.validator.impl.StringLenghtValidator;

/**
 *
 * @author joker
 */
@Constraint(validatedBy = StringLenghtValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface StringLenght {

    String message() default "Bitte gib eine Zahl länger als 4 ein";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
