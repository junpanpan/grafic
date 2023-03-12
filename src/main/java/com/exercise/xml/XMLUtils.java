package com.exercise.xml;

import com.exercise.persistence.PersistenceWriteException;
import org.w3c.dom.Document;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.nio.file.Path;
import java.util.Objects;

public class XMLUtils {

    public static void writeDocumentToFile(Document document, Path pathname) throws PersistenceWriteException {
        Objects.requireNonNull(document, "must not be null");

        StreamResult result = new StreamResult(pathname.toFile());
        writeDocument(document, result);
    }

    private static void writeDocument(Document document, StreamResult result) throws PersistenceWriteException {
        DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setAttribute("indent-number", 1);

        try {
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
        } catch (TransformerException e) {
            throw new PersistenceWriteException("transform fail", e);
        }
    }
}
