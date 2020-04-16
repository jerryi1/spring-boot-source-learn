package com.lhq.boot.demo.databind_validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * 复杂的validator
 * 集成单个校验
 */
public class ComplexValidator implements Validator {

    @Autowired
    private PersonValidator personValidator;

    ComplexValidator(PersonValidator personValidator) {
        if (personValidator == null) {
            throw new IllegalArgumentException("The supplied [Validator] is " +
                    "required and must not be null.");
        }

        if (!personValidator.supports(House.class)){
            throw new IllegalArgumentException("The supplied [Validator] must " +
                    "support the validation of [Address] instances.");
        }
        this.personValidator = personValidator;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return House.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        House house = (House) target;
        if (StringUtils.isEmpty(house.getStyle())) {
            errors.rejectValue("style", "no style is bad");
        }
        //利用ValidationUtils校验内部对象
        ValidationUtils.invokeValidator(this.personValidator, house.getPerson(), errors);
    }
}
