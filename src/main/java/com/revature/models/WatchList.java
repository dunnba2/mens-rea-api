package com.revature.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name="WATCHLIST")
@SequenceGenerator(name = "watchlist_gen", sequenceName = "watchlist_seq", allocationSize = 1)
public class WatchList {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "watchlist_gen")
    private int id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_watch",
            joinColumns = @JoinColumn(name ="media_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Media> watchList;

    public WatchList(){
        super();
        watchList = new ArrayList<>();
    }

    public WatchList(int id, List<Media> watchList) {
        this.id = id;
        this.watchList = watchList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Media> getWatchList() {
        return watchList;
    }

    public void setWatchList(List<Media> watchList) {
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
