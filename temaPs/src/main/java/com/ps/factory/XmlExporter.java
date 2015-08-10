package com.ps.factory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ps.entity.Operation;
import com.ps.entity.User;
import com.ps.repository.OperationRepository;
import com.ps.repository.UserRepository;


public class XmlExporter implements Exporter {

	
	@Override
	public void export(List<Operation> operations) {
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("operations");
			doc.appendChild(rootElement);

			for (Operation o : operations) {
				Element operation = doc.createElement("Operation");
				rootElement.appendChild(operation);

				Element name = doc.createElement("name");
				name.appendChild(doc.createTextNode(o.getUser().getId() + " "
						+ o.getUser().getFirstName() + " "
						+ o.getUser().getLastName()));
				operation.appendChild(name);

				Element operationName = doc.createElement("operationName");
				operationName.appendChild(doc.createTextNode(o
						.getOperationName()));
				operation.appendChild(operationName);

				Element description = doc.createElement("description");
				description.appendChild(doc.createTextNode(o.getDescription()));
				operation.appendChild(description);

				Element interestRate = doc.createElement("interestRate");
				interestRate
						.appendChild(doc.createTextNode(o.getInterestRate()));
				operation.appendChild(interestRate);

				Element date = doc.createElement("date");
				date.appendChild(doc.createTextNode(o.getDate().toString()));
				operation.appendChild(date);

				Element ammount = doc.createElement("ammount");
				ammount.appendChild(doc.createTextNode(Integer.toString(o
						.getAmount())));
				operation.appendChild(ammount);

			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(
					"E:\\Operations.xml"));

			transformer.transform(source, result);

			System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}

	public List<Operation> importOps(String path) {
		List<Operation> ops = new ArrayList<Operation>();
		try {

			File fXmlFile = new File("E:\\Operations.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("Operation");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					Operation o = new Operation();
					System.out.println("First Name : "
							+ eElement.getFirstChild().getTextContent());
					
					String text = eElement.getFirstChild().getTextContent();
					int ind = text.indexOf(" ");
					User u = new User();
					u.setId(Integer.parseInt(text.substring(0, ind)));
					o.setUser(u);
					System.out.println("," + text.substring(0, ind) + ",");

					System.out.println("operationName : "
							+ eElement.getElementsByTagName("operationName")
									.item(0).getTextContent());
					o.setOperationName(eElement
							.getElementsByTagName("operationName").item(0)
							.getTextContent());

					System.out.println("description : "
							+ eElement.getElementsByTagName("description")
									.item(0).getTextContent());
					o.setDescription(eElement
							.getElementsByTagName("description").item(0)
							.getTextContent());

					System.out.println("interestRate : "
							+ eElement.getElementsByTagName("interestRate")
									.item(0).getTextContent());
					o.setInterestRate(eElement
							.getElementsByTagName("interestRate").item(0)
							.getTextContent());

					System.out.println("date : "
							+ eElement.getElementsByTagName("date").item(0)
									.getTextContent());

					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					String textDate = eElement.getElementsByTagName("date")
							.item(0).getTextContent();
					textDate = textDate.substring(0, textDate.indexOf("."));
					System.out.println(textDate);
					Date date = sdf.parse(textDate);
					o.setDate(date);

					System.out.println("amount : "
							+ eElement.getElementsByTagName("ammount").item(0)
									.getTextContent());
					o.setAmount(Integer.parseInt(eElement
							.getElementsByTagName("ammount").item(0)
							.getTextContent()));
					ops.add(o);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ops;
	}

}

/*
 * @Override public void export(List<Dog> dog) { try { FileWriter writer = new
 * FileWriter("E:\\test.csv"); StringBuilder string = new StringBuilder(); for
 * (Dog dog1 : dog) {
 * 
 * string.append(dog1.getName()); string.append(','); string.append("" +
 * dog1.getPrice()); string.append(','); string.append(dog1.getDetails());
 * string.append('\n');
 * 
 * }
 * 
 * writer.append(string); writer.flush(); writer.close();
 * 
 * } catch (IOException e) { e.printStackTrace(); }
 * 
 * }
 */

