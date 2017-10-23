package cz.cvut.fel.omo.blog.security;

import com.sun.istack.internal.NotNull;
import cz.cvut.fel.omo.blog.Dashboard;
import cz.cvut.fel.omo.blog.DisplayableComponent;
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
public class Blog  implements DisplayableComponent {
    private ArrayList<Account> accounts;
    private ArrayList<Topic> topics;
    private ArrayList<Post> posts;

    private Dashboard board;
    public Blog() {
        accounts = new ArrayList<>();
        topics = new ArrayList<>();
        posts = new ArrayList<>();

        board = new Dashboard();
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

    public Optional<Post> findPost(@NotNull String postTitle) {
        return posts.stream().filter(post -> postTitle.equals(post.getTitle())).findFirst();
    }

    public Optional<Topic> findTopic(@NotNull String title) {
        return topics.stream().filter(topic -> title.equals(topic.getTopicTitle())).findFirst();
    }

    public void displayTopics() {
        val listToDisplay = new ArrayList<DisplayableComponent>();
        listToDisplay.addAll(topics);
        board.display(listToDisplay, "Topics");
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
            return new ArrayList<Topic>(topics);
        } else {
            throw new IllegalStateException("This account does not have permission to see topics in the blog!");
        }
    }

    @Override
    public String toString() {
        val sb = new StringBuilder();
        sb.append("List of topics:\n");
        topics.forEach(sb::append);
        sb.append("List of posts:\n");
        posts.forEach(sb::append);

        return sb.toString();
    }

    @Override
    public void displayComponent() {
        System.out.println(this.toString());
    }
}
