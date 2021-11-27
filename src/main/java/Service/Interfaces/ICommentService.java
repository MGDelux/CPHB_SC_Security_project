package Service.Interfaces;

import Models.Store.Product;
import Models.Users.BaseUser;

/**
 * CREATED BY mathias @ 22-11-2021 - 16:54
 **/
public interface ICommentService {
void postComment(int rating, Product specificProduct, String comment, BaseUser user) throws Exception;


    }
