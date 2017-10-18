package cz.cvut.fel.omo.blog;

/**
 * @author Lukas Forst
 * @date 10/17/17
 */
public abstract class Account {
    private final String userName;
    private final String password;

    private final Blog blog;

    protected Account(String userName, String password, Blog blog) {
        this.userName = userName;
        this.password = password;
        this.blog = blog;
    }

    public String getUserName() {
        return userName;
    }

    public boolean verifyPassword(String password){
        return this.password.equals(password);
    }

    public abstract void writeNewPost(String title, String text);
    public abstract void readBlog();
    public abstract void readBlog(String topic);
}
