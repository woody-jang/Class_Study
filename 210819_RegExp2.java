import java.util.regex.Pattern;

public class Main7 {
	public static void main(String[] args) {
		String[] lines = {
				"000000-1000000", "123456-1234567", "444-5555", "2020-20202020"
		};
		
		// 문자열중에서
		// 숫자6자리-숫자7자리 (두번째 숫자는 시작하는 숫자가 1,2,3,4여야함)
		// 올바른 입력값을 찾아보세요
		Pattern p = Pattern.compile("\\d{6}-[1-4]\\d{6}");
		for (String str : lines) {
			if (p.matcher(str).matches()) {
				System.out.println("올바른 숫자 : " + str);
			}
		}
	}
}
