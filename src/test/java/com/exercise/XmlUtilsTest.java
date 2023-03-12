package com.exercise;

import com.exercise.shape.Shape;
import com.exercise.shape.ShapeUtils;
import com.exercise.xml.XMLUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.w3c.dom.Document;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class XmlUtilsTest {

    Path path;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        try {
            path = tempDir.resolve( "testfile1.xml");
        } catch (InvalidPathException ipe) {
            System.err.println(
                    "error creating temporary test file in " +
                            this.getClass().getSimpleName() );
        }
    }

    @Test
    void test() throws Exception {

        final List<Shape> shapes = ShapeUtils.generateRandomShapes(2, 10, 10);
        Document document = ShapeUtils.createXML(shapes);
        XMLUtils.writeDocumentToFile(document, path);

        assertTrue(path.toFile().length() > 0);
    }

    @Test
    void test1() throws Exception {
        try {
            XMLUtils.writeDocumentToFile(null, path);
            fail("should fail.");
        } catch (NullPointerException ex) {
            assertEquals("must not be null", ex.getMessage());
        }
    }
}
