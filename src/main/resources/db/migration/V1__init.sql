CREATE TABLE client(
    id int NOT NULL AUTO_INCREMENT,
    client_name varchar(250),
    phone_number varchar(250),
    PRIMARY KEY (id)
);

CREATE TABLE project (
    id int NOT NULL AUTO_INCREMENT,
    client_id int NOT NULL,
    project_name varchar(250),
    address text,
    FOREIGN KEY (client_id) REFERENCES client(id),
    PRIMARY KEY (id)
);