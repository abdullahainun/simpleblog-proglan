package aal.blog.session;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import aal.blog.model.User;

import java.math.BigDecimal;
import java.util.List;

@Component
@Scope("session")
public class UserSession {
    private int pages;
    private int count = 10;
    private User user;

    public int getPages() {
        return pages;
    }

    public void setPages(List list, int count) {
        pages = BigDecimal.valueOf((double) list.size() / count).setScale(0, BigDecimal.ROUND_CEILING).intValue();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
