package org.project.dataproviders;

import com.google.common.collect.ImmutableMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class AllureEnvironmentWriter {

    //Private constructor to hide the implicit public one
    private AllureEnvironmentWriter() {
    }

    private static void config(ImmutableMap<String, String> environmentValuesSet,
                               String customResultsPath) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element environment = doc.createElement("environment");
            doc.appendChild(environment);
            environmentValuesSet.forEach((k, v) -> {
                Element parameter = doc.createElement("parameter");
                Element key = doc.createElement("key");
                Element value = doc.createElement("value");
                key.appendChild(doc.createTextNode(k));
                value.appendChild(doc.createTextNode(v));
                parameter.appendChild(key);
                parameter.appendChild(value);
                environment.appendChild(parameter);
            });

            // write the content into xml file
            TransformerFactory factory = TransformerFactory.newInstance();
            // to be compliant, prohibit the use of all protocols by external entities:
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
            Transformer transformer = factory.newTransformer();
            DOMSource source = new DOMSource(doc);
            File allureResultsDir = new File(customResultsPath);
            if (!allureResultsDir.exists()) allureResultsDir.mkdirs();
            StreamResult result = new StreamResult(
                    new File(customResultsPath + "/environment.xml"));
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
        }
    }

    public static void allureEnvironmentWriter(ImmutableMap<String, String> environmentValuesSet) {
        config(environmentValuesSet, System.getProperty("user.dir") + "/target/allure-results");
    }


    public static void allureEnvironmentWriter(ImmutableMap<String, String> environmentValuesSet,
                                               String customResultsPath) {
        config(environmentValuesSet, customResultsPath);
    }
}
