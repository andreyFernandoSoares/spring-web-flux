package com.revso.flux.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revso.flux.facades.PlaylistFacade;
import com.revso.flux.models.Playlist;
import com.revso.flux.repositories.PlaylistRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistService implements PlaylistFacade {
	
	@Autowired
	private PlaylistRepository pr;

	@Override
	public Flux<Playlist> findAll() {
		return pr.findAll();
	}

	@Override
	public Mono<Playlist> findById(Long id) {
		return pr.findById(id);
	}

	@Override
	public Mono<Playlist> save(Playlist playlist) {
		return pr.save(playlist);
	}

}
