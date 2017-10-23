package cz.cvut.fel.omo.blog.secured;

import cz.cvut.fel.omo.blog.Post;
import cz.cvut.fel.omo.blog.Topic;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    protected Account(String userName, String password, Blog blog, AccountPermissions... permissions) {
        this.userName = userName;
        this.password = password;
        this.blog = blog;

        accountPermissionsList = new ArrayList<>();
        accountPermissionsList.addAll(Arrays.asList(permissions));
    }

    public boolean hasPermission(AccountPermissions permission) {
        return accountPermissionsList.contains(permission);
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

    public void readBlog() {

    }

    public void readBlog(String topicTitle) {
        Optional<Topic> topic = blog.getAvailableTopics(this).stream().filter(x -> x.getText().equals(topicTitle)).findFirst();
        if (!topic.isPresent()) {
            System.out.println("Topic does not exists in this blog.");
        } else {
            System.out.println(topic.get().toString());
        }
    }

    public void addComment(Post post, String comment) {

    }
}

