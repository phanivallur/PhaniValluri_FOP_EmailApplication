package com.greatlearning.email.service;

import java.util.Random;

import com.greatlearning.email.model.Employee;

public class CredentialService  implements ICredentialService {
	private String upper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String lower=upper.toLowerCase();
	private String numbers="1234567890";
	private String splChars="!@#$%^&*()_+=";
	private String passwordChars=upper+lower+numbers+splChars;
	private Random random=new Random();

	@Override
	public void generateEmail(Employee employee) {
		// TODO Auto-generated method stub
		String emailAddress=employee.getFirstName()+employee.getLastName()+"@"+employee.getDepartment()+".gl.in";
		employee.setEmailAddress(emailAddress);
	}

	@Override
	public void generatePassword(Employee employee) {
		// TODO Auto-generated method stub
		String password="";
		for(int i=0;i<8;i++) {
			password+=passwordChars.charAt(random.nextInt(passwordChars.length()));
		}
		employee.setPassword(password);
	}

	@Override
	public void showCredentials(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("Dear "+employee.getFirstName()+ " your generated credentials are as follows :");
		System.out.println("Email\t\t"+ employee.getEmailAddress());
		System.out.println("Password\t\t"+employee.getPassword());
	}
}
