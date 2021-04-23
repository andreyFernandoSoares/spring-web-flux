package com.revso.flux.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.revso.flux.models.Playlist;

@Repository
public interface PlaylistRepository extends ReactiveCrudRepository<Playlist, Long> {

}
