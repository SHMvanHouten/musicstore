package com.github.shmvanhouten.musicstore.Artist;

import java.util.List;

public interface ArtistRepository {
    List<Artist> getAll();

    Long addArtist(String name);

    Artist getById(Long id);
}
