CREATE TABLE tb_publisher (
    publisher_id SERIAL PRIMARY KEY,
    publisher_name VARCHAR(120) NOT NULL UNIQUE,
    country VARCHAR(60)
);

CREATE TABLE tb_book (
    book_id SERIAL PRIMARY KEY,
    publisher_id INTEGER NOT NULL,
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
    author_name VARCHAR(255) NOT NULL UNIQUE,
    nacionality VARCHAR(100) NOT NULL
);

CREATE TABLE book_author (
    book_id INTEGER REFERENCES tb_book(book_id),
    author_id INTEGER REFERENCES tb_author(author_id),
    PRIMARY KEY (book_id, author_id)
);

CREATE TABLE tb_genre (
    genre_id SERIAL PRIMARY KEY,
    genre_name VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE book_genre (
    book_id INTEGER REFERENCES tb_book(book_id),
    genre_id INTEGER REFERENCES tb_genre(genre_id),
    PRIMARY KEY (book_id, genre_id)
);

CREATE TABLE book_copy (
    book_copy_id SERIAL PRIMARY KEY,
    book_id INTEGER,
    asset_tag VARCHAR(14) NOT NULL UNIQUE,
    status VARCHAR(20) NOT NULL DEFAULT 'AVAILABLE',
    copy_number SMALLINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    FOREIGN KEY (book_id) REFERENCES tb_book(book_id)
)