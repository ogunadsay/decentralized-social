pragma solidity ^0.8.9;

contract PostStorage {
    struct Post {
        uint id;
        address author;
        string content;
    }

    Post[] public posts;

    function addPost(string memory _content) public {
        uint index = posts.length;
        posts.push(Post(index, msg.sender, _content));
    }

    function getPost(uint _index) public view returns (Post memory) {
        require(_index < posts.length, "Invalid post id");
        return posts[_index];
    }

    function deletePost(uint _index) public {
        require(_index < posts.length, "Invalid post id");
        require(msg.sender == posts[_index].author, "Only the post author can delete it");

        posts[_index] = posts[posts.length - 1];
        posts.pop();
    }

    function getPosts() public view returns (Post[] memory) {
        return posts;
    }
}