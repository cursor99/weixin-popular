package weixin.popular.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.xml.bind.marshaller.CharacterEscapeHandler;

/**
 * XML 数据接收对象转换工具类
 * 
 * @author LiYi
 *
 */
public abstract class XMLConverUtil {

	private static Map<Class<?>, JAXBContext> JAXB_CONTEXT_MAP;

	static {
		JAXB_CONTEXT_MAP = new ConcurrentHashMap<Class<?>, JAXBContext>(256);
	}

	/**
	 * XML to Object
	 * 
	 * @param <T>
	 *            T
	 * @param clazz
	 *            clazz
	 * @param xml
	 *            xml
	 * @return T
	 * @throws ParserConfigurationException 
	 * @throws JAXBException 
	 * @throws SAXException 
	 */
	public static <T> T convertToObject(Class<T> clazz, String xml) throws ParserConfigurationException, JAXBException, SAXException {
		return convertToObject(clazz, new StringReader(xml));
	}

	/**
	 * XML to Object
	 * 
	 * @param <T>
	 *            T
	 * @param clazz
	 *            clazz
	 * @param inputStream
	 *            inputStream
	 * @return T
	 * @throws ParserConfigurationException 
	 * @throws JAXBException 
	 * @throws SAXException 
	 */
	public static <T> T convertToObject(Class<T> clazz, InputStream inputStream) throws ParserConfigurationException, JAXBException, SAXException {
		return convertToObject(clazz, new InputStreamReader(inputStream));
	}

	/**
	 * XML to Object
	 * 
	 * @param <T>
	 *            T
	 * @param clazz
	 *            clazz
	 * @param inputStream
	 *            inputStream
	 * @param charset
	 *            charset
	 * @return T
	 * @throws ParserConfigurationException 
	 * @throws JAXBException 
	 * @throws SAXException 
	 */
	public static <T> T convertToObject(Class<T> clazz, InputStream inputStream, Charset charset) throws ParserConfigurationException, JAXBException, SAXException {
		return convertToObject(clazz, new InputStreamReader(inputStream, charset));
	}

	/**
	 * XML to Object
	 * 
	 * @param <T>
	 *            T
	 * @param clazz
	 *            clazz
	 * @param reader
	 *            reader
	 * @return T
	 * @throws ParserConfigurationException 
	 * @throws JAXBException 
	 * @throws SAXException 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T convertToObject(Class<T> clazz, Reader reader) throws ParserConfigurationException, JAXBException, SAXException {
		/**
		 * XXE 漏洞
		 * https://www.owasp.org/index.php/XML_External_Entity_(XXE)_Prevention_Cheat_Sheet#JAXB_Unmarshaller
		 */
		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setFeature("http://xml.org/sax/features/external-general-entities", false);
		spf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
		spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

		if (!JAXB_CONTEXT_MAP.containsKey(clazz)) {
			JAXB_CONTEXT_MAP.put(clazz, JAXBContext.newInstance(clazz));
		}

		Source xmlSource = new SAXSource(spf.newSAXParser().getXMLReader(), new InputSource(reader));
		Unmarshaller unmarshaller = JAXB_CONTEXT_MAP.get(clazz).createUnmarshaller();
		return (T) unmarshaller.unmarshal(xmlSource);
		
	}

	/**
	 * Object to XML
	 * 
	 * @param object
	 *            object
	 * @return xml
	 * @throws JAXBException 
	 */
	public static String convertToXML(Object object) throws JAXBException {

		if (!JAXB_CONTEXT_MAP.containsKey(object.getClass())) {
			JAXB_CONTEXT_MAP.put(object.getClass(), JAXBContext.newInstance(object.getClass()));
		}
		Marshaller marshaller = JAXB_CONTEXT_MAP.get(object.getClass()).createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// 设置CDATA输出字符
		marshaller.setProperty(CharacterEscapeHandler.class.getName(), new CharacterEscapeHandler() {
			public void escape(char[] ac, int i, int j, boolean flag, Writer writer) throws IOException {
				writer.write(ac, i, j);
			}
		});
		StringWriter stringWriter = new StringWriter();
		marshaller.marshal(object, stringWriter);
		return stringWriter.getBuffer().toString();

	}

	/**
	 * 转换简单的xml to map
	 * 
	 * @param xml
	 *            xml
	 * @return map
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static Map<String, String> convertToMap(String xml) throws ParserConfigurationException, SAXException, IOException {
		Map<String, String> map = new LinkedHashMap<String, String>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		/*
		 * 避免 XXE 攻击
		 * 
		 * @since 2.8.21
		 */
		dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
		dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
		dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
		dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
		dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		dbf.setXIncludeAware(false);
		dbf.setExpandEntityReferences(false);

		DocumentBuilder db = dbf.newDocumentBuilder();
		StringReader sr = new StringReader(xml);
		InputSource is = new InputSource(sr);
		Document document = db.parse(is);

		Element root = document.getDocumentElement();
		if (root != null) {
			NodeList childNodes = root.getChildNodes();
			if (childNodes != null && childNodes.getLength() > 0) {
				for (int i = 0; i < childNodes.getLength(); i++) {
					Node node = childNodes.item(i);
					if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
						map.put(node.getNodeName(), node.getTextContent());
					}
				}
			}
		}
		return map;
	}

}
