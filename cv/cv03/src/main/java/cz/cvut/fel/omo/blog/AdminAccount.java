package cz.cvut.fel.omo.blog;

/**
 * @author Lukas Forst
 * @date 10/17/17
 */
public class AdminAccount extends Account {

    public AdminAccount(String userName, String password, Blog blog) {
        super(userName, password, blog);
    }

    public void createNewTopic(String topic, String text) {

    }

    public void manageUserAccount(UserAccount account, boolean isActive){
        account.setActive(isActive);
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
