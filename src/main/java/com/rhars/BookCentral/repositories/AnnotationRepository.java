package com.rhars.BookCentral.repositories;

import com.rhars.BookCentral.models.Annotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnotationRepository extends JpaRepository<Annotation, Long> {

}
