package org.demo.documentstorage.service;

import java.util.Optional;

import org.demo.documentstorage.model.Document;
import org.demo.documentstorage.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentStorageService {

	@Autowired
	private DocumentRepository documentRepository;

	public String createDocument(Document document) {
		String docId = randomAlphaNumeric(20);
		document.setDocId(docId);
		documentRepository.save(document);
		return docId;
	}

	public boolean updateDocument(String docId, Document document) {
		if (!documentRepository.findById(docId).isPresent())
			return false;
		document.setDocId(docId);
		documentRepository.save(document);
		return true;
	}

	public boolean deleteDocument(String docId) {
		if (!documentRepository.findById(docId).isPresent())
			return false;
		documentRepository.deleteById(docId);
		return true;
	}

	public Optional<Document> getDocument(String docId) {
		return documentRepository.findById(docId);
	}

	private String randomAlphaNumeric(int length) {
		String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		StringBuilder builder = new StringBuilder();
		while (length-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

}
