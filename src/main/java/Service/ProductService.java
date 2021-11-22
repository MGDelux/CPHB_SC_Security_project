package Service;

import Dependencies.EMF_Creator;
import Models.Store.Product;
import Models.Users.BaseUser;
import Models.Users.Permissions;
import Service.Interfaces.IProductService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * CREATED BY mathias @ 21-11-2021 - 18:43
 **/
public class ProductService implements IProductService {
    private static EntityManagerFactory emf;

    @Override
    public Product createNewProduct(BaseUser user, Product product) throws Exception {
        boolean hasPerms = false;
        for (Permissions p : user.getUserPermissions()) {
            if (p.getUserPerms().equals(Permissions.UserPermissions.CREATE_PRODUCT)) {
                hasPerms = true;
            } else {
                throw new Exception();
            }
        }
        if (hasPerms) {
//do thing
        }
        return null;
    }

    @Override
    public Product deleteProduct(BaseUser user, Product product) {
        return null;
    }

    @Override
    public Product modifyProduct(BaseUser user, Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        List<Product> productList = new ArrayList<>();
        try {
            EntityManager em = emf.createEntityManager();

            productList = em.createNativeQuery("SELECT * FROM PRODUCTS",Product.class).getResultList();
          return productList;
        }catch (Exception e){
            System.out.println(e);
        }

        return null;
    }

    @Override
    public Product getSpecificProduct(BaseUser user, Product product) {
        return null;
    }
}
