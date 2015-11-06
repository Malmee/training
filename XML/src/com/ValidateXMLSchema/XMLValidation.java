package com.ValidateXMLSchema;

/**
 * Created by malmee on 11/6/15.
 */
import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLValidation {

    public static void main(String[] args) {

        System.out.println("EmployeeRequest.xml validates against Employee.xsd? "+validateXMLSchema("src/com/ValidateXMLSchema/Employee.xsd", "src/com/ValidateXMLSchema/EmployeeRequest.xml"));
        System.out.println("EmployeeResponse.xml validates against Employee.xsd? "+validateXMLSchema("src/com/ValidateXMLSchema/Employee.xsd", "src/com/ValidateXMLSchema/EmployeeResponse.xml"));
        System.out.println("employee.xml validates against Employee.xsd? "+validateXMLSchema("src/com/ValidateXMLSchema/Employee.xsd", "src/com/ValidateXMLSchema/EmployeeNonValidate.xml"));

    }

    public static boolean validateXMLSchema(String xsdPath, String xmlPath){

        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }
}