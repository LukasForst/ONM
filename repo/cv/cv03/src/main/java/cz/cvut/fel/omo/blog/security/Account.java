package cz.cvut.fel.omo.blog.security;

import cz.cvut.fel.omo.blog.Dashboard;
import cz.cvut.fel.omo.blog.DisplayableComponent;
import cz.cvut.fel.omo.blog.Post;
import lombok.Getter;
import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lukas Forst
 * @date 10/17/17
 */
public abstract class Account {
    @Getter
    private final String userName;
    @Getter
    private final String password;

    private List<AccountPermissions> accountPermissionsList;

    protected final Blog blog;
    private Dashboard board;

    protected Account(String userName, String password, Blog blog, AccountPermissions... permissions) {
        this.userName = userName;
        this.password = password;
        this.blog = blog;

        accountPermissionsList = new ArrayList<>();
        accountPermissionsList.addAll(Arrays.asList(permissions));
        board = new Dashboard();
    }

    public boolean hasPermission(AccountPermissions permission) {
        return accountPermissionsList.contains(permission);
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

    public void readBlog() {
        val listToDisplay = new ArrayList<DisplayableComponent>();
        listToDisplay.addAll(blog.getAvailableTopics(this));
        board.display(listToDisplay, "Topics");
    }

    public void readBlog(String topicTitle) {
        val topic = blog.getAvailableTopics(this).stream().filter(x -> x.getTopicTitle().equals(topicTitle)).findFirst();
        if (!topic.isPresent()) {
            System.out.println("Topic does not exists in this blog.");
        } else {
            System.out.println(topic.get().toString());
        }
    }

    public void addComment(Post post, String comment) {
        post.addComment(comment);
    }
}

