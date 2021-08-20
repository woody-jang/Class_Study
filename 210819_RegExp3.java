import java.util.regex.Pattern;

public class Main8 {
	public static void main(String[] args) {
		String[] lines = {
				"key=value", "Tom:Hello", "QWER,ASDF", "7777-7777"
		};
		
		// 문자 3개 다음에 특수문자= 문자5개
		
		Pattern p = Pattern.compile("\\w{3}[=|-|~|:|,]\\w{5}");
		for (String str : lines) {
			if (p.matcher(str).matches()) {
				System.out.println(str);
			}
		}
	}
}
