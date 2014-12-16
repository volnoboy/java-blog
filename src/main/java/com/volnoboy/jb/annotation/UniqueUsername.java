package com.volnoboy.jb.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by volnoboy on 12/16/14.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueUsernameValidator.class})
public @interface UniqueUsername {

	String message();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
