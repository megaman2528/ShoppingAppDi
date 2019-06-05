package shopping_app.domain;

import java.util.Scanner;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import shopping_app.services.AuthServie;;
@Data
@AllArgsConstructor
@EqualsAndHashCode

public class LoginDomain {
	private static Scanner USERINPUT = new Scanner(System.in);
	
	private String user_login;
	private String user_register;

	private AuthServie authServie;
	
	public LoginDomain(AuthServie authServie) {
		this.authServie = authServie;
		
	}

	public void firstinput() {
		
	System.out.println("Do you want to login?");
	setUser_login(USERINPUT.nextLine());
	System.out.println("Do you wan to Register?");
	setUser_register(USERINPUT.nextLine());
	}
	public void login( ) {
		if(getUser_login().equals("yes")) {
			 authServie.auth();
			
		}else {
			System.out.println("Have a nice day!come back again");
			
		}
		
		

}
	
	
}