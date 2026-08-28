package com.failuredb.repository;
import java.util.List; import java.util.Optional; import java.util.UUID; import org.springframework.data.jpa.repository.JpaRepository;
public interface FailureRepositoryJpa extends JpaRepository<FailureRepository, UUID> { List<FailureRepository> findAllByOrderByCreatedAtDesc(); Optional<FailureRepository> findBySlug(String slug); boolean existsBySlug(String slug); }
