package com.revature.models;

import com.revature.util.RegexUtil;
import com.revature.web.dtos.Principal;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.*;

@Entity
@Table (name="USERS")
@SequenceGenerator(name="user_gen", sequenceName = "user_seq", allocationSize = 1)
public class User implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    private int userId;

    @NotNull @NotEmpty
    @Column(nullable = false, unique = true)
    private String username;

    @NotEmpty
    @NotNull
    @Pattern(regexp = RegexUtil.passwordRegex)
    @Column(nullable = false)
    private String password;

    @NotNull
    @Pattern(regexp = RegexUtil.emailRegex)
    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Role role;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name="WATCHLIST",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "media_id")
    )
    private List<Media> watchList;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name="Favorites",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "media_id")
    )
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

    public User(int userId, String username, Role role) {
        this.userId = userId;
        this.username = username;
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

    public void removeFromFavorite(Media media){
        favorites.remove(media);
    }

    public void addToWatchlist(Media newItem) {
        if(watchList == null) watchList = new ArrayList<>();
        watchList.add(newItem);
    }

    private void removeFromWatchlist(Media media){
        watchList.remove(media);
    }

    public Principal extractPrincipal(){
        return new Principal(this.userId, this.username, this.role);
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
