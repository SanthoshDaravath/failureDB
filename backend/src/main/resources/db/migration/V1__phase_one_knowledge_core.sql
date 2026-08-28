CREATE TABLE users (
    id UUID PRIMARY KEY,
    username VARCHAR(40) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE repositories (
    id UUID PRIMARY KEY,
    owner_id UUID NOT NULL REFERENCES users(id),
    slug VARCHAR(100) NOT NULL UNIQUE,
    title VARCHAR(160) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    category VARCHAR(80) NOT NULL,
    industry VARCHAR(120),
    visibility VARCHAR(20) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE failures (
    id UUID PRIMARY KEY,
    repository_id UUID NOT NULL REFERENCES repositories(id),
    author_id UUID NOT NULL REFERENCES users(id),
    title VARCHAR(220) NOT NULL,
    summary VARCHAR(1000) NOT NULL,
    context_text CLOB,
    expected_outcome CLOB,
    actual_outcome CLOB,
    root_cause CLOB,
    warning_signs CLOB,
    lessons_learned CLOB,
    prevention CLOB,
    severity INTEGER NOT NULL,
    status VARCHAR(30) NOT NULL,
    tags VARCHAR(500),
    occurred_year INTEGER,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE INDEX idx_repositories_owner ON repositories(owner_id);
CREATE INDEX idx_failures_repository ON failures(repository_id);
CREATE INDEX idx_failures_created ON failures(created_at DESC);
CREATE INDEX idx_failures_category ON repositories(category);
