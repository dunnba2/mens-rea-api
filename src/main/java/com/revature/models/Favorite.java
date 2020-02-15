package com.revature.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "FAVORITES")
@SequenceGenerator(name = "fav_gen", sequenceName = "fav_seq", allocationSize = 1)
public class Favorite {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fav_gen")
    private User owner;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_fav",
            joinColumns = @JoinColumn(name ="media_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Media> favoriteMedia;

    /*@JoinColumn
    @ManyToOne(cascade = {
            CascadeType.REMOVE, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST
    })*/


    public Favorite(){
        super();
        favoriteMedia = new ArrayList<>();
    }

    public Favorite(User owner, List<Media> favoriteMedia) {
        this.owner = owner;
        this.favoriteMedia = favoriteMedia;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Media> getFavoriteMedia() {
        return favoriteMedia;
    }

    public void setFavoriteMedia(List<Media> favoriteMedia) {
        this.favoriteMedia = favoriteMedia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favorite favorite = (Favorite) o;
        return Objects.equals(owner, favorite.owner) &&
                Objects.equals(favoriteMedia, favorite.favoriteMedia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, favoriteMedia);
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "owner=" + owner +
                ", favoriteMedia=" + favoriteMedia +
                '}';
    }
}
