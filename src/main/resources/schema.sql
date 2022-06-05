CREATE TABLE IF NOT EXISTS data
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    data varchar(255),
    request_came_time bigint
);

alter table data
    owner to darkdeveloper;
