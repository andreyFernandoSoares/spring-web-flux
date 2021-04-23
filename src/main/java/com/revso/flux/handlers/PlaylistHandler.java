package com.revso.flux.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import com.revso.flux.models.Playlist;
import com.revso.flux.services.PlaylistService;

import reactor.core.publisher.Mono;

//@Component
public class PlaylistHandler {
	
	@Autowired
	private PlaylistService ps;
	
	public Mono<ServerResponse> findAll(ServerRequest request) {
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(ps.findAll(), Playlist.class);
	}
	
	public Mono<ServerResponse> findById(ServerRequest request) {
		Long id = Long.parseLong(request.pathVariable("id"));
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(ps.findById(id), Playlist.class);
	}
	
	public Mono<ServerResponse> save(ServerRequest request) {
		final Mono<Playlist> playlist = request.bodyToMono(Playlist.class);
		
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromPublisher(playlist.flatMap(ps::save), Playlist.class));
	}
}
