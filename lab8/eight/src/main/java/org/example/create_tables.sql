
CREATE TABLE IF NOT EXISTS albums
(
    id INT NOT NULL,
    release_year INT NOT NULL,
    name TEXT NOT NULL,
    artist TEXT NOT NULL,
    genre TEXT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS artists
(
    id INT NOT NULL,
    name TEXT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS genres
(
    id INT NOT NULL,
    name TEXT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE album_genres (
                              album_id INT NOT NULL,
                              genre_id INT NOT NULL,
                              PRIMARY KEY (album_id, genre_id),
                              FOREIGN KEY (album_id) REFERENCES albums(id),
                              FOREIGN KEY (genre_id) REFERENCES genres(id)
);
select * from artists;