package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="publication")
public class Publication {
	
	private Long pk;
	private String publishDate;
	private String contentType;
	private String title;
	private String url;
	private String reach;
	private Long noteId; //судя по всему текст.
	
	public Publication(){
		
	}
	
	public Publication(Long pk,String publishDate, String contentType, String title, 
			String url, String reach){
		this.pk = pk;
		this.publishDate = publishDate;
		this.contentType = contentType;
		this.title = title;
		this.url = url;
		this.reach = reach;
	}
	

	 @Id
	 @GeneratedValue(generator="increment")
	 @GenericGenerator(name="increment", strategy = "increment")
	 @Column(name="NoteID")
	 public Long getNoteId() {
	     return noteId;
	 }
	    
	 @Column(name="pk")
	 public Long getPk(){
	     return pk;
	 }
	    
	 @Column(name="publishDate")
	 public String getPublishDate(){
	     return publishDate;
	 }
	
	 @Column(name="contentType")
	 public String getContentType(){
		 return contentType;
	 }
	 
	 @Column(name="title")
	 public String getTitle(){
		 return title;
	 }
	 
	 @Column(name="url")
	 public String getUrl(){
		 return url;
	 }
	 
	 @Column(name="reach")
	 public String getReach(){
		 return reach;
	 }
	 
	 public void setNoteId(Long id){
		 noteId = id;
	 }
	 
	 public void setPublishDate(String s){
		 publishDate = s;
	 }
	 
	 public void setContentType(String s){
		 contentType = s;
	 }
	 
	 public void setTitle(String s){
		 title = s;
	 }
	 
	 public void setUrl(String s){
		 url = s;
	 }
	 
	 public void setReach(String s){
		 reach = s;
	 }
	 
	 public void setPk(Long pk){
		 this.pk = pk;
	 }
}
