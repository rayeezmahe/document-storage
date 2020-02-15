package org.demo.documentstorage.resource;

import java.util.Optional;

import org.demo.documentstorage.model.Document;
import org.demo.documentstorage.service.DocumentStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storage/documents")
public class DocumentStorageResource {

	@Autowired
	private DocumentStorageService documentStorageService;

	@PostMapping
	public ResponseEntity<?> createDocument(@RequestBody Document document) {
		String docId = documentStorageService.createDocument(document);
		return ResponseEntity.status(HttpStatus.CREATED).body(docId);
	}

	@PutMapping("/{docId}")
	public ResponseEntity<?> updateDocument(@PathVariable("docId") String docId, @RequestBody Document document) {
		boolean result = documentStorageService.updateDocument(docId, document);
		if (result) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping("/{docId}")
	public ResponseEntity<?> deleteDocument(@PathVariable("docId") String docId) {
		boolean result = documentStorageService.deleteDocument(docId);
		if (result) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/{docId}")
	public ResponseEntity<?> getDocument(@PathVariable("docId") String docId) {
		Optional<Document> docFromDB = documentStorageService.getDocument(docId);
		Document document = null;
		if (docFromDB.isPresent()) {
			document = docFromDB.get();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentLength(document.getFileContent().length());
			return new ResponseEntity<>(document.getFileContent(), HttpStatus.OK);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
