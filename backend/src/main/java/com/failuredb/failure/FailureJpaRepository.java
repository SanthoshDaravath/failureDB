package com.failuredb.failure;
import java.util.List; import java.util.UUID; import org.springframework.data.jpa.repository.JpaRepository;
public interface FailureJpaRepository extends JpaRepository<Failure, UUID> { List<Failure> findAllByOrderByCreatedAtDesc(); List<Failure> findByRepositoryIdOrderByCreatedAtDesc(UUID repositoryId); List<Failure> findByTitleContainingIgnoreCaseOrSummaryContainingIgnoreCaseOrderByCreatedAtDesc(String title,String summary); }
