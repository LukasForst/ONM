package cz.cvut.fel.omo.blog.secured;

import com.sun.istack.internal.NotNull;
import cz.cvut.fel.omo.blog.Post;
import cz.cvut.fel.omo.blog.Topic;
import lombok.val;

import java.util.ArrayList;
import java.util.List;
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

    public void createNewAccount(@NotNull String username, @NotNull String password, boolean isAdmin) {
        if (!isAdmin) {
            accounts.add(new UserAccount(username, password, this));
        } else {
            accounts.add(new AdminAccount(username, password, this));
        }
    }

    public Optional<Account> login(@NotNull String username, @NotNull String password) {
        return accounts.stream().filter(a -> username.equals(a.getUserName()) && a.verifyPassword(password)).findFirst();
    }

    public Optional<Post> findPost(@NotNull String topic) {
        return posts.stream().filter(post -> topic.equals(post.getTopic().getTopicTitle())).findFirst();
    }

    public Optional<Topic> findTopic(@NotNull String title) {
        return topics.stream().filter(topic -> title.equals(topic.getTopicTitle())).findFirst();
    }

    public void displayTopics() {
        System.out.println(topics.toString());
    }

    void writePost(@NotNull Account account, @NotNull Post post) {
        if (account.hasPermission(AccountPermissions.WRITE_POST)) {
            posts.add(post);
        } else {
            throw new IllegalStateException("This account does not have permission to post new article to the blog!");
        }
    }

    void createTopic(@NotNull Account account, @NotNull Topic topic) {
        if (account.hasPermission(AccountPermissions.CREATE_TOPIC)) {
            topics.add(topic);
        } else {
            throw new IllegalStateException("This account does not have permission to create new topic in the blog!");
        }
    }

    List<Topic> getAvailableTopics(@NotNull Account account) {
        if (account.hasPermission(AccountPermissions.SEE_TOPICS)) {
            val returnList = new ArrayList<Topic>();
            topics.forEach(topic -> {
                val tmpTopic = new Topic(topic.getTopicTitle(), topic.getText());
                topic.getPostsFromTopic().forEach(tmpTopic::addPost);
                returnList.add(tmpTopic);
            });
            return returnList;
        } else {
            throw new IllegalStateException("This account does not have permission to see topics in the blog!");
        }
    }
}
