-- liquibase formatted sql
-- changeset name:1

create table Users (
    id bigserial primary key,
    email text not null,
    first_name text,
    last_name text,
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
    description text
);
create table Comment (
    id_comment bigserial primary key,
    id_user serial not null,
    author_image text,
    author_first_name text not null,
    created_at bigserial not null,
    message text not null
);
create table Image (
    id bigserial primary key,
    path text not null,
    file_size int8 not null,
    media_type text not null,
    data bytea not null
);