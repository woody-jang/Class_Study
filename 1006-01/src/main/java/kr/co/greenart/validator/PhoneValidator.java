package kr.co.greenart.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.co.greenart.model.Phone;

@Component
public class PhoneValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Phone.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (target == null) {
			errors.reject("phone.null", "입력 정보가 없습니다");
		}

		Phone p = (Phone) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "model", "model.empty", "모델명이 필요합니다");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "production", "production.empty", "제조사가 필요합니다");

		if (isMinus(p.getAmount())) {
			errors.rejectValue("amount", "amount.minus", "수량은 음수가 될 수 없습니다");
		}
		if (isMinus(p.getPrice())) {
			errors.rejectValue("price", "price.minus", "가격은 음수가 될 수 없습니다");
		}
	}

	private boolean isMinus(int number) {
		if (number < 0) {
			return true;
		}
		return false;
	}
}
