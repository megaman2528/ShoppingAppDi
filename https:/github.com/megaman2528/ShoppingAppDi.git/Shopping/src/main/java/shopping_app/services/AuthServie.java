package shopping_app.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import shopping_app.domain.User;


import shopping_app.services.ResourcesService;
import static shopping_app.services.ResourcesService.Resource.CUSTOMER;
import static shopping_app.services.ResourcesService.Resource.ADMIN;

public class AuthServie {
	private static Scanner USERINPUT = new Scanner(System.in);
	
	 private final ResourcesService resourcesService;
	 
	 private String line;
	
	 public AuthServie(ResourcesService resourcesService) {
	        this.resourcesService = resourcesService;
	    }

	public boolean auth() {
		System.out.println("Welcome\n" + "Enter 1 to login as customer\n" + "Enter 2 to login as admin\n");
		int usertype = USERINPUT.nextInt();
		Scanner input = new Scanner(System.in);
		if (usertype == 1) {
			return auth(input, CUSTOMER);

		} else {
			return auth(input, ADMIN);
		}

	}

	private boolean auth(Scanner inputScanner, ResourcesService.Resource resource) {
        System.out.println("Please enter user name:");
        String username = inputScanner.nextLine();
        System.out.println("Please enter your password:");
        String userPass = inputScanner.nextLine();

        File adminTxt = resourcesService.getFileByResourceName(resource);

        try {
            List<User> store = readAuthentificationStore(inputScanner, adminTxt);

            inputScanner.close();

            if (store.contains(new User(username, userPass))) {
                System.out.println("You have logged in username " + username);
                return true;
            } else {
                System.out.println("authication error: check your user name and password");
                return false;
            }
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }

    private List<User> readAuthentificationStore(Scanner inputScanner, File admintxt) throws IOException {
        FileReader adminReader = new FileReader(admintxt);
        BufferedReader adminTxtReader = new BufferedReader(adminReader);
        List<User> dataStore = new ArrayList<User>();

        while ((line = adminTxtReader.readLine()) != null) {
            List<String> personInformation = Arrays.asList(line.split("\\s*,\\s*"));

            String username = personInformation.get(0);
            String password = personInformation.get(1);
            if (username != null && password != null)
                dataStore.add(new User(username, password));
        }

        adminTxtReader.close();
        inputScanner.close();
        return dataStore;
    }

}
