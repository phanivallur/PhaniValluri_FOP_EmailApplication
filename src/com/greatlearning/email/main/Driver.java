package com.greatlearning.email.main;

import com.greatlearning.email.service.ICredentialService;
import java.util.Scanner;
import com.greatlearning.email.model.Employee;
import com.greatlearning.email.service.CredentialService;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ICredentialService service=new CredentialService();
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter the employee first name :");
			String firstName=scanner.nextLine();
			
			System.out.print("Enter the employee last name :");
			String lastName=scanner.nextLine();
			
			Employee employee=new Employee(firstName, lastName);
			
			System.out.println("Please select the employee department option");
			System.out.println("1. Technical");
			System.out.println("2. Admin");
			System.out.println("3. Human Resource");
			System.out.println("4. Legal");
			
			int option=scanner.nextInt();
			switch(option) {
			case 1:
				employee.setDepartment("tech");
				break;
			case 2:
				employee.setDepartment("adm");
				break;
			case 3:
				employee.setDepartment("hr");
				break;
			case 4:
				employee.setDepartment("legal");
				break;
			default:
				System.out.println("Please select valid option");
				break;
			}
			
			if(employee.getFirstName() != null && employee.getLastName()!=null && employee.getDepartment()!=null) {
				service.generateEmail(employee);
				service.generatePassword(employee);
				service.showCredentials(employee);
			} else {
				System.out.println("Invalid employee");
			}
		}
	}
}
