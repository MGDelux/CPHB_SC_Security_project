package Service;

import Config.ErrorHandling.UserNotFoundException;
import Dependencies.EMF_Creator;
import Models.Store.Api;
import Models.Users.BaseUser;
import Service.Interfaces.IApiService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * CREATED BY mathias @ 29-11-2021 - 12:17
 **/
public class ApiService implements IApiService {
    private static EntityManagerFactory emf;

    @Override
    public String getApiKey() {
        emf = EMF_Creator.createEntityManagerFactory();
        try {
            EntityManager em = emf.createEntityManager();
            Api api;
            api = (Api) em.createNativeQuery(
                    "SELECT * FROM API_KEY", Api.class).getSingleResult();

          return api.getApikey();

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
