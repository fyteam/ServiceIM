package com.im.web.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Autowired
	private TestDao dao;

	public void save() {
		dao.save();
	}
}
