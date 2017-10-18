package cz.cvut.fel.omo.blog;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Lukas Forst
 * @date 10/17/17
 */
public class Blog {
    private ArrayList<Account> accounts;
    private ArrayList<Topic> topics;
    private ArrayList<Post> posts;

    public Blog() {
        accounts = new ArrayList<>();
        topics = new ArrayList<>();
        posts = new ArrayList<>();
    }

    public void createNewAccount(String username, String password, boolean isAdmin) {
        if(!isAdmin){
            accounts.add(new UserAccount(username, password, this ));
        } else{
            accounts.add(new AdminAccount(username, password, this ));
        }
    }

    public Optional<Account> login(String username, String password) {
        return accounts.stream().filter(a -> username.equals(a.getUserName()) && a.verifyPassword(password)).findFirst();
    }

    public Optional<Post> findPost(String topic) {
        return posts.stream().filter(post -> topic.equals(post.getTopic().getTopicTitle())).findFirst();
    }

    public Optional<Topic> findTopic(String title) {
        return topics.stream().filter(topic -> title.equals(topic.getTopicTitle())).findFirst();
    }

    public void displayTopics(){

    }
}
