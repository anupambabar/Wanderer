package com.wanderer.utility.utils;

import java.io.File;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * 
 * @author anupam.babar
 */
public class XmlUtil {
	
	private XmlUtil() {
	}

	/**
	 * @param objClass
	 * @param file
	 * @return
	 * @throws JAXBException
	 */
	@SuppressWarnings("rawtypes")
	public static Object xmlToJava(Class objClass, InputStream file) throws JAXBException {
		Object output;

		JAXBContext jaxbContext = JAXBContext.newInstance(objClass);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		output = jaxbUnmarshaller.unmarshal(file);

		return output;
	}

	/**
	 * @param objClass
	 * @param file
	 * @return
	 * @throws JAXBException
	 */
	@SuppressWarnings("rawtypes")
	public static Object xmlToJava(Class objClass, File file) throws JAXBException {
		Object output;

		JAXBContext jaxbContext = JAXBContext.newInstance(objClass);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		output = jaxbUnmarshaller.unmarshal(file);

		return output;
	}

}
