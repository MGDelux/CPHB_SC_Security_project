package Persistence;

import Service.Interfaces.ICommentService;

/**
 * CREATED BY mathias @ 22-11-2021 - 16:54
 **/
public class CommentPersistence {
    private final ICommentService commentService;

    public CommentPersistence(ICommentService commentService) {
        this.commentService = commentService;
    }
}

