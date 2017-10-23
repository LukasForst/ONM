package cz.cvut.fel.omo.blog;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lukas Forst
 * @date 10/17/17
 */
public class Topic {

    @Getter private final String topicTitle;
    @Getter private final String text;

    private final ArrayList<Post> posts;

    public Topic(String topicTitle,String text, Post ... argsPosts){
        this.topicTitle = topicTitle;
        this.text = text;

        posts = new ArrayList<>();
        posts.addAll(Arrays.asList(argsPosts));
    }

    public void addPost(Post post){
        posts.add(post);
    }

    public List<Post> getPostsFromTopic(){
        return new ArrayList<>(posts);
    }

    @Override
    public String toString() {
        return "Topic{" +
                "Title='" + topicTitle + '\'' +
                ", Description='" + text + '\'' +
                ", posts=" + Arrays.toString(posts.toArray()) +
                '}';
    }
}
