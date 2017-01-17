package dantav.util;

import java.io.InputStream;
import java.io.OutputStream;

import com.thoughtworks.xstream.XStream;

import dantav.server.xml.XMLType;

/**
 * Has the xstream object.
 * 
 * @author Graham
 * 
 */
public class PersistenceManager {

	/**
	 * So it cannot be instanced
	 */
	private PersistenceManager() {
	}

	/**
	 * The xstream
	 */
	private static XStream xstream;

	/**
	 * All of the files that need to be parsed with xstream
	 */
	static {
		xstream = new XStream();
		XMLType.parseXML(xstream);
	}

	/**
	 * Saves a file
	 */
	public static void save(Object object, OutputStream out) {
		xstream.toXML(object, out);
	}

	/**
	 * Loads a file
	 */
	public static Object load(InputStream in) {
		return xstream.fromXML(in);
	}

}