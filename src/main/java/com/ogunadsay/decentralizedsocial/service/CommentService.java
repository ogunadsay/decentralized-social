package com.ogunadsay.decentralizedsocial.service;

import com.ogunadsay.decentralizedsocial.configuration.GeneralProperties;
import com.ogunadsay.decentralizedsocial.model.CommentDto;
import com.ogunadsay.decentralizedsocial.model.CommentStorage;
import org.web3j.protocol.Web3j;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;
import java.util.List;

public class CommentService {
    private final String contractAddress;
    private final Web3j web3j;
    private final GeneralProperties config;

    public CommentService(String contractAddress, Web3j web3j, GeneralProperties config) {
        this.contractAddress = contractAddress;
        this.web3j = web3j;
        this.config = config;
    }

    public void addComment(String accountAddress, CommentDto commentDto) throws Exception {
        CommentStorage comment = loadContract(accountAddress);
        comment.addComment(commentDto.getPostId(), commentDto.getContent()).send();
    }

    public List<CommentStorage> getComments(String accountAddress, BigInteger postId) throws Exception {
        CommentStorage comment = loadContract(accountAddress);
        List<CommentStorage> list = comment.getComments(postId).send();
        return list;
    }

    public List<CommentStorage> getAllComments(String accountAddress) throws Exception {
        CommentStorage comment = loadContract(accountAddress);
        List<CommentStorage> allComments = comment.getAllComments().send();
        return allComments;
    }

    public void deleteComment(String accountAddress, BigInteger commentIndex) throws Exception {
        CommentStorage comment = loadContract(accountAddress);
        comment.deleteComment(commentIndex).send();
    }

    private CommentStorage loadContract(String accountAddress) {
        return CommentStorage.load(contractAddress, web3j, txManager(accountAddress), config.gas());
    }

    private TransactionManager txManager(String accountAddress) {
        return new ClientTransactionManager(web3j, accountAddress);
    }

}
