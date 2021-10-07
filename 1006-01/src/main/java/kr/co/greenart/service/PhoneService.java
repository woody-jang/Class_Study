package kr.co.greenart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.greenart.model.Phone;
import kr.co.greenart.repository.IPhoneDAO;

@Service
public class PhoneService implements IPhoneService {
	@Autowired
	private IPhoneDAO dao;

	@Override
	public int add(Phone p) {
		return dao.add(p);
	}

	@Override
	public List<Phone> getAll() {
		return dao.getAll();
	}
}
