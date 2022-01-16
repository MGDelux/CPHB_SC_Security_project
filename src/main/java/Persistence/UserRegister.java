package Persistence;

import Models.Users.BaseUser;
import Service.Interfaces.IRegisterService;

/**
 * CREATED BY mathias @ 18-11-2021 - 12:35
 **/
public class UserRegister {
    private final IRegisterService service;

    public UserRegister(IRegisterService service) {
        this.service = service;
    }

    public BaseUser register(String email, String password, String SecretKey) throws Exception {
        return service.registerUser(email, password,SecretKey);
    }

    public boolean checkIfUserInSystem(String email, String password) throws Exception {
        return service.CheckIfInSystem(email, password);
    }

}

