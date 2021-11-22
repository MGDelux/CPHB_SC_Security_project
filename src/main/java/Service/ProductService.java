package Service;

import Models.Store.Product;
import Models.Users.BaseUser;
import Models.Users.Permissions;
import Service.Interfaces.IProductService;

/**
 * CREATED BY mathias @ 21-11-2021 - 18:43
 **/
public class ProductService implements IProductService {
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
}
