-- liquibase formatted sql
-- changeset name:1

create table Users (
    id bigserial primary key,
    email text not null,
    firstName text not null,
    lastName text not null,
    phone text not null,
    role text not null,
    image text
);
create table Ads (
    idAd bigserial primary key,
    idUser serial not null,
    image text,
    prise serial not null,
    title text not null
);
create table Comment (
    idComment bigserial primary key,
    idUser bigserial not null,
    authorImage text,
    authorFirstName text not null,
    createdAt bigserial not null
);