-- liquibase formatted sql
-- changeset name:1

create table Users (
    id bigserial primary key,
    email text not null,
    firstName text not null,
    lastName text not null,
    phone text not null,
    role text not null,
    image text,
    password text not null
);
create table Ad (
    id bigserial primary key,
    image text,
    price serial not null,
    title text not null,
    description text
);
create table Comment (
    idComment bigserial primary key,
    idUser serial not null,
    authorImage text,
    authorFirstName text not null,
    createdAt bigserial not null,
    message text not null,
    adId serial not null
);