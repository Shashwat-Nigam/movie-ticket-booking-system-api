package com.example.mtb.repository;

import com.example.mtb.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, String> {
    //finding shows by theater id
    List<Show> findByTheaterTheaterId(String theaterId);

    //finding shows by movie id
    List<Show> findByMovieMovieId(String movieId);

    //finding shows by screen Id
    List<Show> findByScreenScreenId(String screenId);

}
