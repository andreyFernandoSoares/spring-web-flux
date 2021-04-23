package com.revso.flux.facades;

import org.springframework.stereotype.Component;

import com.revso.flux.models.Playlist;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public interface PlaylistFacade {
	
	Flux<Playlist> findAll();
	
	Mono<Playlist> findById(Long id);
	
	Mono<Playlist> save(Playlist playlist);
}
