CREATE TABLE client(
    id int NOT NULL AUTO_INCREMENT,
    client_name varchar(250),
    phone_number varchar(250),
    address text,
    PRIMARY KEY (id)
);

CREATE TABLE developer(
    id int NOT NULL AUTO_INCREMENT,
    developer_name varchar(250),
    phone_number varchar(250),
    address text,
    UNIQUE (phone_number),
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

CREATE TABLE developer_project (
    id int NOT NULL AUTO_INCREMENT,
    project_id int NOT NULL,
    developer_id int NOT NULL,
    status varchar(50),
    FOREIGN KEY (project_id) REFERENCES project(id),
    FOREIGN KEY (developer_id) REFERENCES developer(id),
    PRIMARY KEY (id)
);