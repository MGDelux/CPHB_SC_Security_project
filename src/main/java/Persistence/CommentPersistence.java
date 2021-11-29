package Persistence;

import Models.Store.Product;
import Models.Users.BaseUser;
import Service.Interfaces.ICommentService;

/**
 * CREATED BY mathias @ 22-11-2021 - 16:54
 **/
public class CommentPersistence {
    private final ICommentService commentService;

    public CommentPersistence(ICommentService commentService) {
        this.commentService = commentService;
    }

    public void postComment(int rating, Product specificProduct, String comment, BaseUser user) throws Exception {
        this.commentService.postComment(rating, specificProduct, comment, user);

    }
}

