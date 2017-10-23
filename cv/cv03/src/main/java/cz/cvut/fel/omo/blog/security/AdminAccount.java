package cz.cvut.fel.omo.blog.security;

import cz.cvut.fel.omo.blog.Post;
import cz.cvut.fel.omo.blog.Topic;

/**
 * @author Lukas Forst
 * @date 10/17/17
 */
public class AdminAccount extends Account {

    public AdminAccount(String userName, String password, Blog blog) {
        super(userName, password, blog, AccountPermissions.values());
    }

    public void createNewTopic(String topic, String text) {
        blog.createTopic(this, new Topic(topic, text));
    }

    public void manageUserAccount(UserAccount account, boolean isActive) {
        account.setActive(isActive);
    }

    public void writeNewPost(String title, String text) {
        blog.writePost(this, new Post(title, text));
    }
}
