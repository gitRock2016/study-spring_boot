create table if not exists todo (
    todo_id int,
    todo_title varchar(30),
    finished boolean,
    created_at timestamp
);