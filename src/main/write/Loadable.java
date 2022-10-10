package write;

import java.io.IOException;

interface Loadable {
    void load(String path) throws IOException;
}
