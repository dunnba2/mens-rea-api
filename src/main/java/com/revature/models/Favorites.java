package com.revature.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "FAVORITES")
@SequenceGenerator(name = "fav_gen", sequenceName = "fav_seq", allocationSize = 1)
public class Favorites {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fav_gen")
    private User owner;

    /*@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_fav",
            joinColumns = @JoinColumn(name ="media_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
  */

    @JoinColumn
    @ManyToOne(cascade = {
            CascadeType.REMOVE, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST
    })
    private Set<Media> favoriteMedia;

    public Favorites(){
        super();
        favoriteMedia = new HashSet<>();
    }

    public Favorites(User owner, Set<Media> favoriteMedia) {
        this.owner = owner;
        this.favoriteMedia = favoriteMedia;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<Media> getFavoriteMedia() {
        return favoriteMedia;
    }

    public void setFavoriteMedia(Set<Media> favoriteMedia) {
        this.favoriteMedia = favoriteMedia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favorites favorites = (Favorites) o;
        return Objects.equals(owner, favorites.owner) &&
                Objects.equals(favoriteMedia, favorites.favoriteMedia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, favoriteMedia);
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "owner=" + owner +
                ", favoriteBooks=" + favoriteMedia +
                '}';
    }
}
