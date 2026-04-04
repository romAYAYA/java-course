package interfaces.calendar;

import java.util.ArrayList;
import java.util.List;

public class CalendarApp implements NoteBook {
    List<String> notes = new ArrayList<>();

    @Override
    public void addNote(String note) {
        notes.add(note);
        System.out.println("Note was added");
    }

    @Override
    public void deleteNote(int index) {
        if (index < 0 || notes.size() <= index) {
            System.out.println("Index out of range");
            return;
        }

        notes.remove(index);
    }
}
