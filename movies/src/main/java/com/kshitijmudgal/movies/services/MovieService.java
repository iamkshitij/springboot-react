package com.kshitijmudgal.movies.services;

import java.util.List;
import java.util.Optional;

import com.kshitijmudgal.movies.pojo.Movie;
import com.kshitijmudgal.movies.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(ObjectId id){
       return movieRepository.findById(id);
    }

    public Optional<Movie> singleMovieImdb(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
