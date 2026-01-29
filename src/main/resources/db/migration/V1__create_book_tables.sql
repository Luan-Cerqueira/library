CREATE TABLE tb_publisher (
    publisher_id SERIAL PRIMARY KEY,
    publisher_name VARCHAR(120) NOT NULL UNIQUE,
    country VARCHAR(60)
);

CREATE TABLE tb_book (
    book_id SERIAL PRIMARY KEY,
    publisher_id SERIAL NOT NULL,
    isbn VARCHAR(13) NOT NULL,
    title VARCHAR(100) NOT NULL,
    language VARCHAR(20) NOT NULL,
    publication_date DATE NOT NULL,
    print_length SMALLINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    FOREIGN KEY (publisher_id) REFERENCES tb_publisher(publisher_id)
);

CREATE TABLE tb_author (
    author_id SERIAL PRIMARY KEY,
    author_name VARCHAR(255) NOT NULL,
    nacionality VARCHAR(100) NOT NULL
);

CREATE TABLE book_author (
    book_id SERIAL REFERENCES tb_book(book_id),
    author_id SERIAL REFERENCES tb_author(author_id),
    PRIMARY KEY (book_id, author_id)
);

CREATE TABLE tb_genre (
    genre_id SERIAL PRIMARY KEY,
    genre_name VARCHAR(20) NOT NULL
);

CREATE TABLE book_genre (
    book_id SERIAL REFERENCES tb_book(book_id),
    genre_id SERIAL REFERENCES tb_genre(genre_id),
    PRIMARY KEY (book_id, genre_id)
);

CREATE TYPE book_copy_status AS ENUM ('AVAILABLE', 'NOT AVAILABLE', 'DAMAGED');

CREATE TABLE book_copy (
    book_copy_id SERIAL PRIMARY KEY,
    book_id SERIAL,
    asset_tag VARCHAR(20) NOT NULL,
    status book_copy_status NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
)