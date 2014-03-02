package DAO;

import java.sql.SQLException;
import java.util.List;

import logic.PublicationTag;

public interface PublicationTagDAO {
	   public void addPublicationTag(PublicationTag o1) throws SQLException;  
	    public void updatePublicationTag(PublicationTag o1) throws SQLException;
	    public PublicationTag getPublicationTagById(Long id) throws SQLException; 
	    public List getAllPublicationTags() throws SQLException; 
	    public void deletePublicationTag(PublicationTag o1) throws SQLException;
}
