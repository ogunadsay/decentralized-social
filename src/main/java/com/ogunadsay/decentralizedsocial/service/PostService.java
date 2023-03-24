package com.ogunadsay.decentralizedsocial.service;

import com.ogunadsay.decentralizedsocial.configuration.GeneralProperties;
import com.ogunadsay.decentralizedsocial.model.PostStorage;
import org.web3j.protocol.Web3j;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;
import java.util.List;

public class PostService {
    private final String contractAddress;
    private final Web3j web3j;
    private final GeneralProperties config;

    public PostService(String contractAddress, Web3j web3j, GeneralProperties config) {
        this.contractAddress = contractAddress;
        this.web3j = web3j;
        this.config = config;
    }

    public void addPost(String accountAddress, String content) throws Exception {
        PostStorage postStorage = loadContract(accountAddress);
        postStorage.addPost(content).send();
    }

    public PostStorage.Post getPost(String accountAddress, BigInteger postId) throws Exception {
        PostStorage post = loadContract(accountAddress);
        return post.getPost(postId).send();
    }

    public List<PostStorage> getPosts(String accountAddress) throws Exception {
        PostStorage postStorage = loadContract(accountAddress);
        List<PostStorage> posts = postStorage.getPosts().send();
        return posts;
    }

    public void deletePost(String accountAddress, BigInteger postId) throws Exception {
        PostStorage comment = loadContract(accountAddress);
        comment.deletePost(postId).send();
    }

    private PostStorage loadContract(String accountAddress) {
        return PostStorage.load(contractAddress, web3j, txManager(accountAddress), config.gas());
    }

    private TransactionManager txManager(String accountAddress) {
        return new ClientTransactionManager(web3j, accountAddress);
    }

}
