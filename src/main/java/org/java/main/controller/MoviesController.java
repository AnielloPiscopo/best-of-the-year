package org.java.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.main.obj.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/resources")
public class MoviesController {
	private List<Movie> bestMoviesList = new ArrayList<>();
	
	private void setBestMovies() {
		String[] bestMovies = {"asd" , "as" , "asdd"};
		int bestMoviesLng = bestMovies.length;
		for(int i=0 ; i<bestMoviesLng ; i++) {
			Movie m = new Movie(i+1 , bestMovies[i]);
			bestMoviesList.add(m);
		}
	}
	
	private List<Movie> getBestMovies(){
		if(bestMoviesList.isEmpty()) setBestMovies();
		return bestMoviesList;
	}
	
	private String getMoviesTitle(List<Movie> movies) {
		int moviesLng = movies.size();
		String moviesTitles = "";
		for(int i=0 ; i<moviesLng; i++) {
			moviesTitles += movies.get(i).getTitle()
					+ ((i == moviesLng-1) ? "." : " , "); 
		}
		return moviesTitles;
	}
	
	private Movie getMovie(List<Movie> movies , int id) {
		Movie selectedMovie = null ;
		int moviesListLng = movies.size();
		for(int i=0 ; i<moviesListLng; i++) {
			if(movies.get(i) == movies.get(id)) {
				selectedMovie = movies.get(i);
				break;
			};
		}
		return selectedMovie;
	}
	
	@GetMapping("/movies")
	public String showBestMovies(Model model) {
		String bestMoviesTitle = getMoviesTitle(getBestMovies());
		model.addAttribute("resources" , bestMoviesTitle);
		model.addAttribute("type" , "movies");
		
		return "resources";
	}
	
	@GetMapping("/movies/{id}")
	public String showBestMovie(Model model , @PathVariable("id") int id) {
		String selectedMovieTitle = getMovie(getBestMovies(),id-1).getTitle();
		model.addAttribute("resources" , selectedMovieTitle);
		model.addAttribute("type" , "movies");
		
		return "resources";
	}
}
