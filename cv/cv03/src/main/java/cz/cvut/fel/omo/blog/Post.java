package cz.cvut.fel.omo.blog;

import lombok.Getter;
import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lukas Forst
 * @date 10/17/17
 */
public class Post implements DisplayableComponent {
    @Getter
    private Topic topic;
    @Getter
    private String text;
    @Getter
    private String title;

    private ArrayList<String> comments;

    public Post(String title, String text) {
        this.text = text;
        this.title = title;

        comments = new ArrayList<>();
    }

    public void registerToTopic(Topic topic) {
        this.topic = topic;
        topic.addPost(this);
    }

    public void publishPost() {

    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public List<String> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public String toString() {
        val sb = new StringBuilder();
        sb.append("POST:\n\t");
        if(topic != null){
            sb.append("Topic: ").append(topic.getTopicTitle()).append("\n\t");
        }
        sb.append("Title: ").append(title).append("\n\tText: ").append(text);
        return sb.toString();
    }

    @Override
    public void displayComponent() {
        System.out.println(this.toString());
    }
}
