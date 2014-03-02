package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="publicationtag")
public class PublicationTag {

	private Long pk;
	private Long id;
	
	public PublicationTag(){
		
	}
	
	public PublicationTag(Long pk){
		this.pk = pk;
	}
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="id")
	public Long getId(){
		return id;
	}
	
	@Column(name="pk")
	public Long getPk(){
		return pk;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public void setPk(Long pk){
		this.pk = pk;
	}
}

