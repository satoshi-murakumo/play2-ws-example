package controllers;

import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import models.Employee;

import org.w3c.dom.Document;

import play.mvc.BodyParser.Of;
import play.mvc.BodyParser.Xml;
import play.mvc.Controller;
import play.mvc.Result;
import controllers.request.EmployeeRequest;
import controllers.response.EmployeeListResponse;

public class EmployeeService extends Controller {

    public static Result index() {
        List<Employee> employees = Employee.find.all();
        EmployeeListResponse response = EmployeeListResponse.from(employees);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        JAXB.marshal(response, bos);
        response().setContentType("text/xml");
        return ok(bos.toByteArray());
    }

    static JAXBContext context;
    static {
        try {
            context = JAXBContext.newInstance(EmployeeRequest.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @Of(Xml.class)
    public static Result post() {
        Document xml = request().body().asXml();
        EmployeeRequest dto = null;
        try {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            dto = (EmployeeRequest) unmarshaller.unmarshal(xml);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return ok();
    }

}
