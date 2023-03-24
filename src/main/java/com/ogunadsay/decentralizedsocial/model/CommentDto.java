package com.ogunadsay.decentralizedsocial.model;

import lombok.Data;

import java.math.BigInteger;

@Data
public class CommentDto {
    private BigInteger postId;
    private String content;
}
