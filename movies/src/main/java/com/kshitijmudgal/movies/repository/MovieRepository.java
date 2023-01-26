package com.kshitijmudgal.movies.repository;

import java.util.Optional;

import com.kshitijmudgal.movies.pojo.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    
    Optional<Movie> findMovieByImdbId(String imdbId);

}
