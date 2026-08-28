# FailureDB architecture

## Product architecture

```text
React client
    -> REST API (Spring Boot modular monolith)
        -> PostgreSQL (transactional source of truth + initial full-text search)
        -> Redis (cache, rate limits, short-lived data)
        -> S3-compatible storage (evidence objects)
        -> AI provider adapter (grounded analysis only)
```

Core domain flow: Repository -> Failure -> Revision / Failure Commit -> Evidence -> Review -> Lessons and prevention. Alternative causal interpretations are represented as branches, preserving the canonical record.

## Database architecture

All public resources use UUIDs. The initial relational model groups entities into identity (`user`, `organization`), knowledge (`repository`, `failure`, `failure_revision`, `timeline_event`, `evidence`, `lesson`, `tag`), collaboration (`issue`, `review`, `contribution`, `follow`), and governance (`report`, `moderation_action`, `audit_log`). Foreign keys preserve ownership and history; indexes will support repository lookup, filters, full-text search, and time-ordered activity. Migrations will be immutable Flyway scripts.

## API architecture

The API is versioned under `/api`. Controllers validate request DTOs, services enforce authorization and domain rules, repositories encapsulate JPA persistence, and exception handlers return a consistent problem response. JWT authentication is stateless, with refresh-token rotation and audit logging. Search and AI are interfaces at the application boundary to prevent provider coupling.
