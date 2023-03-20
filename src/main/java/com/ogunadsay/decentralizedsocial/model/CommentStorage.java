package com.ogunadsay.decentralizedsocial.model;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.9.4.
 */
@SuppressWarnings("rawtypes")
public class CommentStorage extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610949806100206000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80637d0b102614610051578063843b4386146100665780638ebb4c151461007957806391f3410c146100a3575b600080fd5b61006461005f366004610697565b6100b8565b005b6100646100743660046106c6565b610296565b61008c610087366004610697565b61037e565b60405161009a9291906107c4565b60405180910390f35b6100ab610440565b60405161009a91906107f0565b60005481106101065760405162461bcd60e51b8152602060048201526015602482015274092dcecc2d8d2c840c6dedadacadce840d2dcc8caf605b1b60448201526064015b60405180910390fd5b600081815481106101195761011961086d565b60009182526020909120600290910201546001600160a01b0316331461018f5760405162461bcd60e51b815260206004820152602560248201527f4f6e6c792074686520636f6d6d656e7420617574686f722063616e2064656c656044820152641d19481a5d60da1b60648201526084016100fd565b6000805461019f90600190610883565b815481106101af576101af61086d565b9060005260206000209060020201600082815481106101d0576101d061086d565b60009182526020909120825460029092020180546001600160a01b0319166001600160a01b039092169190911781556001808301805491830191610213906108a8565b61021e929190610546565b509050506000805480610233576102336108e3565b60008281526020812060026000199093019283020180546001600160a01b03191681559061026460018301826105d1565b5050905560405181907fb56539a3b332b00ffce8c0f70bfb1813db25879d5c24012911a39c74ddab8f9890600090a250565b60408051808201909152338152602080820183815260008054600181018255908052835160029091027f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e563810180546001600160a01b03939093166001600160a01b0319909316929092178255915180519193610337937f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e564019291019061060e565b505050336001600160a01b03167fcd4da997b36e4ffec835b3653069a81f3cdfce5a67acfa9f979be3a728e548a18260405161037391906108f9565b60405180910390a250565b6000818154811061038e57600080fd5b6000918252602090912060029091020180546001820180546001600160a01b039092169350906103bd906108a8565b80601f01602080910402602001604051908101604052809291908181526020018280546103e9906108a8565b80156104365780601f1061040b57610100808354040283529160200191610436565b820191906000526020600020905b81548152906001019060200180831161041957829003601f168201915b5050505050905082565b60606000805480602002602001604051908101604052809291908181526020016000905b8282101561053d576000848152602090819020604080518082019091526002850290910180546001600160a01b0316825260018101805492939192918401916104ac906108a8565b80601f01602080910402602001604051908101604052809291908181526020018280546104d8906108a8565b80156105255780601f106104fa57610100808354040283529160200191610525565b820191906000526020600020905b81548152906001019060200180831161050857829003601f168201915b50505050508152505081526020019060010190610464565b50505050905090565b828054610552906108a8565b90600052602060002090601f01602090048101928261057457600085556105c1565b82601f1061058557805485556105c1565b828001600101855582156105c157600052602060002091601f016020900482015b828111156105c15782548255916001019190600101906105a6565b506105cd929150610682565b5090565b5080546105dd906108a8565b6000825580601f106105ed575050565b601f01602090049060005260206000209081019061060b9190610682565b50565b82805461061a906108a8565b90600052602060002090601f01602090048101928261063c57600085556105c1565b82601f1061065557805160ff19168380011785556105c1565b828001600101855582156105c1579182015b828111156105c1578251825591602001919060010190610667565b5b808211156105cd5760008155600101610683565b6000602082840312156106a957600080fd5b5035919050565b634e487b7160e01b600052604160045260246000fd5b6000602082840312156106d857600080fd5b813567ffffffffffffffff808211156106f057600080fd5b818401915084601f83011261070457600080fd5b813581811115610716576107166106b0565b604051601f8201601f19908116603f0116810190838211818310171561073e5761073e6106b0565b8160405282815287602084870101111561075757600080fd5b826020860160208301376000928101602001929092525095945050505050565b6000815180845260005b8181101561079d57602081850181015186830182015201610781565b818111156107af576000602083870101525b50601f01601f19169290920160200192915050565b6001600160a01b03831681526040602082018190526000906107e890830184610777565b949350505050565b60006020808301818452808551808352604092508286019150828160051b87010184880160005b8381101561085f57888303603f19018552815180516001600160a01b0316845287015187840187905261084c87850182610777565b9588019593505090860190600101610817565b509098975050505050505050565b634e487b7160e01b600052603260045260246000fd5b6000828210156108a357634e487b7160e01b600052601160045260246000fd5b500390565b600181811c908216806108bc57607f821691505b602082108114156108dd57634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052603160045260246000fd5b60208152600061090c6020830184610777565b939250505056fea2646970667358221220775d7419b4ac6a87b1ef7ec76b1c8921d1eb25c133ae448df9a9e6bfd5ca214b64736f6c63430008090033";

    public static final String FUNC_ADDCOMMENT = "addComment";

    public static final String FUNC_COMMENTS = "comments";

    public static final String FUNC_DELETECOMMENT = "deleteComment";

    public static final String FUNC_GETCOMMENTS = "getComments";

    public static final Event COMMENTADDED_EVENT = new Event("CommentAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event COMMENTDELETED_EVENT = new Event("CommentDeleted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}));
    ;

    @Deprecated
    protected CommentStorage(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CommentStorage(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CommentStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CommentStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<CommentAddedEventResponse> getCommentAddedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(COMMENTADDED_EVENT, transactionReceipt);
        ArrayList<CommentAddedEventResponse> responses = new ArrayList<CommentAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CommentAddedEventResponse typedResponse = new CommentAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.author = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.content = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CommentAddedEventResponse> commentAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, CommentAddedEventResponse>() {
            @Override
            public CommentAddedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(COMMENTADDED_EVENT, log);
                CommentAddedEventResponse typedResponse = new CommentAddedEventResponse();
                typedResponse.log = log;
                typedResponse.author = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.content = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CommentAddedEventResponse> commentAddedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(COMMENTADDED_EVENT));
        return commentAddedEventFlowable(filter);
    }

    public static List<CommentDeletedEventResponse> getCommentDeletedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(COMMENTDELETED_EVENT, transactionReceipt);
        ArrayList<CommentDeletedEventResponse> responses = new ArrayList<CommentDeletedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CommentDeletedEventResponse typedResponse = new CommentDeletedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.index = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CommentDeletedEventResponse> commentDeletedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, CommentDeletedEventResponse>() {
            @Override
            public CommentDeletedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(COMMENTDELETED_EVENT, log);
                CommentDeletedEventResponse typedResponse = new CommentDeletedEventResponse();
                typedResponse.log = log;
                typedResponse.index = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CommentDeletedEventResponse> commentDeletedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(COMMENTDELETED_EVENT));
        return commentDeletedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addComment(String _content) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDCOMMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_content)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple2<String, String>> comments(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_COMMENTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple2<String, String>>(function,
                new Callable<Tuple2<String, String>>() {
                    @Override
                    public Tuple2<String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> deleteComment(BigInteger _index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DELETECOMMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> getComments() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCOMMENTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Comment>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    @Deprecated
    public static CommentStorage load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CommentStorage(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CommentStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CommentStorage(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CommentStorage load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CommentStorage(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CommentStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CommentStorage(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CommentStorage> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CommentStorage.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CommentStorage> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CommentStorage.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<CommentStorage> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CommentStorage.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CommentStorage> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CommentStorage.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class Comment extends DynamicStruct {
        public String author;

        public String content;

        public Comment(String author, String content) {
            super(new org.web3j.abi.datatypes.Address(160, author), 
                    new org.web3j.abi.datatypes.Utf8String(content));
            this.author = author;
            this.content = content;
        }

        public Comment(Address author, Utf8String content) {
            super(author, content);
            this.author = author.getValue();
            this.content = content.getValue();
        }
    }

    public static class CommentAddedEventResponse extends BaseEventResponse {
        public String author;

        public String content;
    }

    public static class CommentDeletedEventResponse extends BaseEventResponse {
        public BigInteger index;
    }
}
