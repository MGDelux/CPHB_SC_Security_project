package Service;

import Config.ErrorHandling.UserAlreadyExisting;
import Config.ErrorHandling.UserInternalError;
import Dependencies.EMF_Creator;
import Models.Users.BaseUser;
import Models.Users.Permissions;
import Service.Interfaces.IRegisterService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * CREATED BY mathias @ 17-11-2021 - 14:13
 **/
public class RegisterService implements IRegisterService {
    private static EntityManagerFactory emf;



    @Override
    public BaseUser registerNewUser(String email, String password ) throws Exception {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        EntityManager em = emf.createEntityManager();
        BaseUser NewUser = new BaseUser(email, password);
        List<Permissions> permissions = new ArrayList<>();
        Permissions permissions1 = new Permissions("View Personal Page", Permissions.UserPermissions.VIEW_PERSONAL_USER_PAGE);
        Permissions permissions2 = new Permissions("Add products to basket", Permissions.UserPermissions.ADD_TO_BASKET);
        Permissions permissions3 = new Permissions("Upload profile picture", Permissions.UserPermissions.UPLOAD_PROFILE_PICTURE);
        permissions.add(permissions1);
        permissions.add(permissions2);
        permissions.add(permissions3);
        try {


        NewUser.setUserPermissions(permissions);
        em.getTransaction().begin();
        em.merge(NewUser);
        em.getTransaction().commit();
        }catch (Exception e){
            throw new UserAlreadyExisting();
        }
        return NewUser;


    }
}

