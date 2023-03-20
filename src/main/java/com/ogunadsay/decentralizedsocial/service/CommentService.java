package com.ogunadsay.decentralizedsocial.service;

import com.ogunadsay.decentralizedsocial.configuration.comment.CommentProperties;
import com.ogunadsay.decentralizedsocial.model.CommentStorage;
import org.web3j.protocol.Web3j;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;
import java.util.List;

public class CommentService {
    private final String contractAddress;
    private final Web3j web3j;
    private final CommentProperties config;

    public CommentService(String contractAddress, Web3j web3j, CommentProperties config) {
        this.contractAddress = contractAddress;
        this.web3j = web3j;
        this.config = config;
    }

//    public BigInteger getBalance() throws IOException {
//        return web3j.ethGetBalance(contractAddress, DefaultBlockParameterName.LATEST).send().getBalance();
//    }

    public void addComment(String accountAddress, String commentContent) throws Exception {
        CommentStorage comment = loadContract(accountAddress);
        comment.addComment(commentContent).send();
    }

    public List<CommentStorage> getComments(String accountAddress) throws Exception {
        CommentStorage comment = loadContract(accountAddress);
        List<CommentStorage> list = comment.getComments().send();
        return list;
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
