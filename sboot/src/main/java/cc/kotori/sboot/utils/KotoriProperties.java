package cc.kotori.sboot.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KotoriProperties {
	
	@Value("${cc.kotori.author}")
	private String author;
	
	@Value("${cc.kotori.description}")
	private String description;

	public KotoriProperties() {
	}

	public KotoriProperties(String author, String description) {
		super();
		this.author = author;
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}