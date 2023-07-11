package com.stagiaire.springboot.book;




import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
	@Id
	@SequenceGenerator(name = "book-sequence",
	                   sequenceName = "book-sequence",
	                   allocationSize=1)
	@GeneratedValue(
			strategy= GenerationType.SEQUENCE,
			generator="book-sequence"
			
			)
	@Column(name="id")
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="author")
	private String author;
	@Column(name="price")
	private double price;
	@Column(name="category")
	private String category;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_file_id")
	private BookFile file;
 

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	


	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + ", category="
				+ category + "]";
	}

	
	
}
	
	
	
