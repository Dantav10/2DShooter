/**
 * XMLType
 * 
 * February 17, 2014
 * 
 * Dan0194
 */
package dantav.server.xml;

import java.io.FileInputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import dantav.util.PersistenceManager;

public abstract class XMLType {

	/**
	 * The object it will be using to store the data
	 */
	public XMLType(Object[] object) {
		this.object = object;
	}

	/**
	 * The amount of xml types
	 */
	public static XMLType[] xmlType = new XMLType[2];

	/**
	 * the object that contains the data
	 */
	private Object[] object;

	/**
	 * the key that it will look at in the xml
	 */
	public abstract String getKey();

	/**
	 * The class to extract the data into
	 */
	public abstract Class<?> getClassName();

	/**
	 * The path of the xml file
	 */
	public abstract String getPath();

	/**
	 * Parses the xml
	 */
	public static void parseXML(XStream xstream) {
		for (int i = 0; i < xmlType.length; i++) {
			xstream.alias(xmlType[i].getKey(), xmlType[i].getClassName());
		}
	}

	/**
	 * loads the xml
	 */
	public static void loadXML() {
		for (int i = 0; i < xmlType.length; i++) {
			xmlType[i].init();
		}
	}

	/**
	 * Gets the data from the xml into the object array
	 */
	@SuppressWarnings("unchecked")
	public void init() {
		try {
			List<Object> list = (List<Object>) PersistenceManager
					.load(new FileInputStream("./data/" + this.getPath()));
			for (int i = 0; i < object.length; i++) {
				this.object[i] = list.get(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
