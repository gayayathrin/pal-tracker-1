package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private final Map<Long, TimeEntry> db = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry entry) {
        entry.setId(db.size() + 1);
        db.put(entry.getId(), entry);
        return entry;
    }

    @Override
    public TimeEntry find(long id) {
        return db.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(db.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry entry) {
        entry.setId(id);
        db.put(id, entry);
        return entry;
    }

    @Override
    public void delete(long id) {
        db.remove(id);
    }
}
