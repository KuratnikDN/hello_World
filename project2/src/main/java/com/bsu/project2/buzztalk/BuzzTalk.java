package com.bsu.project2.buzztalk;

import com.bsu.project2.data.BuzzTalkData;
import com.bsu.project2.exceptions.Project2TechException;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Alexzander
 * Date: 13.02.14
 * Time: 13:37
 * To change this template use File | Settings | File Templates.
 */
public class BuzzTalk {
    static Logger logger = Logger.getLogger(BuzzTalk.class.getName());
    public BuzzTalkData getData() throws Project2TechException {

        XmlParser xmlParser = new XmlParser();
        String serviceLink = "http://widget.opinionmining.nl/bt-api-uni/dependency?" +
                "buzzreport_uid=df42a5dd-6d69-4870-80d2-005062acb391";
        BuzzTalkData buzzTalkData = null;
        try {
            buzzTalkData = xmlParser.getXmlFromServiceUsingUrls(serviceLink);
        } catch (IOException e) {
            logger.error("io exception:\n\t" + e);
            throw new Project2TechException(e);
        } catch (XMLStreamException e) {
            logger.error("xml stream exception:\n\t" + e);
            throw new Project2TechException(e);
        }
        // testing error page
        //throw new Project2TechException("ha-ha");
        return buzzTalkData;
    }

}
