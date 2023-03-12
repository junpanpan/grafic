package com.exercise.shape;

import com.exercise.math.Position;
import com.exercise.persistence.PersistenceWriteException;
import com.exercise.shape.shapes.Circle;
import com.exercise.shape.shapes.Rectangle;
import com.exercise.shape.shapes.Square;
import com.exercise.shape.shapes.Triangle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShapeUtils {

    private ShapeUtils() {}

    /**
     * Generates a ArrayList of random Shapes
     * Will only generate shapes with positive x and y position values
     *
     * @param count       the amount of shapes to generate
     * @param positionMax the max positive x and y position values
     * @param sizeMax     the max positive x and y size values
     * @return
     * @throws InvalidSizeException
     */
    public static List<Shape> generateRandomShapes(int count, double positionMax, double sizeMax) throws InvalidSizeException {
        final Random random = new Random();
        final ArrayList<Shape> shapes = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            final Position position = new Position(random.nextDouble() * positionMax, random.nextDouble() * positionMax);
            double width = random.nextDouble() * sizeMax;
            double height = random.nextDouble() * sizeMax;

            int shapeIndex = i % 4;
            switch (shapeIndex) {
                case 0:
                    shapes.add(new Circle(position, width / 2));
                    break;
                case 1:
                    shapes.add(new Rectangle(position, width, height));
                    break;
                case 2:
                    shapes.add(new Square(position, width));
                    break;
                case 3:
                default:
                    shapes.add(new Triangle(position, width, height));
                    break;
            }
        }

        return shapes;
    }

    /**
     * Modifies a ArrayList of shapes to remove shapes that are close to each other
     * If two shapes have under 1.0 unit distance to each other, one will be removed
     * Only check against Shape position and not the Shape extents
     *
     * @param shapes    the ArrayList of shapes to modify
     * @param threshold the threshold to use as filter
     */
    public static void removeCloseByShapes(List<Shape> shapes, double threshold) {
        if (shapes == null || threshold <= 0.0) {
            return;
        }

        for (int i = shapes.size() - 1; i >= 0; --i) {
            final Shape shape = shapes.get(i);

            boolean found = shapes.stream()
                    .filter(s -> s != shape)
                    .filter(s -> s.distance(shape) < threshold)
                    .findAny()
                    .isPresent();

            if (found)
                shapes.remove(i);
        }
    }

    /**
     * Generates a XML document from ArrayList of shapes
     *
     * @param shapes the shapes to use for generating XML document
     * @return the XML document
     * @throws PersistenceWriteException
     */
    public static Document createXML(List<Shape> shapes) throws PersistenceWriteException {

        DocumentBuilder documentBuilder;
        try {
            // Create XML document
            documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new PersistenceWriteException("Unable to create document object.");
        }

        Document document = documentBuilder.newDocument();
        Element root = document.createElement("shapes");
        document.appendChild(root);

        // Add shapes to XML document
        for (Shape shape : shapes) {
            Element element = document.createElement(shape.getClass().getSimpleName());

            element.setAttribute("position", shape.getPosition().toString());
            element.setAttribute("area", String.valueOf(shape.calculateArea()));

            root.appendChild(element);
        }

        return document;
    }
}
