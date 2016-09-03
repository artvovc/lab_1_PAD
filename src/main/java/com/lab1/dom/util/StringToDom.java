package com.lab1.dom.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * Created by Artemie on 03.09.2016.
 */
public class StringToDom {
    public static Object getObjectFromXmlString(Class<?> clazz, String xmlString) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(xmlString);
        return clazz.cast(unmarshaller.unmarshal(reader));
    }
}
