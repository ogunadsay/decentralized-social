pragma solidity ^0.8.9;

contract CommentStorage {
  struct Comment {
    address author;
    string content;
  }

  Comment[] public comments;

  event CommentAdded(address indexed author, string content);
  event CommentDeleted(uint indexed index);

  function addComment(string memory _content) public {
    comments.push(Comment(msg.sender, _content));
    emit CommentAdded(msg.sender, _content);
  }

  function deleteComment(uint _index) public {
    require(_index < comments.length, "Invalid comment index");
    require(msg.sender == comments[_index].author, "Only the comment author can delete it");

    comments[_index] = comments[comments.length - 1];
    comments.pop();

    emit CommentDeleted(_index);
  }

  function getComments() public view returns (Comment[] memory) {
    return comments;
  }
}