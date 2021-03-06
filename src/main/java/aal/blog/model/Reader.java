package aal.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "readers")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long readerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    public Reader() {
    }

    public Reader(long readerId, User user) {
        this.readerId = readerId;
        this.user = user;
    }

    public Reader(long id, long userId, long readerId) {
        this.id = id;
        this.user = new User();
        this.user.setUserId(userId);
        this.readerId = readerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getReaderId() {
        return readerId;
    }

    public void setReaderId(long readerId) {
        this.readerId = readerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
