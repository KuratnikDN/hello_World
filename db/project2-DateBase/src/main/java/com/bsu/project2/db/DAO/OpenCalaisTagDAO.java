package DAO;

import java.sql.SQLException;
import java.util.List;

import logic.OpenCalaisTag;

public interface OpenCalaisTagDAO {
    public void addOpenCalaisTag(OpenCalaisTag o1) throws SQLException;  
    public void updateOpenCalaisTag(OpenCalaisTag o1) throws SQLException;
    public OpenCalaisTag getOpenCalaisTagById(Long id) throws SQLException; 
    public List getAllOpenCalaisTags() throws SQLException; 
    public void deleteOpenCalaisTag(OpenCalaisTag o1) throws SQLException;
}
