package com.exercise;

import com.exercise.persistence.PersistenceWriteException;
import com.exercise.shape.Shape;
import com.exercise.shape.ShapeUtils;
import com.exercise.xml.XMLUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws PersistenceWriteException {

        final List<Shape> shapes = ShapeUtils.generateRandomShapes(1000000, 10, 10);

        ShapeUtils.removeCloseByShapes(shapes, 1);

        Collections.sort(shapes);

        // Skriv ut resultatet till en XML
        String absolutePath = args.length > 0 ? args[0] : null;
        Path temp = null;

        if (absolutePath == null) {
            try {
                temp = Files.createTempFile("", ".xml");
            } catch (IOException ex) {
                throw new PersistenceWriteException("can't create file", ex);
            }
        } else {
            temp = Paths.get(absolutePath);
        }

        XMLUtils.writeDocumentToFile(ShapeUtils.createXML(shapes), temp);
        System.out.println("saved to file: " + temp.toString());
    }
}
