
package login;
import user.Users;

/**
 *
 * @author brixa
 */
public class AccountServices {
    
    
    public Users login (String username, String password){
    
        
        if(username.equals("adam") || username.equals("betty") && password.equals("password")){
            return new Users(username,null);
        }
        return null;
            
           
    }
    
}
