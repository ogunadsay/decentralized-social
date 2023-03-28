package com.ogunadsay.decentralizedsocial.service;

import com.ogunadsay.decentralizedsocial.configuration.GeneralProperties;
import com.ogunadsay.decentralizedsocial.model.ContractType;
import com.ogunadsay.decentralizedsocial.model.PostStorage;
import org.web3j.protocol.Web3j;

import java.math.BigInteger;
import java.util.List;

public class PostService extends AbstractContractService<PostStorage> {

    public PostService(String contractAddress, Web3j web3j, GeneralProperties config) {
        super(contractAddress, web3j, config);
    }

    @Override
    public PostStorage loadContract(String accountAddress) {
        return PostStorage.load(contractAddress, web3j, txManager(accountAddress), config.gas());
    }

    @Override
    public ContractType getType() {
        return ContractType.POST;
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
}
