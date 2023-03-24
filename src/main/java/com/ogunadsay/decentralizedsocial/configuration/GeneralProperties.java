package com.ogunadsay.decentralizedsocial.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

@Configuration
@ConfigurationProperties(prefix = "contract")
public class GeneralProperties {
    private BigInteger gasPrice;
    private BigInteger gasLimit;

    public StaticGasProvider gas() {
        return new StaticGasProvider(gasPrice, gasLimit);
    }

    public BigInteger getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(BigInteger gasPrice) {
        this.gasPrice = gasPrice;
    }

    public BigInteger getGasLimit() {
        return gasLimit;
    }

    public void setGasLimit(BigInteger gasLimit) {
        this.gasLimit = gasLimit;
    }
}