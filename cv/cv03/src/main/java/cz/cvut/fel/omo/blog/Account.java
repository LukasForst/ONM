package cz.cvut.fel.omo.blog;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lukas Forst
 * @date 10/17/17
 */
public abstract class Account {
    @Getter private final String userName;
    @Getter private final String password;

    private List<AccountPermissions> accountPermissionsList;

    protected final Blog blog;

    protected Account(String userName, String password, Blog blog, AccountPermissions ... permissions) {
        this.userName = userName;
        this.password = password;
        this.blog = blog;

        accountPermissionsList = new ArrayList<>();
        accountPermissionsList.addAll(Arrays.asList(permissions));
    }

    public boolean hasPermission(AccountPermissions permission){
        return accountPermissionsList.contains(permission);
    }

    public boolean verifyPassword(String password){
        return this.password.equals(password);
    }

    public void readBlog(){

    }
    public void readBlog(String topic){

    }

    public void addComment(Post post, String comment){

    }
}

