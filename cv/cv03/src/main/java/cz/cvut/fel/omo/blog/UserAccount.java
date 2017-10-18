package cz.cvut.fel.omo.blog;

/**
 * @author Lukas Forst
 * @date 10/17/17
 */
public class UserAccount extends Account {
    private boolean isActive = true;

    public UserAccount(String userName, String password, Blog blog ) {
        super(userName, password, blog);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public void writeNewPost(String title, String text) {

    }

    @Override
    public void readBlog() {

    }

    @Override
    public void readBlog(String topic) {

    }
}
