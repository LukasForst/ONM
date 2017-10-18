package cz.cvut.fel.omo.blog;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Lukas Forst
 * @date 10/17/17
 */
public class UserAccount extends Account {

    @Getter
    @Setter
    private boolean isActive = true;

    public UserAccount(String userName, String password, Blog blog ) {
        super(userName, password, blog, AccountPermissions.COMMENT, AccountPermissions.SEE_TOPICS);
    }
}
