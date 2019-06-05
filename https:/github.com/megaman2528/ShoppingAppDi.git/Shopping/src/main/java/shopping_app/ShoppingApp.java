package shopping_app;

import shopping_app.domain.LoginDomain;
import shopping_app.services.AuthServie;
import shopping_app.services.ResourcesService;

/**
 * Hello world!
 *
 */
public class ShoppingApp 
{
	private static ResourcesService resourcesService = new ResourcesService();
	private static AuthServie authServie = new AuthServie(resourcesService);
	
    public static void main( String[] args )
    {
        LoginDomain login = new LoginDomain(authServie);
        login.firstinput();
    }
}
