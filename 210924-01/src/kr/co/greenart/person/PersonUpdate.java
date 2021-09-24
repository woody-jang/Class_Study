package kr.co.greenart.person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/personUpdate")
public class PersonUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		List<String> errorList = checkParams(name, ageStr);

		if (errorList.size() > 0) {
			request.setAttribute("errorList", errorList);
			request.getRequestDispatcher("/personUpdate").forward(request, response);
		} else {
			PersonDAO dao = new PersonDAO();
			int age = Integer.parseInt(ageStr);
			dao.update(id, name, age);
			response.sendRedirect("/personList");
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
