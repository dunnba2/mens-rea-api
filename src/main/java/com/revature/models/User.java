package com.revature.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table (name="USERS")
@SequenceGenerator(name="user_gen", sequenceName = "user_seq", allocationSize = 1)
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    private int userId;

    @JoinColumn(nullable = false, unique = true)
    @ManyToOne(cascade = CascadeType.ALL)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Role role;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_watch",
            joinColumns = @JoinColumn(name ="media_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Media> watchList;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_fav",
            joinColumns = @JoinColumn(name ="media_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Media> favorites;

    public User() {
        super();
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(int userId, String username, String password, Role role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Media> getWatchList() {
        return watchList;
    }

    public void setWatchList(List<Media> watchList) {
        this.watchList = watchList;
    }

    public List<Media> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Media> favorites) {
        this.favorites = favorites;
    }

    public void addFavorite(Media fav) {
        if(favorites == null) favorites = new ArrayList<>();
        favorites.add(fav);
    }

    public void addToWatchlist(Media newItem) {
        if(watchList == null) watchList = new ArrayList<>();
        watchList.add(newItem);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
