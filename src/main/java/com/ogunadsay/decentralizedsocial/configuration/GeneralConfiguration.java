package com.ogunadsay.decentralizedsocial.configuration;

import com.ogunadsay.decentralizedsocial.model.CommentStorage;
import com.ogunadsay.decentralizedsocial.model.ContractType;
import com.ogunadsay.decentralizedsocial.model.PostStorage;
import com.ogunadsay.decentralizedsocial.service.AbstractContractService;
import com.ogunadsay.decentralizedsocial.service.CommentService;
import com.ogunadsay.decentralizedsocial.service.PostService;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.util.StringUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.TransactionManager;

@Configuration
public class GeneralConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(GeneralConfiguration.class);

    @Value("${contract.owner-address}")
    private String ownerAddress;

    @Value("${web3j.client-address}")
    private String clientAddress;

    @Autowired
    protected GeneralProperties config;

    @Bean
    public Web3j web3j() {
        return Web3j.build(new HttpService(clientAddress, new OkHttpClient.Builder().build()));
    }

    private String postContractAddress;

    @Bean("post")
    public PostService postContract(Web3j web3j, @Value("${post.contract.address:}") String contractAddress)
            throws Exception {
        if (StringUtils.isEmpty(contractAddress)) {
            PostStorage post = PostStorage.deploy(web3j, txManager(web3j), config.gas()).send();
            postContractAddress = post.getContractAddress();
            return (PostService) initService(post.getContractAddress(), web3j, ContractType.POST);
        }
        LOG.info("Using a default contract address: '{}'", contractAddress);
        postContractAddress = contractAddress;
        return (PostService) initService(contractAddress, web3j, ContractType.POST);
    }

    @Bean("comment")
    @DependsOn("post")
    public CommentService commentContract(Web3j web3j, @Value("${comment.contract.address:}") String contractAddress)
            throws Exception {
        if (StringUtils.isEmpty(contractAddress)) {
            CommentStorage comment = CommentStorage.deploy(web3j, txManager(web3j), config.gas(), postContractAddress).send();
            return (CommentService) initService(comment.getContractAddress(), web3j, ContractType.COMMENT);
        }
        LOG.info("Using a default contract address: '{}'", contractAddress);

        return (CommentService) initService(contractAddress, web3j, ContractType.COMMENT);
    }

    private AbstractContractService<?> initService(String contractAddress, Web3j web3j, ContractType contractType) {
        AbstractContractService<?> contractService;
        switch (contractType) {
            case POST -> contractService = new PostService(contractAddress, web3j, config);
            case COMMENT -> contractService = new CommentService(contractAddress, web3j, config);
            default -> throw new RuntimeException("this type is not supported");
        }
        return contractService;
    }

    protected TransactionManager txManager(Web3j web3j) {
        return new ClientTransactionManager(web3j, ownerAddress);
    }

}