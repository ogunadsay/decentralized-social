package com.ogunadsay.decentralizedsocial.model;

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
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

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
public class PostStorage extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610adb806100206000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c8063094cd5ee1461005c5780630b1e7f831461007157806340731c241461009c57806341f3004a146100bc578063a6322819146100d1575b600080fd5b61006f61006a366004610804565b6100e4565b005b61008461007f366004610804565b6102a4565b6040516100939392919061086a565b60405180910390f35b6100af6100aa366004610804565b61036d565b60405161009391906108d6565b6100c46104c8565b60405161009391906108f0565b61006f6100df366004610968565b6105d9565b600054811061012c5760405162461bcd60e51b815260206004820152600f60248201526e125b9d985b1a59081c1bdcdd081a59608a1b60448201526064015b60405180910390fd5b6000818154811061013f5761013f610a19565b60009182526020909120600390910201600101546001600160a01b031633146101b55760405162461bcd60e51b815260206004820152602260248201527f4f6e6c792074686520706f737420617574686f722063616e2064656c657465206044820152611a5d60f21b6064820152608401610123565b600080546101c590600190610a2f565b815481106101d5576101d5610a19565b9060005260206000209060030201600082815481106101f6576101f6610a19565b60009182526020909120825460039092020190815560018083015490820180546001600160a01b0319166001600160a01b03909216919091179055600280830180549183019161024590610a54565b6102509291906106b3565b50905050600080548061026557610265610a8f565b6000828152602081206003600019909301928302018181556001810180546001600160a01b03191690559061029d600283018261073e565b5050905550565b600081815481106102b457600080fd5b60009182526020909120600390910201805460018201546002830180549294506001600160a01b0390911692916102ea90610a54565b80601f016020809104026020016040519081016040528092919081815260200182805461031690610a54565b80156103635780601f1061033857610100808354040283529160200191610363565b820191906000526020600020905b81548152906001019060200180831161034657829003601f168201915b5050505050905083565b604080516060808201835260008083526020830181905292820152905482106103ca5760405162461bcd60e51b815260206004820152600f60248201526e125b9d985b1a59081c1bdcdd081a59608a1b6044820152606401610123565b600082815481106103dd576103dd610a19565b9060005260206000209060030201604051806060016040529081600082015481526020016001820160009054906101000a90046001600160a01b03166001600160a01b03166001600160a01b0316815260200160028201805461043f90610a54565b80601f016020809104026020016040519081016040528092919081815260200182805461046b90610a54565b80156104b85780601f1061048d576101008083540402835291602001916104b8565b820191906000526020600020905b81548152906001019060200180831161049b57829003601f168201915b5050505050815250509050919050565b60606000805480602002602001604051908101604052809291908181526020016000905b828210156105d057600084815260209081902060408051606081018252600386029092018054835260018101546001600160a01b0316938301939093526002830180549293929184019161053f90610a54565b80601f016020809104026020016040519081016040528092919081815260200182805461056b90610a54565b80156105b85780601f1061058d576101008083540402835291602001916105b8565b820191906000526020600020905b81548152906001019060200180831161059b57829003601f168201915b505050505081525050815260200190600101906104ec565b50505050905090565b600080546040805160608101825282815233602080830191825292820186815260018501865594805281517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e5636003860290810191825591517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e564830180546001600160a01b0319166001600160a01b03909216919091179055945180519495929492936106ac937f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e5659093019291019061077b565b5050505050565b8280546106bf90610a54565b90600052602060002090601f0160209004810192826106e1576000855561072e565b82601f106106f2578054855561072e565b8280016001018555821561072e57600052602060002091601f016020900482015b8281111561072e578254825591600101919060010190610713565b5061073a9291506107ef565b5090565b50805461074a90610a54565b6000825580601f1061075a575050565b601f01602090049060005260206000209081019061077891906107ef565b50565b82805461078790610a54565b90600052602060002090601f0160209004810192826107a9576000855561072e565b82601f106107c257805160ff191683800117855561072e565b8280016001018555821561072e579182015b8281111561072e5782518255916020019190600101906107d4565b5b8082111561073a57600081556001016107f0565b60006020828403121561081657600080fd5b5035919050565b6000815180845260005b8181101561084357602081850181015186830182015201610827565b81811115610855576000602083870101525b50601f01601f19169290920160200192915050565b8381526001600160a01b03831660208201526060604082018190526000906108949083018461081d565b95945050505050565b8051825260018060a01b03602082015116602083015260006040820151606060408501526108ce606085018261081d565b949350505050565b6020815260006108e9602083018461089d565b9392505050565b6000602080830181845280855180835260408601915060408160051b870101925083870160005b8281101561094557603f1988860301845261093385835161089d565b94509285019290850190600101610917565b5092979650505050505050565b634e487b7160e01b600052604160045260246000fd5b60006020828403121561097a57600080fd5b813567ffffffffffffffff8082111561099257600080fd5b818401915084601f8301126109a657600080fd5b8135818111156109b8576109b8610952565b604051601f8201601f19908116603f011681019083821181831017156109e0576109e0610952565b816040528281528760208487010111156109f957600080fd5b826020860160208301376000928101602001929092525095945050505050565b634e487b7160e01b600052603260045260246000fd5b600082821015610a4f57634e487b7160e01b600052601160045260246000fd5b500390565b600181811c90821680610a6857607f821691505b60208210811415610a8957634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052603160045260246000fdfea2646970667358221220ca574a40e7a25280a9369e05e3e4da329b824f5a7b4bb0a66114c4d8e194ce8564736f6c63430008090033";

    public static final String FUNC_ADDPOST = "addPost";

    public static final String FUNC_DELETEPOST = "deletePost";

    public static final String FUNC_GETPOST = "getPost";

    public static final String FUNC_GETPOSTS = "getPosts";

    public static final String FUNC_POSTS = "posts";

    @Deprecated
    protected PostStorage(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PostStorage(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PostStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PostStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addPost(String _content) {
        final Function function = new Function(
                FUNC_ADDPOST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_content)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> deletePost(BigInteger _index) {
        final Function function = new Function(
                FUNC_DELETEPOST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Post> getPost(BigInteger _index) {
        final Function function = new Function(FUNC_GETPOST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Post>() {}));
        return executeRemoteCallSingleValueReturn(function, Post.class);
    }

    public RemoteFunctionCall<List> getPosts() {
        final Function function = new Function(FUNC_GETPOSTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Post>>() {}));
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

    public RemoteFunctionCall<Tuple3<BigInteger, String, String>> posts(BigInteger param0) {
        final Function function = new Function(FUNC_POSTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple3<BigInteger, String, String>>(function,
                new Callable<Tuple3<BigInteger, String, String>>() {
                    @Override
                    public Tuple3<BigInteger, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue());
                    }
                });
    }

    @Deprecated
    public static PostStorage load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PostStorage(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PostStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PostStorage(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PostStorage load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PostStorage(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PostStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PostStorage(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<PostStorage> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PostStorage.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PostStorage> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PostStorage.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<PostStorage> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PostStorage.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<PostStorage> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PostStorage.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class Post extends DynamicStruct {
        public BigInteger id;

        public String author;

        public String content;

        public Post(BigInteger id, String author, String content) {
            super(new org.web3j.abi.datatypes.generated.Uint256(id), 
                    new org.web3j.abi.datatypes.Address(160, author), 
                    new org.web3j.abi.datatypes.Utf8String(content));
            this.id = id;
            this.author = author;
            this.content = content;
        }

        public Post(Uint256 id, Address author, Utf8String content) {
            super(id, author, content);
            this.id = id.getValue();
            this.author = author.getValue();
            this.content = content.getValue();
        }
    }
}
