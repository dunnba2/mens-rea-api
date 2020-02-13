package com.revature.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="WATCHLIST")
@SequenceGenerator(name = "watchlist_gen", sequenceName = "watchlist_seq", allocationSize = 1)
public class WatchList {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "watchlist_gen")
    private int id;

    //@OneToMany(mappedBy = "USERS", cascade = CascadeType.ALL)

    @JoinColumn
    @ManyToOne(cascade = {
            CascadeType.REMOVE, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST
    })
    private Set<Media> watchList;

    public WatchList(){
        super();
        watchList = new HashSet<>();
    }

    public WatchList(int id, Set<Media> watchList) {
        this.id = id;
        this.watchList = watchList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Media> getWatchList() {
        return watchList;
    }

    public void setWatchList(Set<Media> watchList) {
        this.watchList = watchList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WatchList watchList1 = (WatchList) o;
        return id == watchList1.id &&
                Objects.equals(watchList, watchList1.watchList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, watchList);
    }

    @Override
    public String toString() {
        return "WatchList{" +
                "id=" + id +
                ", watchList=" + watchList +
                '}';
    }
}
