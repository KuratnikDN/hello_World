package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="opencalaistag")
public class OpenCalaisTag {
	
	private Long id;
	private String name;
	private String category;
	
	public OpenCalaisTag(){
		name = null;
	}
	
	public OpenCalaisTag(Long id, String name, String category){
		this.name = name;
		this.category = category;
		this.id = id;
	}
	
	@Id
	//@GeneratedValue(generator="increment")
	//@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="id")
	public Long getId() {
	    return id;
	}
	   
	@Column(name="name")
	public String getName(){
	    return name;
	}
	   
	@Column(name="category")
	public String getCategory(){
	    return category;
	}
	   
	public void setId(Long i){
	    id = i;     
	}
	   
	public void setName(String name){
	    this.name = name;
	}   
	   
	public void setCategory(String category){
	    this.category = category;
	} 

}
