package Persistence;

import Config.ErrorHandling.UserInternalError;
import Models.Users.BaseUser;
import Service.Interfaces.IRegisterService;

import javax.management.Query;
import java.sql.ResultSet;

/**
 * CREATED BY mathias @ 18-11-2021 - 12:35
 **/
public class UserRegister {
    private final IRegisterService service;

    public UserRegister(IRegisterService service) {
        this.service = service;
    }


    public BaseUser register(String email, String password) throws Exception {
        return service.registerNewUser(email,password);
    }

}

