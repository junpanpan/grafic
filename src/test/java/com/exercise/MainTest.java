package com.exercise;

import com.exercise.persistence.PersistenceWriteException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class MainTest {

    @Test
    void test() throws Exception {
        Main.main(new String[0]);
    }

    @Test
    void test1() throws Exception {
        try {
            Main.main(new String[]{"c:\\hi.xml"});
            fail("should fail.");
        }  catch (PersistenceWriteException ex) {
        }
    }

    @Test
    void test2() throws Exception {
        Main.main(new String[]{"c:\\dev\\hi.xml"});
    }
}
