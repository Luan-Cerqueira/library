CREATE TYPE loan_status AS ENUM('ACTIVE', 'RETURNED', 'OVERDUE');

CREATE TABLE tb_loan (
    loan_id SERIAL PRIMARY KEY,
    user_id SERIAL NOT NULL,
    book_copy_id SERIAL NOT NULL,
    loan_date TIMESTAMP NOT NULL DEFAULT NOW(),
    due_date TIMESTAMP NOT NULL,
    return_date TIMESTAMP NOT NULL,
    status loan_status NOT NULL,
    FOREIGN KEY (user_id) REFERENCES tb_user(user_id),
    FOREIGN KEY (book_copy_id) REFERENCES book_copy(book_copy_id)
);