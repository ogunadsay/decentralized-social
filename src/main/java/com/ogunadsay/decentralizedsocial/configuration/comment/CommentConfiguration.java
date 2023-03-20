package com.ogunadsay.decentralizedsocial.configuration.comment;

import com.ogunadsay.decentralizedsocial.model.CommentStorage;
import com.ogunadsay.decentralizedsocial.service.CommentService;
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
public class CommentConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(CommentConfiguration.class);

    @Value("${comment.contract.owner-address}")
    private String ownerAddress;

    @Value("${web3j.client-address}")
    private String clientAddress;

    @Autowired
    private CommentProperties config;

    @Bean
    public Web3j web3j() {
        return Web3j.build(new HttpService(clientAddress, new OkHttpClient.Builder().build()));
    }

    @Bean
    public CommentService contract(Web3j web3j, @Value("${comment.contract.address:}") String contractAddress)
            throws Exception {
        if (StringUtils.isEmpty(contractAddress)) {
            CommentStorage comment = deployContract(web3j);
            return initCommentService(comment.getContractAddress(), web3j);
        }
        LOG.info("Using a default contract address: '{}'", contractAddress);

        return initCommentService(contractAddress, web3j);
    }

    private CommentService initCommentService(String contractAddress, Web3j web3j) {
        return new CommentService(contractAddress, web3j, config);
    }

    private CommentStorage deployContract(Web3j web3j) throws Exception {
        LOG.info("About to deploy new contract...");
        CommentStorage contract = CommentStorage.deploy(web3j, txManager(web3j), config.gas()).send();
        LOG.info("Deployed new contract with address '{}'", contract.getContractAddress());
        return contract;
    }

    private TransactionManager txManager(Web3j web3j) {
        return new ClientTransactionManager(web3j, ownerAddress);
    }

}