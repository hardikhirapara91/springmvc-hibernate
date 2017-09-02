package com.hardik.springmvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PUBLICATION")
public class Publication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pubId;

	@NotEmpty
	@Column(name = "content", nullable = false)
	private String content;

	@NotEmpty
	@Column(name = "Title", nullable = false)
	private String title;

	@OneToOne
	@JoinColumn(name = "categoryId")
	private Category category;

	public Integer getPubId() {
		return pubId;
	}

	public void setPubId(Integer pubId) {
		this.pubId = pubId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
