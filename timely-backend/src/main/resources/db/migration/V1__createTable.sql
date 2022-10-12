create table timelyinserts (
    id uuid primary key,
    name text,
    startdatetime timestamp,
    enddatetime timestamp,
    duration bigint
);