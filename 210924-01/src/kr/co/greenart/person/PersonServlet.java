package kr.co.greenart.person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/person")
public class PersonServlet extends HttpServlet {
	// 사용자가 get 방식으로 요청한 form에서 입력한 파라미터를 post 방식으로 전송했을 때 처리
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("사용자가 get 방식으로 요청");
		req.getRequestDispatcher("/WEB-INF/form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자 요청 확인용 로그
		System.out.println("사용자가 post 방식으로 요청");
		// 입력 파라미터 인코딩 설정
		req.setCharacterEncoding("UTF-8");
		// 입력 파라미터 값 가지고 오기.
		String name = req.getParameter("name");
		String ageStr = req.getParameter("age");

		// 사용자 입력값 검증
		// 1. null or empty 체크
		// 2. 이름 값 유효성 확인. (공백 체크)
		// 3. 나이 값 유효성 확인. (음수 확인)
		// 유효하지 않을 때 에러 메세지 만들기.
		List<String> errorList = checkParams(name, ageStr);
		System.out.println("이름: " + name);
		System.out.println("나이: " + ageStr);

		if (errorList.size() > 0) {
			req.setAttribute("errorList", errorList);
			req.getRequestDispatcher("/WEB-INF/form.jsp").forward(req, resp);
		} else {
			// 나중에 여기서 저장할 예정
			PersonDAO dao = new PersonDAO();
			int age = Integer.parseInt(ageStr);
			dao.insert(name, age);
			resp.sendRedirect("/");
		}
	}

	private boolean nullOrEmptyOrHasWhiteSpace(String paramValue) {
		if (paramValue == null || paramValue.trim().length() == 0 || paramValue.trim().contains(" ")) {
			return true;
		}
		return false;
	}

	private boolean isMinus(int paramValue) {
		if (paramValue < 0) {
			return true;
		}
		return false;
	}

	private boolean isNumber(String paramValue) {
		try {
			Integer.parseInt(paramValue);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private List<String> checkParams(String paramName, String paramAge) {
		List<String> errorList = new ArrayList<>();
		if (nullOrEmptyOrHasWhiteSpace(paramName)) {
			errorList.add("이름에 공백을 넣지마세요");
		}
		if (nullOrEmptyOrHasWhiteSpace(paramAge)) {
			errorList.add("나이에 공백을 넣지마세요");
		} else {
			if (!isNumber(paramAge)) {
				errorList.add("나이에 숫자를 입력하세요");
			} else {
				int age = Integer.parseInt(paramAge);
				if (isMinus(age)) {
					errorList.add("나이에 음수를 입력하지마세요");
				}
			}
		}
		return errorList;
	}
}
