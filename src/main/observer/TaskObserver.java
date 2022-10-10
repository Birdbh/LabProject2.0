package observer;

import java.time.LocalDate;

public interface TaskObserver {
    void update(LocalDate task);
}
