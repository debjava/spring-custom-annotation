package com.ddlab.rnd.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CashValidator implements ConstraintValidator<CashValidation, Integer> {

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		boolean flag = true;
		if (value > 50000) {
			flag = false;
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(value+" greater than 50K")
					.addConstraintViolation();
		}
		return flag;
	}

}
