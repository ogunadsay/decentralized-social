package com.ogunadsay.decentralizedsocial.controller;

import com.ogunadsay.decentralizedsocial.model.CommentStorage;
import com.ogunadsay.decentralizedsocial.model.PostDto;
import com.ogunadsay.decentralizedsocial.model.PostStorage;
import com.ogunadsay.decentralizedsocial.service.CommentService;
import com.ogunadsay.decentralizedsocial.service.PostService;
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
public class PostController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @GetMapping("/posts/{id}/comments")
    public ResponseEntity<List<CommentStorage>> getComments(@PathVariable(name = "id") BigInteger id, @RequestHeader("X-wallet-account") String accountAddress) throws Exception {
        List<CommentStorage> comments = commentService.getComments(accountAddress, id);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostStorage>> getPosts(@RequestHeader("X-wallet-account") String accountAddress) throws Exception {
        List<PostStorage> posts = postService.getPosts(accountAddress);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping("/posts")
    public ResponseEntity<PostDto> addPost(@RequestBody PostDto postDto, @RequestHeader("X-wallet-account") String accountAddress) throws Exception {
        postService.addPost(accountAddress, postDto.getContent());
        return new ResponseEntity<>(postDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<BigInteger> deletePost(@PathVariable BigInteger id, @RequestHeader("X-wallet-account") String accountAddress) throws Exception {
        postService.deletePost(accountAddress, id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
