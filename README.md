# FailureDB

> Don't repeat what someone already learned.

FailureDB is a structured, evidence-aware knowledge platform for documenting failures, understanding their causes, and turning lessons into better decisions.

## Architecture

The platform is a modular monolith: a React + TypeScript application consumes a Spring Boot REST API. PostgreSQL is the system of record, Redis supports caching and rate limiting, and S3-compatible storage will hold evidence. Search begins with PostgreSQL full-text search behind a dedicated search module so OpenSearch can be introduced without changing feature code. AI capabilities will be exposed through a provider-neutral analysis module and must cite the records used.

## Repository layout

- `frontend/` — React, TypeScript, Vite client application.
- `backend/` — Spring Boot API, security, persistence, migrations, and tests.
- `infra/` — deployment and operational configuration.
- `docs/` — architecture decision records and product documentation.

## Development roadmap

1. Foundation: project setup, database configuration, migration baseline, and authentication.
2. Knowledge core: repositories, structured failure records, tags, search, and comments.
3. Evidence and history: revisions, commits, timelines, evidence, lessons, and issues.
4. Collaboration: reviews, branches, diffs, contributions, and moderation.
5. Intelligence: AI analysis, patterns, graph exploration, pre-mortems, and enterprise analytics.

## Status

Project structure is in place. The backend and frontend implementations begin in the next step.
