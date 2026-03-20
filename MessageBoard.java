import java.util.*;
import java.time.LocalDate;
import java.io.*;
import java.time.format.DateTimeFormatter;


public class MessageBoard implements Serializable {
    private List<Post> posts;
    private String boardName;

    public MessageBoard(String boardName) {
        this.boardName = boardName;
        this.posts = new ArrayList<>();
    }

        public String getBoardName() {
        return boardName;
    }

    public int[] getPostIDs() {
        int[] postIDs = new int[posts.size()];
        int i = 0;
        for (Post post : posts) {
            postIDs[i++] = post.getPostID();
        }
        return postIDs;
    }

    public int getPostIndex(int postID) throws IDInvalidException {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getPostID() == postID) {
                return i;
            }
        }
        throw new IDInvalidException("Invalid post ID.");
    }

    public int addPost(String author, String subject, String message) throws IllegalArgumentException{
        Post newPost = new Post(author, subject, message);
        posts.add(newPost);
        return newPost.getPostID();
    }

    public int addPost(String author, String subject, String message){
        Post newPost = new Post(author, subject, message, date)
    }

    public String getFormattedPost(int postID) throws IDInvalidException{
        for(Post post : posts){
            if(post.getPostID() == postID){
                return post.toFormattedString();
            }
        }
        throw new IDInvalidException("Post is not on message board");
    }

    public int[] searchPostsBySubject(String keyword){
        int num = 0;
        for(Post post : posts){
            if(post.getSubject().contains(keyword)){
                num++;
            }
        }
        int[] postsBySubject = new int[num];
        num = 0;
        for(Post post : posts){
            if(post.getSubject().contains(keyword)){
                postsBySubject[num++] = post.getPostID();
            }
        }
        return postsBySubject;
    }

    public void deletePost(int postID) throws IDInvalidException{
        boolean foundPost = false;
        for(int i = 0; i<posts.size(); i++){
            if(posts.get(i).getPostID() == postID){
                posts.remove(i);
                foundPost = true;
            }
        }
        if(!foundPost){
            throw new IDInvalidException("Post ID not found, cannot be deleted");
        }
    }
}