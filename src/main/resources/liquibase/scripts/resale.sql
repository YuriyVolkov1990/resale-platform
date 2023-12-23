-- liquibase formatted sql
-- changeset name:1

create table Users (
    id bigserial primary key,
    email text not null,
    firstName text,
    lastName text,
    phone text,
    role text,
    image text,
    password text not null
);
create table Ad (
    id bigserial primary key,
    image text,
    price serial not null,
    title text not null,
    description text,
    comments text,
    image not null
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
create table Image (
    id bigserial primary key,
    path text not null,
    fileSize int8 not null,
    mediaType text not null,
    data bytea not null
)