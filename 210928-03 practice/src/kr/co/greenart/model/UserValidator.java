package kr.co.greenart.model;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {
	public List<String> checkUserName(String userName) {
		List<String> errors = new ArrayList<>();
		if (userName == null || userName.trim().length() == 0) {
			errors.add("닉네임을 입력해주세요.");
		}
		if (userName.contains(" ")) {
			errors.add("닉네임은 공백을 사용할 수 없습니다.");
		}
		if (!isLowerChars(userName)) {
			errors.add("닉네임은 영소문자만 가능합니다.");
		}
		if (userName.length() > 45) {
			errors.add("닉네임은 45자 제한입니다.");
		}
		return errors;
	}
	
	private boolean isLowerChars(String input) {
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c < 'a' || c > 'z') {
				return false;
			}
		}
		return true;
	}
}
