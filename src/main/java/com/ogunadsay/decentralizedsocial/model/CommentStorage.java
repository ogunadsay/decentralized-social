package com.ogunadsay.decentralizedsocial.model;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
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
    public static final String BINARY = "608060405234801561001057600080fd5b50604051610ebd380380610ebd83398101604081905261002f91610054565b600180546001600160a01b0319166001600160a01b0392909216919091179055610084565b60006020828403121561006657600080fd5b81516001600160a01b038116811461007d57600080fd5b9392505050565b610e2a806100936000396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c8063104409041461006757806323edf697146100855780637d0b1026146100985780638ebb4c15146100ad578063aa7e5683146100d0578063ddd96e2e146100e3575b600080fd5b61006f61010e565b60405161007c9190610a6e565b60405180910390f35b61006f610093366004610b02565b61022a565b6100ab6100a6366004610b02565b61048e565b005b6100c06100bb366004610b02565b610668565b60405161007c9493929190610b1b565b6100ab6100de366004610bea565b61073a565b6001546100f6906001600160a01b031681565b6040516001600160a01b03909116815260200161007c565b60606000805480602002602001604051908101604052809291908181526020016000905b8282101561022157600084815260209081902060408051608081018252600486029092018054835260018101549383019390935260028301546001600160a01b03169082015260038201805491929160608401919061019090610c74565b80601f01602080910402602001604051908101604052809291908181526020018280546101bc90610c74565b80156102095780601f106101de57610100808354040283529160200191610209565b820191906000526020600020905b8154815290600101906020018083116101ec57829003601f168201915b50505050508152505081526020019060010190610132565b50505050905090565b60606000805b60005481101561028657836000828154811061024e5761024e610caf565b9060005260206000209060040201600101541415610274578161027081610cdb565b9250505b8061027e81610cdb565b915050610230565b5060008167ffffffffffffffff8111156102a2576102a2610b52565b60405190808252806020026020018201604052801561030757816020015b6102f46040518060800160405280600081526020016000815260200160006001600160a01b03168152602001606081525090565b8152602001906001900390816102c05790505b5090506000915060005b60005481101561048657846000828154811061032f5761032f610caf565b9060005260206000209060040201600101541415610474576000818154811061035a5761035a610caf565b906000526020600020906004020160405180608001604052908160008201548152602001600182015481526020016002820160009054906101000a90046001600160a01b03166001600160a01b03166001600160a01b031681526020016003820180546103c690610c74565b80601f01602080910402602001604051908101604052809291908181526020018280546103f290610c74565b801561043f5780601f106104145761010080835404028352916020019161043f565b820191906000526020600020905b81548152906001019060200180831161042257829003601f168201915b50505050508152505082848151811061045a5761045a610caf565b6020026020010181905250828061047090610cdb565b9350505b8061047e81610cdb565b915050610311565b509392505050565b60005481106104dc5760405162461bcd60e51b8152602060048201526015602482015274092dcecc2d8d2c840c6dedadacadce840d2dcc8caf605b1b60448201526064015b60405180910390fd5b600081815481106104ef576104ef610caf565b60009182526020909120600490910201600201546001600160a01b031633146105685760405162461bcd60e51b815260206004820152602560248201527f4f6e6c792074686520636f6d6d656e7420617574686f722063616e2064656c656044820152641d19481a5d60da1b60648201526084016104d3565b6000805461057890600190610cf6565b8154811061058857610588610caf565b9060005260206000209060040201600082815481106105a9576105a9610caf565b6000918252602090912082546004909202019081556001808301549082015560028083015490820180546001600160a01b0319166001600160a01b03909216919091179055600380830180549183019161060290610c74565b61060d9291906108c1565b50905050600080548061062257610622610d0d565b600082815260208120600460001990930192830201818155600181018290556002810180546001600160a01b031916905590610661600383018261094c565b5050905550565b6000818154811061067857600080fd5b6000918252602090912060049091020180546001820154600283015460038401805493955091936001600160a01b03909116929091906106b790610c74565b80601f01602080910402602001604051908101604052809291908181526020018280546106e390610c74565b80156107305780601f1061070557610100808354040283529160200191610730565b820191906000526020600020905b81548152906001019060200180831161071357829003601f168201915b5050505050905084565b60015460405163101cc70960e21b8152600481018490526001600160a01b03909116906340731c249060240160006040518083038186803b15801561077e57600080fd5b505afa158015610792573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f191682016040526107ba9190810190610d23565b5060008054604080516080810182528281526020808201878152339383019384526060830187815260018601875595805282517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e5636004870290810191825591517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56483015593517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e565820180546001600160a01b0319166001600160a01b0390921691909117905594518051949592946108b9937f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56601929190910190610989565b505050505050565b8280546108cd90610c74565b90600052602060002090601f0160209004810192826108ef576000855561093c565b82601f10610900578054855561093c565b8280016001018555821561093c57600052602060002091601f016020900482015b8281111561093c578254825591600101919060010190610921565b506109489291506109fd565b5090565b50805461095890610c74565b6000825580601f10610968575050565b601f01602090049060005260206000209081019061098691906109fd565b50565b82805461099590610c74565b90600052602060002090601f0160209004810192826109b7576000855561093c565b82601f106109d057805160ff191683800117855561093c565b8280016001018555821561093c579182015b8281111561093c5782518255916020019190600101906109e2565b5b8082111561094857600081556001016109fe565b60005b83811015610a2d578181015183820152602001610a15565b83811115610a3c576000848401525b50505050565b60008151808452610a5a816020860160208601610a12565b601f01601f19169290920160200192915050565b60006020808301818452808551808352604092508286019150828160051b87010184880160005b83811015610af457888303603f190185528151805184528781015188850152868101516001600160a01b031687850152606090810151608091850182905290610ae081860183610a42565b968901969450505090860190600101610a95565b509098975050505050505050565b600060208284031215610b1457600080fd5b5035919050565b84815283602082015260018060a01b0383166040820152608060608201526000610b486080830184610a42565b9695505050505050565b634e487b7160e01b600052604160045260246000fd5b6040516060810167ffffffffffffffff81118282101715610b8b57610b8b610b52565b60405290565b604051601f8201601f1916810167ffffffffffffffff81118282101715610bba57610bba610b52565b604052919050565b600067ffffffffffffffff821115610bdc57610bdc610b52565b50601f01601f191660200190565b60008060408385031215610bfd57600080fd5b82359150602083013567ffffffffffffffff811115610c1b57600080fd5b8301601f81018513610c2c57600080fd5b8035610c3f610c3a82610bc2565b610b91565b818152866020838501011115610c5457600080fd5b816020840160208301376000602083830101528093505050509250929050565b600181811c90821680610c8857607f821691505b60208210811415610ca957634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052601160045260246000fd5b6000600019821415610cef57610cef610cc5565b5060010190565b600082821015610d0857610d08610cc5565b500390565b634e487b7160e01b600052603160045260246000fd5b60006020808385031215610d3657600080fd5b825167ffffffffffffffff80821115610d4e57600080fd5b9084019060608287031215610d6257600080fd5b610d6a610b68565b82518152838301516001600160a01b0381168114610d8757600080fd5b81850152604083015182811115610d9d57600080fd5b80840193505086601f840112610db257600080fd5b82519150610dc2610c3a83610bc2565b8281528785848601011115610dd657600080fd5b610de583868301878701610a12565b6040820152969550505050505056fea2646970667358221220599114874580086ca3df6bc2b02289d7b7f6253cab1761bf74b617d174c2af9364736f6c63430008090033";

    public static final String FUNC_ADDCOMMENT = "addComment";

    public static final String FUNC_COMMENTS = "comments";

    public static final String FUNC_DELETECOMMENT = "deleteComment";

    public static final String FUNC_GETALLCOMMENTS = "getAllComments";

    public static final String FUNC_GETCOMMENTS = "getComments";

    public static final String FUNC_POSTSTORAGE = "postStorage";

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

    public RemoteFunctionCall<TransactionReceipt> addComment(BigInteger _postId, String _content) {
        final Function function = new Function(
                FUNC_ADDCOMMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_postId), 
                new org.web3j.abi.datatypes.Utf8String(_content)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple4<BigInteger, BigInteger, String, String>> comments(BigInteger param0) {
        final Function function = new Function(FUNC_COMMENTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple4<BigInteger, BigInteger, String, String>>(function,
                new Callable<Tuple4<BigInteger, BigInteger, String, String>>() {
                    @Override
                    public Tuple4<BigInteger, BigInteger, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, BigInteger, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> deleteComment(BigInteger _index) {
        final Function function = new Function(
                FUNC_DELETECOMMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> getAllComments() {
        final Function function = new Function(FUNC_GETALLCOMMENTS, 
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

    public RemoteFunctionCall<List> getComments(BigInteger _postId) {
        final Function function = new Function(FUNC_GETCOMMENTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_postId)), 
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

    public RemoteFunctionCall<String> postStorage() {
        final Function function = new Function(FUNC_POSTSTORAGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    public static RemoteCall<CommentStorage> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _postStorage) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _postStorage)));
        return deployRemoteCall(CommentStorage.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<CommentStorage> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _postStorage) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _postStorage)));
        return deployRemoteCall(CommentStorage.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CommentStorage> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _postStorage) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _postStorage)));
        return deployRemoteCall(CommentStorage.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CommentStorage> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _postStorage) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _postStorage)));
        return deployRemoteCall(CommentStorage.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class Comment extends DynamicStruct {
        public BigInteger commentId;

        public BigInteger postId;

        public String author;

        public String content;

        public Comment(BigInteger commentId, BigInteger postId, String author, String content) {
            super(new org.web3j.abi.datatypes.generated.Uint256(commentId), 
                    new org.web3j.abi.datatypes.generated.Uint256(postId), 
                    new org.web3j.abi.datatypes.Address(160, author), 
                    new org.web3j.abi.datatypes.Utf8String(content));
            this.commentId = commentId;
            this.postId = postId;
            this.author = author;
            this.content = content;
        }

        public Comment(Uint256 commentId, Uint256 postId, Address author, Utf8String content) {
            super(commentId, postId, author, content);
            this.commentId = commentId.getValue();
            this.postId = postId.getValue();
            this.author = author.getValue();
            this.content = content.getValue();
        }
    }
}
