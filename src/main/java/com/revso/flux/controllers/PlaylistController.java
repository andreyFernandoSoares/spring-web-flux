package com.revso.flux.controllers;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revso.flux.models.Playlist;
import com.revso.flux.services.PlaylistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping("playlist")
public class PlaylistController {
	
	@Autowired
	private PlaylistService ps;
	
	@GetMapping("/all")
	public Flux<Playlist> getAll() {
		return ps.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Playlist> getById(@PathVariable Long id) {
		return ps.findById(id);
	}
	
	@PostMapping
	public Mono<Playlist> save(@RequestBody Playlist playlist) {
		return ps.save(playlist);
	}
	
	@GetMapping(value="/webflux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Playlist>> getPlaylistByWebflux(){
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<Playlist> playlistFlux = ps.findAll();
        return Flux.zip(interval, playlistFlux);
	}
}
