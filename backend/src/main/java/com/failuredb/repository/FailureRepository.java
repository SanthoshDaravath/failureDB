package com.failuredb.repository;
import com.failuredb.user.UserAccount;
import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;
@Entity @Table(name="repositories")
public class FailureRepository {
 @Id private UUID id; @ManyToOne(optional=false) @JoinColumn(name="owner_id") private UserAccount owner; @Column(nullable=false,unique=true) private String slug; @Column(nullable=false) private String title; @Column(nullable=false) private String description; @Column(nullable=false) private String category; private String industry; @Column(nullable=false) private String visibility; @Column(name="created_at",nullable=false) private Instant createdAt;
 protected FailureRepository(){} public FailureRepository(UserAccount owner,String slug,String title,String description,String category,String industry,String visibility){this.id=UUID.randomUUID();this.owner=owner;this.slug=slug;this.title=title;this.description=description;this.category=category;this.industry=industry;this.visibility=visibility;this.createdAt=Instant.now();}
 public UUID getId(){return id;} public UserAccount getOwner(){return owner;} public String getSlug(){return slug;} public String getTitle(){return title;} public String getDescription(){return description;} public String getCategory(){return category;} public String getIndustry(){return industry;} public String getVisibility(){return visibility;} public Instant getCreatedAt(){return createdAt;}
}
