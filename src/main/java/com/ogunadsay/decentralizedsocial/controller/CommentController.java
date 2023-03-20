package com.ogunadsay.decentralizedsocial.controller;

import com.ogunadsay.decentralizedsocial.model.CommentDto;
import com.ogunadsay.decentralizedsocial.model.CommentStorage;
import com.ogunadsay.decentralizedsocial.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public ResponseEntity<List<CommentStorage>> getComments() throws Exception {
        List<CommentStorage> comments = commentService.getComments("0xFe491030440317F051cD7b86bb5155E4A76D1Ca6");
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("/comments")
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto comment) throws Exception {
        commentService.addComment("0x05503fA1AF5a98a9E98e0144dfD8C59bA666E8B3", comment.getContent());
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }
}
