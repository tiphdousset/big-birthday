create table guests (
    name char(100) PRIMARY KEY,
    costume char(100),
    host char(1),
    token char(100),
);

alter table guests alter column token set default md5(random()::text);
