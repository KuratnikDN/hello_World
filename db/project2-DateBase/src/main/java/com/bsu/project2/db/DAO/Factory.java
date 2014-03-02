package DAO;

import DAO.Impl.OpenCalaisTagDAOImpl;
import DAO.Impl.PublicationDAOImpl;
import DAO.Impl.PublicationTagDAOImpl;

public class Factory {
      
      private static PublicationDAO publicationDAO= null;
      private static PublicationTagDAO publicationTagDAO= null;
      private static OpenCalaisTagDAO openCalaisTagDAO= null;
      
      private static Factory instance = null;

      public static synchronized Factory getInstance(){
            if (instance == null){
              instance = new Factory();
            }
            return instance;
      }

      public PublicationDAO getPublicationDAO(){
            if (publicationDAO == null){
              publicationDAO = new PublicationDAOImpl();
            }
            return publicationDAO;
      }   
      
      public PublicationTagDAO getPublicationTagDAO(){
          if (publicationTagDAO == null){
            publicationTagDAO = new PublicationTagDAOImpl();
          }
          return publicationTagDAO;
    }   
      
      public OpenCalaisTagDAO getOpenCalaisTagDAO(){
          if (openCalaisTagDAO == null){
        	openCalaisTagDAO = new OpenCalaisTagDAOImpl();
          }
          return openCalaisTagDAO;
    }   
}
