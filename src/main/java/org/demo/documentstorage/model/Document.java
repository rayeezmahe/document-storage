package org.demo.documentstorage.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Document {

	@Id
	@Column(length = 20)
	private String docId;
	private String fileName;
	private String fileSize;
	private String fileContent;
	private String fileType;

}
