package kr.co.greenart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import kr.co.greenart.model.Phone;
import kr.co.greenart.service.PhoneService;
import kr.co.greenart.validator.PhoneValidator;

@Controller
@RequestMapping("/phone")
public class PhoneController {
	private Logger logger = LoggerFactory.getLogger(PhoneController.class);
	@Autowired
	private PhoneService service;
	@Autowired
	private PhoneValidator validator;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(validator);
	}

	@ModelAttribute
	public Phone phone() {
		Phone p = new Phone();
		p.setModel("기본 모델");
		p.setProduction("기본 제조사");
		return p;
	}

	@GetMapping(value = "/form")
	public String form() {
		return "form";
	}

	@PostMapping("/form")
	public String add(@ModelAttribute @Valid Phone phone, BindingResult result) {
		logger.info(phone.toString());
		if (result.hasErrors()) {
			return "form";
		}

		service.add(phone);

		return "redirect:/";
	}

	@GetMapping(value = "/list")
	public String list(Model model) {
		List<Phone> list = service.getAll();
		model.addAttribute("list", list);
		return "list";
	}
}
