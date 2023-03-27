pragma solidity ^0.8.9;

import "./Post.sol";

contract CommentStorage {
    struct Comment {
        uint commentId;
        uint postId;
        address author;
        string content;
    }

    Comment[] public comments;
    PostStorage public postStorage;

    constructor(address _postStorage) {
        postStorage = PostStorage(_postStorage);
    }

    function addComment(uint _postId, string memory _content) external {
        postStorage.getPost(_postId);

        uint index = comments.length;
        comments.push(Comment(index, _postId, msg.sender, _content));
    }

    function deleteComment(uint _index) public {
        require(_index < comments.length, "Invalid comment index");
        require(msg.sender == comments[_index].author, "Only the comment author can delete it");

        comments[_index] = comments[comments.length - 1];
        comments.pop();
    }

    function getComments(uint _postId) public view returns (Comment[] memory) {
        uint count = 0;
        for (uint i = 0; i < comments.length; i++) {
            if (comments[i].postId == _postId) {
                count++;
            }
        }
        Comment[] memory result = new Comment[](count);
        count = 0;
        for (uint i = 0; i < comments.length; i++) {
            if (comments[i].postId == _postId) {
                result[count] = comments[i];
                count++;
            }
        }
        return result;
    }

    function getAllComments() public view returns (Comment[] memory) {
        return comments;
    }
}