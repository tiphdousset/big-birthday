create table guests (
    name char(100) PRIMARY KEY,
    costume char(100),
    host char(1)[],
    token char(100) default md5(random()::text)
)

