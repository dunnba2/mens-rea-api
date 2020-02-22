package com.revature.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.util.RegexUtil;
import com.revature.web.dtos.Principal;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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

    @JsonIgnore
    @NotEmpty
    @NotNull
    @Pattern(regexp = RegexUtil.passwordRegex)
    @Column(nullable = false)
    private String password;

    @NotNull
    @Pattern(regexp = RegexUtil.emailRegex)
    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;


    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name="WATCHLIST",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "media_id")
    )
    private List<Media> watchList;


    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name="Favorites",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "media_id")
    )
    private List<Media> favorites;

    @JsonBackReference
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    public User() {
        super();
    }

    public User(int userId) {
        this.userId = userId;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(int userId, String username, Role role) {
        this.userId = userId;
        this.username = username;
        this.role = role;
    }

    public User(String username,  String password, String email, Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User(int userId, String username, String password, Role role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(int userId, @NotNull @NotEmpty String username, @NotEmpty @NotNull @Pattern(regexp = RegexUtil.passwordRegex) String password, @NotNull @Pattern(regexp = RegexUtil.emailRegex) String email, Role role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User(int userId, @NotNull @NotEmpty String username, @NotEmpty @NotNull @Pattern(regexp = RegexUtil.passwordRegex) String password, @NotNull @Pattern(regexp = RegexUtil.emailRegex) String email, Role role, List<Media> watchList, List<Media> favorites) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.watchList = watchList;
        this.favorites = favorites;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void addFavorite(Media media) {
        if(favorites == null) favorites = new ArrayList<>();
        favorites.add(media);
    }

    public void removeFromFavorite(Media media){
        favorites.remove(media);
    }

    public void addToWatchlist(Media newItem) {
        if(watchList == null) watchList = new ArrayList<>();
        watchList.add(newItem);
    }

    public void addReview(Review review) {
        if (reviews == null) reviews = new ArrayList<>();
        review.setUser(this);
        reviews.add(review);
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
                Objects.equals(email, user.email) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, email, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
