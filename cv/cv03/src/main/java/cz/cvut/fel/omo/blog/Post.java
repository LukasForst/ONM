package cz.cvut.fel.omo.blog;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lukas Forst
 * @date 10/17/17
 */
public class Post {
    @Getter private Topic topic;
    @Getter private String text;
    @Getter private String title;

    private ArrayList<String> comments;

    public Post(String text, String title) {
        this.text = text;
        this.title = title;

        comments = new ArrayList<>();
    }

    public void registerToTopic(Topic topic){
        this.topic = topic;
    }

    public void publishPost(){

    }

    public void addComment(String comment){
        comments.add(comment);
    }

    public List<String> getComments(){
        return new ArrayList<>(comments);
    }
}
