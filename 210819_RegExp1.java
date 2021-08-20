import java.util.Scanner;
import java.util.regex.Pattern;

public class Main10 {
	public static void main(String[] args) {
		// 사용자가 사용할 아이디를 콘솔창에 입력
		// 다음과 같은 제약사항을 지켰는지 확인해보세요

		// 아이디는 영소문자로 시작하고, 영소문자와 숫자만을 포함할 수 있음.
		// (특수문자 '_'와 '-'도 포함가능). 최소길이3, 최대길이 16

		Scanner sc = new Scanner(System.in);

		System.out.println("아이디 입력:");
		String inputID = sc.nextLine();

		Pattern idPattern = Pattern.compile("^[a-z][a-z0-9_-]{2,15}$");
		if (idPattern.matcher(inputID).matches()) {
			System.out.println("올바른 ID 입력함");
		} else {
			System.out.println("잘못 입력");
		}
	}
}
