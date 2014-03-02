package DAO;

import java.sql.SQLException;
import java.util.List;

import logic.Publication;

public interface PublicationDAO {
    public void addPublication(Publication o1) throws SQLException;  
    public void updatePublication(Publication o1) throws SQLException;
    public Publication getPublicationById(Long id) throws SQLException; 
    public List getAllPublications() throws SQLException; 
    public void deletePublication(Publication o1) throws SQLException;
}
