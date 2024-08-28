package com.banreservas.account.movement.utils;

import com.banreservas.account.movement.dtos.AccountMovementRequest;
import com.banreservas.account.movement.dtos.AccountMovementResponse;
import com.banreservas.account.movement.dtos.XmlResponseDto;
import com.banreservas.account.movement.dtos.soap.Root;
import com.banreservas.account.movement.dtos.soap.XmlResponse;
import com.banreservas.account.movement.dtos.soap.XmlResponses;
import com.brrd.service.services.ConsultaMovimientosRequest;
import com.brrd.service.services.ServiceResponse;
import com.brrd.service.services.TipoProductoNum;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.List;

public class ConsultaMovimientoMapper {

    static Logger logger = LoggerFactory.getLogger(ConsultaMovimientoMapper.class);

    public static ConsultaMovimientosRequest mapDtoToSoap(AccountMovementRequest accountMovementRequest) {

        ConsultaMovimientosRequest consultaMovimientosRequest = new ConsultaMovimientosRequest();

        consultaMovimientosRequest.setCantidad(accountMovementRequest.cantidad());
        consultaMovimientosRequest.setDireccion(accountMovementRequest.direccion());
        consultaMovimientosRequest.setFachaFinal(accountMovementRequest.fachaFinal());
        consultaMovimientosRequest.setFechaInicial(accountMovementRequest.fechaInicial());
        consultaMovimientosRequest.setMontoFinal(accountMovementRequest.montoFinal());
        consultaMovimientosRequest.setFechaInicial(accountMovementRequest.fechaInicial());
        consultaMovimientosRequest.setProducto(accountMovementRequest.producto());
        consultaMovimientosRequest.setRecord(accountMovementRequest.record());
        consultaMovimientosRequest.setTipo(accountMovementRequest.tipo());
        consultaMovimientosRequest.setTipoProducto(accountMovementRequest.tipoProducto());

        return consultaMovimientosRequest;
    }


    public static AccountMovementResponse mapSoapToDto(ServiceResponse serviceResponse) throws Exception {
        if (!serviceResponse.getErrorMessage().equalsIgnoreCase("Success")) throw new Exception();

        /** Se agrega el rootElement <Root> para poder mapear correctamente el XMLReresponse*/
        String xmlResponse = "<Root>" + serviceResponse.getXMLReresponse() + "</Root>";
        Document document = convertStringToXML(xmlResponse);

        JAXBContext jaxbContext = JAXBContext.newInstance(Root.class, XmlResponses.class, XmlResponse.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        logger.info("Mapping XML to DTO :" + xmlResponse);
        // Deserializar contenido XML en objetos
        Root root = (Root) unmarshaller.unmarshal(document);

        return new AccountMovementResponse(
                mapXmlResponse(root.getXmlResponses())
        );
    }

    private static List<XmlResponseDto> mapXmlResponse(XmlResponses xmlResponses) {
        return xmlResponses.getXmlResponses().stream().map(xmlRespuesta ->
                new XmlResponseDto(
                        xmlRespuesta.getTransactionNumber(),
                        xmlRespuesta.getDate(),
                        xmlRespuesta.getActualDate(),
                        xmlRespuesta.getAmount(),
                        xmlRespuesta.getMovementType(),
                        xmlRespuesta.getConcept(),
                        xmlRespuesta.getOffice(),
                        xmlRespuesta.getTellerBranch(),
                        xmlRespuesta.getTellerNumber(),
                        xmlRespuesta.getDescriptionOficce(),
                        xmlRespuesta.getBalance(),
                        xmlRespuesta.getReference(),
                        xmlRespuesta.getDescription1(),
                        xmlRespuesta.getDescription2(),
                        xmlRespuesta.getDescription3(),
                        xmlRespuesta.getCausal(),
                        xmlRespuesta.getTransactionCode(),
                        xmlRespuesta.getState(),
                        xmlRespuesta.getIdPage(),
                        xmlRespuesta.getIdUnico(),
                        xmlRespuesta.getQuantity(),
                        xmlRespuesta.getIdExit()
                )
        ).toList();
    }

    private static Document convertStringToXML(String xmlString) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource inputSource = new InputSource(new StringReader(xmlString));
        return builder.parse(inputSource);
    }
}
