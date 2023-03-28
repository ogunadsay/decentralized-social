package com.ogunadsay.decentralizedsocial.service;

import com.ogunadsay.decentralizedsocial.configuration.GeneralProperties;
import com.ogunadsay.decentralizedsocial.model.ContractType;
import org.web3j.protocol.Web3j;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

public abstract class AbstractContractService<T extends Contract> {

    public final String contractAddress;
    public final Web3j web3j;
    public final GeneralProperties config;

    public AbstractContractService(String contractAddress, Web3j web3j, GeneralProperties config) {
        this.contractAddress = contractAddress;
        this.web3j = web3j;
        this.config = config;
    }

    public TransactionManager txManager(String accountAddress) {
        return new ClientTransactionManager(web3j, accountAddress);
    }

    public abstract T loadContract(String contractAddress);

    public abstract ContractType getType();
}
