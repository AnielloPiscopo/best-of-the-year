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
public class SongsController {
	private List<Song> bestSongsList = new ArrayList<>();
	
	private void setBestSongs() {
		String[] bestSongs = {"asasasdd" , "aqwes" , "as123dd"};
		int bestSongsLng = bestSongs.length;
		for(int i=0 ; i<bestSongsLng ; i++) {
			Song s = new Song(i+1 , bestSongs[i]);
			bestSongsList.add(s);
		}
	}
	
	private List<Song> getBestSongs(){
		if(bestSongsList.isEmpty()) setBestSongs();
		return bestSongsList;
	}
	
	private String getSongsTitle(List<Song> songs) {
		int songsLng = songs.size();
		String songsTitles = "";
		for(int i=0 ; i<songsLng; i++) {
			songsTitles += songs.get(i).getTitle()
					+ ((i == songsLng-1) ? "." : " , "); 
		}
		return songsTitles;
	}
	
	private Song getSong(List<Song> songs , int id) {
		Song selectedSong = null ;
		int songsListLng = songs.size();
		for(int i=0 ; i<songsListLng; i++) {
			if(songs.get(i) == songs.get(id)) {
				selectedSong = songs.get(i);
				break;
			};
		}
		return selectedSong;
	}
	
	@GetMapping("/songs")
	public String showBestMovies(Model model) {
		String bestSongsTitle = getSongsTitle(getBestSongs());
		model.addAttribute("resources" , bestSongsTitle);
		model.addAttribute("type" , "songs");
		
		return "resources";
	}
	
	@GetMapping("/songs/{id}")
	public String showBestMovie(Model model , @PathVariable("id") int id) {
		String selecteSongTitle = getSong(getBestSongs(),id-1).getTitle();
		model.addAttribute("resources" , selecteSongTitle);
		model.addAttribute("type" , "songs");
		
		return "resources";
	}
}
