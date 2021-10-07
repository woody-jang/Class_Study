package kr.co.greenart.repository;

import java.util.List;

import kr.co.greenart.model.Phone;

public interface IPhoneDAO {
	int add(Phone p);

	List<Phone> getAll();
}
