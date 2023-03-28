package com.ogunadsay.decentralizedsocial.service;

import com.ogunadsay.decentralizedsocial.configuration.GeneralProperties;
import com.ogunadsay.decentralizedsocial.model.ContractType;
import org.web3j.protocol.Web3j;

import java.util.ArrayList;
import java.util.List;

public class ContractFactory {

    private final List<AbstractContractService<?>> contractServiceList;
    public final String contractAddress;
    public final Web3j web3j;
    public final GeneralProperties config;

    public ContractFactory(String contractAddress, Web3j web3j, GeneralProperties config) {
        this.contractAddress = contractAddress;
        this.web3j = web3j;
        this.config = config;

        this.contractServiceList = new ArrayList<>();
        contractServiceList.add(new PostService(contractAddress, web3j, config));
        contractServiceList.add(new CommentService(contractAddress, web3j, config));
    }

    public AbstractContractService<?> getContractService(ContractType contractType) {
        return contractServiceList.stream()
                .filter(abstractContractService -> abstractContractService.getType().equals(contractType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("this contract type is not supported"));
    }
}
