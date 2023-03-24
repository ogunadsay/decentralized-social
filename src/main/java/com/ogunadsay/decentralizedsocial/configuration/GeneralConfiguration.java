package com.ogunadsay.decentralizedsocial.configuration;

import com.ogunadsay.decentralizedsocial.model.CommentStorage;
import com.ogunadsay.decentralizedsocial.model.PostStorage;
import com.ogunadsay.decentralizedsocial.service.CommentService;
import com.ogunadsay.decentralizedsocial.service.PostService;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

    @Bean
    public PostService postContract(Web3j web3j, @Value("${post.contract.address:}") String contractAddress)
            throws Exception {
        if (StringUtils.isEmpty(contractAddress)) {
            PostStorage post = PostStorage.deploy(web3j, txManager(web3j), config.gas()).send();
            postContractAddress = post.getContractAddress();
            return initPostService(post.getContractAddress(), web3j);
        }
        LOG.info("Using a default contract address: '{}'", contractAddress);
        postContractAddress = contractAddress;
        return initPostService(contractAddress, web3j);
    }

    private PostService initPostService(String contractAddress, Web3j web3j) {
        return new PostService(contractAddress, web3j, config);
    }

    @Bean
    public CommentService commentContract(Web3j web3j, @Value("${comment.contract.address:}") String contractAddress)
            throws Exception {
        if (StringUtils.isEmpty(contractAddress)) {
            CommentStorage comment = CommentStorage.deploy(web3j, txManager(web3j), config.gas(), "0x21402B26FF8AC0C6e598f9e20BCf799706Ab63eA").send();
            return initCommentService(comment.getContractAddress(), web3j);
        }
        LOG.info("Using a default contract address: '{}'", contractAddress);

        return initCommentService(contractAddress, web3j);
    }

    private CommentService initCommentService(String contractAddress, Web3j web3j) {
        return new CommentService(contractAddress, web3j, config);
    }

    protected TransactionManager txManager(Web3j web3j) {
        return new ClientTransactionManager(web3j, ownerAddress);
    }

}