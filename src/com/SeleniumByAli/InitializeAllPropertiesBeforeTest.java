package com.SeleniumByAli;

import com.SeleniumByAli.CustomExceptions.NoSuchTypeBrowserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class InitializeAllPropertiesBeforeTest <T extends WebDriver> extends BaseClass{

    ArrayList<String> listSettings = null;

    public  InitializeAllPropertiesBeforeTest(T typeOfBrowser) throws Exception {
        super(typeOfBrowser);

        listSettings = new ArrayList<>();
        checkIfSettingsFileExists();

        listSettings = returnBrowserInstanceSettings();
           // boolean test = typeOfBrowser.equals(new FirefoxDriver());

        if(typeOfBrowser instanceof FirefoxDriver){
            // path for gecko driver will be taken from settings.xml file
            System.setProperty("webdriver.gecko.driver", listSettings.get(1));
        }

        else if (typeOfBrowser instanceof ChromeDriver){
            System.setProperty("webdriver.chrome.driver",listSettings.get(0));
        }

        else if (typeOfBrowser instanceof InternetExplorerDriver){
            System.setProperty("webdriver.IE.driver",listSettings.get(2));
        }

        else {
            throw new NoSuchTypeBrowserException("Please select true browser type and then Re-run tests");
        }


    }

    public ArrayList<String> returnBrowserInstanceSettings() throws IOException, SAXException, ParserConfigurationException {

        ArrayList<String> settingList = new ArrayList<>();
        File file = new File("..\\Settings\\Settings.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();
        documentBuilderFactory.setIgnoringComments(true);
        documentBuilderFactory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);

        String chrome = document.getElementsByTagName("Chrome").item(0).getTextContent();
        String firefox = document.getElementsByTagName("Firefox").item(0).getTextContent();
        String iexplorer = document.getElementsByTagName("IExplorer").item(0).getTextContent();
        settingList.add(chrome);
        settingList.add(firefox);
        settingList.add(iexplorer);
        return  settingList;
    }

    public void checkIfSettingsFileExists() throws IOException, ParserConfigurationException, TransformerException {
        File mySettingFile = new File("..\\Settings\\Settings.xml");
        if(mySettingFile.exists())
            return;

//        mySettingFile.createNewFile();

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("settings");
        doc.appendChild(rootElement);

        // browser settings
        Element chrome = doc.createElement("Chrome");
        rootElement.appendChild(chrome);

        Element firefox = doc.createElement("Firefox");
        rootElement.appendChild(firefox);

        Element iexloperer = doc.createElement("IExplorer");
        rootElement.appendChild(iexloperer);


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("..\\Settings\\Settings.xml"));

        transformer.transform(source, result);
    }
}
