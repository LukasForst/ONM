package cz.cvut.fel.omo.blog;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lukas Forst
 * @date 10/17/17
 */
public class Post {
    private Topic topic;
    private String text;

    private ArrayList<String> comments;

    public Post(Topic topic, String text) {
        this.topic = topic;
        this.text = text;

        comments = new ArrayList<>();
    }

    public Topic getTopic() {
        return topic;
    }

    public String getText() {
        return text;
    }

    public void registerToTopic(Topic topic){

    }

    public void publishPost(){

    }

    public void addComment(String comment){
        comments.add(comment);
    }

    public List<String> comments(){
        return comments;
    }
}
