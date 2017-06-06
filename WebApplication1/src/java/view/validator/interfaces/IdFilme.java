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
import view.validator.impl.IdFilmeValidator;

/**
 *
 * @author joker
 */
@Constraint(validatedBy = IdFilmeValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface IdFilme {

    String message() default "Id ist bullshit";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
