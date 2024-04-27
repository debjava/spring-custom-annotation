package com.ddlab.rnd.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, PARAMETER })
@Constraint(validatedBy = CashValidator.class)
public @interface CashValidation {
	// Default error message
	public String message() default "Cash deposit amount can't be greater than defined value";

	public int value(); // Specific to application

	// represents group of constraints
	public Class<?>[] groups() default {}; // Mandatory


	// represents additional information about annotation
	public Class<? extends Payload>[] payload() default {}; // Mandatory
//	public Class<?>[] payload() default {}; // Mandatory, it can be written
}
