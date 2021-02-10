package command.Implementatiion.Account;

import entities.Account;
import entities.enums.UserType;

import javax.servlet.http.HttpServletRequest;


public class accFetcher {
    public Account fetchAcc(HttpServletRequest request){
         Account account=new Account();
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String usertype = request.getParameter("user_type");
        if (usertype.equals("client"))
            account.setUserType(UserType.CLIENT);
        else if (usertype.equals("taxi"))
            account.setUserType(UserType.TAXI);
        else if(usertype.equals("admin"))
            account.setUserType(UserType.ADMIN);
        account.setFirstName(firstname);
        account.setLastName(lastname);
        account.setUserName(username);
        account.setPassword(password);
        account.setEmail(email);
       return account;
    }
}
