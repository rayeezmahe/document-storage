package org.demo.documentstorage.repository;

import org.demo.documentstorage.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, String> {
}
