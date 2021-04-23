package com.revso.flux.routers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

import com.revso.flux.handlers.PlaylistHandler;

//@Configuration
public class PlaylistRouter {
	
	//@Bean
	public RouterFunction<ServerResponse> route(PlaylistHandler handler) {
		return RouterFunctions
				.route(GET("/playlist/all").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
				.andRoute(GET("/playlist/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
				.andRoute(POST("/playlist").and(accept(MediaType.APPLICATION_JSON)), handler::save);
				
	}
}
