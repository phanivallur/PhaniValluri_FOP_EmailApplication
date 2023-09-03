package com.greatlearning.email.service;

import com.greatlearning.email.model.Employee;

public interface ICredentialService {
	public void generateEmail(Employee employee);
	public void generatePassword(Employee employee);
	public void showCredentials(Employee employee);
}
