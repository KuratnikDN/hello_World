package main;

import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.Locale;

import logic.OpenCalaisTag;
import logic.Publication;
import logic.PublicationTag;

import DAO.Factory;
import DAO.Impl.OpenCalaisTagDAOImpl;

public class EnterPoint {
    
    public static void main(String[] args) throws SQLException {
       
    	//�������� �������
        Publication publication1 = new Publication(1l, "21.02.2014", "type1", "title1", "blablabla.com", "���������� ���� ����������1, Dmitry");
        Publication publication2 = new Publication(2l, "21.02.2014", "type2", "title2", "tyt.com", "���������� ���� ����������2, Dmitry");
        Publication publication3 = new Publication(3l, "21.02.2014", "type1", "title3", "facebook.com", "���������� ���� ����������3, Dmitry");
        
        OpenCalaisTag openCT1 = new OpenCalaisTag(1l, "name1", "category1");
        OpenCalaisTag openCT2 = new OpenCalaisTag(2l, "name2", "category2");
        OpenCalaisTag openCT3 = new OpenCalaisTag(3l, "name3", "category1");
        
        PublicationTag publicationTag1 = new PublicationTag(1l);
        PublicationTag publicationTag2 = new PublicationTag(1l);
        PublicationTag publicationTag3 = new PublicationTag(2l);
                
        //�������� �� � ��

        Factory.getInstance().getPublicationDAO().addPublication(publication1);
        Factory.getInstance().getPublicationDAO().addPublication(publication2);
        Factory.getInstance().getPublicationDAO().addPublication(publication3);
        Factory.getInstance().getPublicationDAO().deletePublication(publication2);
        
        Factory.getInstance().getOpenCalaisTagDAO().updateOpenCalaisTag(openCT1);
        Factory.getInstance().getOpenCalaisTagDAO().updateOpenCalaisTag(openCT2);
        Factory.getInstance().getOpenCalaisTagDAO().updateOpenCalaisTag(openCT3);
        
        Factory.getInstance().getPublicationTagDAO().addPublicationTag(publicationTag1);
        Factory.getInstance().getPublicationTagDAO().addPublicationTag(publicationTag2);
        Factory.getInstance().getPublicationTagDAO().addPublicationTag(publicationTag3);
  
       //������� ��� ���������� �� ��
        List<Publication> publication = Factory.getInstance().getPublicationDAO().getAllPublications();
        System.out.println("========��� ����������=========");
        for(int i = 0; i < publication.size(); ++i) { 
        		System.out.println("id : " + publication.get(i).getNoteId() + " publish date " + publication.get(i).getPublishDate()
        				+ " content type " + publication.get(i).getContentType() + " title " + publication.get(i).getTitle() + 
        				"\n url:" + publication.get(i).getUrl() + "\n" + publication.get(i).getReach());
                System.out.println("=============================\n\n");              
        } 
    	
        //������� ��� ���� ���������� �� ��
        List<PublicationTag> publicationTag = Factory.getInstance().getPublicationTagDAO().getAllPublicationTags();
        System.out.println("========��� ���� ����������=========");
        for(int i = 0; i < publicationTag.size(); ++i) { 
        	System.out.println("pk " + publicationTag.get(i).getPk() + " id " + publicationTag.get(i).getId() + "\n\n");
        }
        
        //������� ��� opencalais ���� ���������� �� ��
        List<OpenCalaisTag> openCalaisTag = Factory.getInstance().getOpenCalaisTagDAO().getAllOpenCalaisTags();
        System.out.println("========��� opencalais ����=========");
        for(int i = 0; i < openCalaisTag.size(); ++i) { 
        	System.out.println("id " + openCalaisTag.get(i).getId() + " name " + openCalaisTag.get(i).getName() + " category " + openCalaisTag.get(i).getCategory() + "\n\n");
        }   
    	
    }		
}