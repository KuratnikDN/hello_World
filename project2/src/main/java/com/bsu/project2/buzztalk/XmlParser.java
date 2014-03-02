package com.bsu.project2.buzztalk;

import com.bsu.project2.data.BuzzTalkData;
import com.bsu.project2.data.OpenCalaisTag;
import com.bsu.project2.data.Publication;
import com.bsu.project2.system.SystemInfo;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static javax.xml.stream.XMLStreamConstants.*;

/**
 * Created with IntelliJ IDEA.
 * User: Alexzander
 * Date: 12.02.14
 * Time: 20:17
 * To change this template use File | Settings | File Templates.
 */

public class XmlParser {
    static Logger logger = Logger.getLogger(XmlParser.class.getName());
    public XmlParser() {
        filesToDelete = new ArrayList<String>();
        filesToUse = new ArrayList<String>();

    }

    private ArrayList <String> filesToDelete;
    public ArrayList<String> getFilesToDelete() {
        return filesToDelete;
    }
    public void addFileToDelete(String fileToDelete){
        this.filesToDelete.add(fileToDelete);
    }
    public void clearFileToDelete(){
        this.filesToDelete.clear();
    }

    private ArrayList <String> filesToUse;
    public ArrayList<String> getFilesToUse() {
        return filesToUse;
    }
    public void addFileToUse(String fileToUse){
        this.filesToUse.add(fileToUse);
    }
    public void clearFileToUse(){
        this.filesToUse.clear();
    }

    public BuzzTalkData getXmlFromServiceUsingUrls(String url) throws IOException, XMLStreamException {
        BuzzTalkData buzzTalkData = new BuzzTalkData();
        URL serviceUrl = new URL(url);

        File projectDir = new File(SystemInfo.getTempFolder());
        if (SystemInfo.getTempFolder()  != "") {
            File[] files = projectDir.listFiles();
            if (!projectDir.exists()) {
                projectDir.mkdirs();
            }
            for (File file : files) {
                if(!file.isDirectory()) {
                    file.delete();
                }
            }
        }

        logger.info("project folder created");
        File outFile = new File(SystemInfo.getTempFolder()  + "outfile.zip");
        FileOutputStream outStream = new FileOutputStream(outFile);
        InputStream inStream = serviceUrl.openStream();
        int c;
        while ((c = inStream.read()) != -1)
        { outStream.write(c);}
        inStream.close();
        outStream.close();
        //Загрузка архива закончена.

        //Добавим название архива в список файлов на удаление.
        addFileToDelete(SystemInfo.getTempFolder() + "outfile.zip");
        //Добавление в список на удаление закончено.

        //Извлекаем файлы из архива "outfile.zip" на диск.
        ZipInputStream zipinputstream = new ZipInputStream(new FileInputStream(SystemInfo.getTempFolder()  + "outfile.zip"));
        ZipEntry entry = zipinputstream.getNextEntry();
        byte[] buf = new byte[1024];
        int len;
        while(entry != null){
            String targetFile = SystemInfo.getTempFolder()  + entry.getName();
            addFileToUse(targetFile);
            OutputStream out = new FileOutputStream(targetFile);
            while ((len = zipinputstream.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close();
            entry = zipinputstream.getNextEntry();
        }
        //Извлечение файлов .xml из архива "outfile.zip" закончено.


        StringBuilder builder = new StringBuilder();
        String[] file_list = projectDir.list();
        for (String str : file_list) {
            builder.append('\t');
            builder.append(str);
            builder.append('\n');
        }
        logger.info("unzipped: \n" + builder.toString());
        //Чтение xml файлов и сохранение в базу данных
        for(String nameFileToUse: getFilesToUse()){
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new BufferedInputStream(new FileInputStream(nameFileToUse)));
            String s = null, tagContent = null;
            OpenCalaisTag openCalaisTag = null;
            Publication publication = null;
            ArrayList openCalaisTagIds = null;
            int event;
            while(reader.hasNext()){
                event = reader.next();
                switch(event){
                    case START_ELEMENT:
                        s = reader.getLocalName();
                        if (s.equals("Data")){
                            System.out.println("Data"); /////////////////////////Проверка на правильность работы////////////////////////////////////////////////
                            //data = new Data();
                        } else if (s.equals("openCalaisTag")) {
                            openCalaisTag = new OpenCalaisTag();
                        } else if (s.equals("publication")){
                            System.out.println("Publication"); /////////////////////////Проверка на правильность работы////////////////////////////////////////////////
                            publication = new Publication();
                        } else if (s.equals("openCalaisTagIds")){
                            openCalaisTagIds = new ArrayList();
                        }
                        break;
                    case CHARACTERS: {
                        tagContent = reader.getText().trim();
                        break;
                    }
                    case END_ELEMENT:  {
                        s = reader.getLocalName();
                        if (s.equals("id")) {
                            openCalaisTag.setId(Integer.valueOf(tagContent));
                        } else if (s.equals("name")) {
                            openCalaisTag.setName(String.valueOf(tagContent));
                        } else if (s.equals("category")) {
                            openCalaisTag.setCategory(String.valueOf(tagContent));
                        } else if (s.equals("openCalaisTag")) {
                            buzzTalkData.addTag(openCalaisTag);
                        } else if (s.equals("pk")) {
                            publication.setPk(String.valueOf(tagContent));
                        } else if (s.equals("publishDate")) {
                            publication.setPublishDate(String.valueOf(tagContent));
                        } else if (s.equals("contentType")) {
                            publication.setContentType(String.valueOf(tagContent));
                        } else if (s.equals("title")) {
                            publication.setTitle(String.valueOf(tagContent));
                        } else if (s.equals("url")) {
                            publication.setUrl(String.valueOf(tagContent));
                        } else if (s.equals("reach")) {
                            publication.setReach(String.valueOf(tagContent));
                        } else if (s.equals("tagId")) {
                            publication.addToOpenCalaisTagIds(String.valueOf(tagContent));
                        } else if (s.equals("publication")) {
                            buzzTalkData.addPublication(publication);
                        }
                    }
                    default:
                        break;
                }
            }
            addFileToDelete(nameFileToUse);   //добавляем в список на удаление
        }
        clearFileToUse();
        // Чтение xml файлов и сохранение в базу данных закончено

        //Удалим файлы которые находятся в списке на удаление
        for(String nameFileToDelete: getFilesToDelete()){
            File f = new File(nameFileToDelete);
            //f.delete();
        }
        clearFileToDelete();
        return buzzTalkData;
    }
}

