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
    public static final String BINARY = "608060405234801561001057600080fd5b50604051610d8e380380610d8e83398101604081905261002f91610054565b600180546001600160a01b0319166001600160a01b0392909216919091179055610084565b60006020828403121561006657600080fd5b81516001600160a01b038116811461007d57600080fd5b9392505050565b610cfb806100936000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c806323edf6971461005c5780637d0b1026146100855780638ebb4c151461009a578063aa7e5683146100bd578063ddd96e2e146100d0575b600080fd5b61006f61006a3660046108e3565b6100fb565b60405161007c9190610958565b60405180910390f35b6100986100933660046108e3565b61035f565b005b6100ad6100a83660046108e3565b610539565b60405161007c94939291906109ec565b6100986100cb366004610abb565b61060b565b6001546100e3906001600160a01b031681565b6040516001600160a01b03909116815260200161007c565b60606000805b60005481101561015757836000828154811061011f5761011f610b45565b9060005260206000209060040201600101541415610145578161014181610b71565b9250505b8061014f81610b71565b915050610101565b5060008167ffffffffffffffff81111561017357610173610a23565b6040519080825280602002602001820160405280156101d857816020015b6101c56040518060800160405280600081526020016000815260200160006001600160a01b03168152602001606081525090565b8152602001906001900390816101915790505b5090506000915060005b60005481101561035757846000828154811061020057610200610b45565b9060005260206000209060040201600101541415610345576000818154811061022b5761022b610b45565b906000526020600020906004020160405180608001604052908160008201548152602001600182015481526020016002820160009054906101000a90046001600160a01b03166001600160a01b03166001600160a01b0316815260200160038201805461029790610b8c565b80601f01602080910402602001604051908101604052809291908181526020018280546102c390610b8c565b80156103105780601f106102e557610100808354040283529160200191610310565b820191906000526020600020905b8154815290600101906020018083116102f357829003601f168201915b50505050508152505082848151811061032b5761032b610b45565b6020026020010181905250828061034190610b71565b9350505b8061034f81610b71565b9150506101e2565b509392505050565b60005481106103ad5760405162461bcd60e51b8152602060048201526015602482015274092dcecc2d8d2c840c6dedadacadce840d2dcc8caf605b1b60448201526064015b60405180910390fd5b600081815481106103c0576103c0610b45565b60009182526020909120600490910201600201546001600160a01b031633146104395760405162461bcd60e51b815260206004820152602560248201527f4f6e6c792074686520636f6d6d656e7420617574686f722063616e2064656c656044820152641d19481a5d60da1b60648201526084016103a4565b6000805461044990600190610bc7565b8154811061045957610459610b45565b90600052602060002090600402016000828154811061047a5761047a610b45565b6000918252602090912082546004909202019081556001808301549082015560028083015490820180546001600160a01b0319166001600160a01b0390921691909117905560038083018054918301916104d390610b8c565b6104de929190610792565b5090505060008054806104f3576104f3610bde565b600082815260208120600460001990930192830201818155600181018290556002810180546001600160a01b031916905590610532600383018261081d565b5050905550565b6000818154811061054957600080fd5b6000918252602090912060049091020180546001820154600283015460038401805493955091936001600160a01b039091169290919061058890610b8c565b80601f01602080910402602001604051908101604052809291908181526020018280546105b490610b8c565b80156106015780601f106105d657610100808354040283529160200191610601565b820191906000526020600020905b8154815290600101906020018083116105e457829003601f168201915b5050505050905084565b60015460405163101cc70960e21b8152600481018490526001600160a01b03909116906340731c249060240160006040518083038186803b15801561064f57600080fd5b505afa158015610663573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f1916820160405261068b9190810190610bf4565b5060008054604080516080810182528281526020808201878152339383019384526060830187815260018601875595805282517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e5636004870290810191825591517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56483015593517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e565820180546001600160a01b0319166001600160a01b03909216919091179055945180519495929461078a937f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e5660192919091019061085a565b505050505050565b82805461079e90610b8c565b90600052602060002090601f0160209004810192826107c0576000855561080d565b82601f106107d1578054855561080d565b8280016001018555821561080d57600052602060002091601f016020900482015b8281111561080d5782548255916001019190600101906107f2565b506108199291506108ce565b5090565b50805461082990610b8c565b6000825580601f10610839575050565b601f01602090049060005260206000209081019061085791906108ce565b50565b82805461086690610b8c565b90600052602060002090601f016020900481019282610888576000855561080d565b82601f106108a157805160ff191683800117855561080d565b8280016001018555821561080d579182015b8281111561080d5782518255916020019190600101906108b3565b5b8082111561081957600081556001016108cf565b6000602082840312156108f557600080fd5b5035919050565b60005b838110156109175781810151838201526020016108ff565b83811115610926576000848401525b50505050565b600081518084526109448160208601602086016108fc565b601f01601f19169290920160200192915050565b60006020808301818452808551808352604092508286019150828160051b87010184880160005b838110156109de57888303603f190185528151805184528781015188850152868101516001600160a01b0316878501526060908101516080918501829052906109ca8186018361092c565b96890196945050509086019060010161097f565b509098975050505050505050565b84815283602082015260018060a01b0383166040820152608060608201526000610a19608083018461092c565b9695505050505050565b634e487b7160e01b600052604160045260246000fd5b6040516060810167ffffffffffffffff81118282101715610a5c57610a5c610a23565b60405290565b604051601f8201601f1916810167ffffffffffffffff81118282101715610a8b57610a8b610a23565b604052919050565b600067ffffffffffffffff821115610aad57610aad610a23565b50601f01601f191660200190565b60008060408385031215610ace57600080fd5b82359150602083013567ffffffffffffffff811115610aec57600080fd5b8301601f81018513610afd57600080fd5b8035610b10610b0b82610a93565b610a62565b818152866020838501011115610b2557600080fd5b816020840160208301376000602083830101528093505050509250929050565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052601160045260246000fd5b6000600019821415610b8557610b85610b5b565b5060010190565b600181811c90821680610ba057607f821691505b60208210811415610bc157634e487b7160e01b600052602260045260246000fd5b50919050565b600082821015610bd957610bd9610b5b565b500390565b634e487b7160e01b600052603160045260246000fd5b60006020808385031215610c0757600080fd5b825167ffffffffffffffff80821115610c1f57600080fd5b9084019060608287031215610c3357600080fd5b610c3b610a39565b82518152838301516001600160a01b0381168114610c5857600080fd5b81850152604083015182811115610c6e57600080fd5b80840193505086601f840112610c8357600080fd5b82519150610c93610b0b83610a93565b8281528785848601011115610ca757600080fd5b610cb6838683018787016108fc565b6040820152969550505050505056fea2646970667358221220593dce9def77c0513eb24b508b83101c1b451dd5bde184bc212614a7be0e759964736f6c63430008090033";

    public static final String FUNC_ADDCOMMENT = "addComment";

    public static final String FUNC_COMMENTS = "comments";

    public static final String FUNC_DELETECOMMENT = "deleteComment";

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
