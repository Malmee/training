package com.XSLT;
import java.io.File;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
/**
 * Created by malmee on 11/6/15.
 */
public class Stylizer {
    public static void main(String[] args)
 {
     // Stream source of xsl file
     StreamSource xslSource = new StreamSource(new File("src/com/XSLT/cdcatalog.xsl"));

// Stream source of xml file
     StreamSource xmlSource = new StreamSource(new File("src/com/XSLT/cdcatalog.xml"));

// Stream Output html file
     StreamResult htmlOutput = new StreamResult(new File("src/com/XSLT/output.html"));

// Transforming using xsl processor
     try {
         TransformerFactory.newInstance().newTransformer(xslSource)
                 .transform(xmlSource, htmlOutput);
     } catch (TransformerConfigurationException e) {
// TODO Auto-generated catch block
         e.printStackTrace();
     } catch (TransformerException e) {
// TODO Auto-generated catch block
         e.printStackTrace();
     } catch (TransformerFactoryConfigurationError e) {
// TODO Auto-generated catch block
         e.printStackTrace();
     }


    }
}