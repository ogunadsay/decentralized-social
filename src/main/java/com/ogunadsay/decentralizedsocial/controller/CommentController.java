package com.ogunadsay.decentralizedsocial.controller;

import com.ogunadsay.decentralizedsocial.model.CommentDto;
import com.ogunadsay.decentralizedsocial.model.CommentStorage;
import com.ogunadsay.decentralizedsocial.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public ResponseEntity<List<CommentStorage>> getComments(@RequestHeader("X-wallet-account") String accountAddress) throws Exception {
        List<CommentStorage> comments = commentService.getComments(accountAddress, BigInteger.valueOf(1));
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("/comments")
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto comment, @RequestHeader("X-wallet-account") String accountAddress) throws Exception {
        commentService.addComment(accountAddress, comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<BigInteger> deleteComment(@PathVariable BigInteger id, @RequestHeader("X-wallet-account") String accountAddress) throws Exception {
        commentService.deleteComment(accountAddress, id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
