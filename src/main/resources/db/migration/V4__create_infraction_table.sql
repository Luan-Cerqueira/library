CREATE TABLE tb_infraction (
    infraction_id SERIAL PRIMARY KEY,
    loan_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    occurrence_date TIMESTAMP NOT NULL DEFAULT NOW(),
    reason VARCHAR(20) NOT NULL,
    FOREIGN KEY (loan_id) REFERENCES tb_loan (loan_id),
    FOREIGN KEY (user_id) REFERENCES tb_user (user_id)
)