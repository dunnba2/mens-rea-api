package com.revature.models;

import com.revature.models.mediatypes.Book;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "FAVBOOK")
@SequenceGenerator(name = "favbook_gen", sequenceName = "favbook_seq", allocationSize = 1)
public class FavBook {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "favbook_gen")
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
    private Set<Book> favoriteBook;

    public FavBook() {
        super();
        favoriteBook = new HashSet<>();
    }

    public FavBook(User owner, Set<Book> favoriteBook) {
        this.owner = owner;
        this.favoriteBook = favoriteBook;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<Book> getFavoriteBook() {
        return favoriteBook;
    }

    public void setFavoriteBook(Set<Book> favoriteBook) {
        this.favoriteBook = favoriteBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavBook favBook = (FavBook) o;
        return Objects.equals(owner, favBook.owner) &&
                Objects.equals(favoriteBook, favBook.favoriteBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, favoriteBook);
    }

    @Override
    public String toString() {
        return "FavBook{" +
                "owner=" + owner +
                ", favoriteBook=" + favoriteBook +
                '}';
    }
}
