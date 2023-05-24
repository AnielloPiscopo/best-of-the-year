package org.java.main.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.java.main.obj.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/resources")
public class MyController {
	
	@GetMapping("/best")
	public String printMessage(Model model,
			@RequestParam(name = "name") String name) {
		model.addAttribute("name", name);
		
		return "index";
	}
	
	private List<Movie> getBestMovies(){
		List<Movie> bestMoviesList = new ArrayList<>();
		String[] bestMovies = {"asd" , "as" , "asdd"};
		int bestMoviesLng = bestMovies.length;
		for(int i=0 ; i<bestMoviesLng ; i++) {
			Movie m = new Movie(i+1 , bestMovies[i]);
			bestMoviesList.add(m);
		}
		
		return bestMoviesList;
	}
	
	private String getMoviesTitle(List<Movie> moviesList) {
		int bestMoviesListLng = moviesList.size();
		String bestMoviesTitles = "";
		for(int i=0 ; i<bestMoviesListLng; i++) {
			bestMoviesTitles += moviesList.get(i).getTitle() + " , "; 
		}
		return bestMoviesTitles;
	}
//	private List<Song> getBestSongs(){}
	
	@GetMapping("/movies")
	public String showBestMovies(Model model) {
		String bestMoviesTitle = getMoviesTitle(getBestMovies());
		model.addAttribute("movies" , bestMoviesTitle);
		
		return "movies";
	}
}
