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
public class Topic implements DisplayableComponent {

    @Getter
    private final String topicTitle;
    @Getter
    private final String text;

    private final ArrayList<Post> posts;

    public Topic(String topicTitle, String text, Post... argsPosts) {
        this.topicTitle = topicTitle;
        this.text = text;

        posts = new ArrayList<>();
        posts.addAll(Arrays.asList(argsPosts));
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public List<Post> getPostsFromTopic() {
        return new ArrayList<>(posts);
    }

    @Override
    public String toString() {
        return "TOPIC:\n\tTitle: " + topicTitle + "\n\tText: " + text + "\n\tNo. of posts: " + posts.size();
    }

    @Override
    public void displayComponent() {
        System.out.println(this.toString());
    }
}
