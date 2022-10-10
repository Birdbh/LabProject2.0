package write;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

interface Saveable {
    void save(String path) throws FileNotFoundException, UnsupportedEncodingException;
}
