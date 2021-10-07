package kr.co.greenart.service;

import java.util.List;

import kr.co.greenart.model.Phone;

public interface IPhoneService {
	int add(Phone p);
	List<Phone> getAll();
}
