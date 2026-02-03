CREATE TABLE tb_loan (
    loan_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    book_copy_id INTEGER NOT NULL,
    loan_date TIMESTAMP NOT NULL DEFAULT NOW(),
    due_date TIMESTAMP NOT NULL,
    return_date TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    FOREIGN KEY (user_id) REFERENCES tb_user(user_id),
    FOREIGN KEY (book_copy_id) REFERENCES book_copy(book_copy_id)
);