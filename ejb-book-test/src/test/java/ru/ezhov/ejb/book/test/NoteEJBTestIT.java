package ru.ezhov.ejb.book.test;

import org.junit.Ignore;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@Ignore
public class NoteEJBTestIT {
    @Test
    public void shouldCreateANote() throws Exception {
        Map<String, Object> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));
        try (EJBContainer ec = EJBContainer.createEJBContainer(properties)) {
            Context ctx = ec.getContext();
            // Проверяет зависимости JNDI (источники данных и EJB)
            assertNotNull(ctx.lookup("java:global/jdbc/ezhov"));
            assertNotNull(
                    ctx.lookup("java:global/classes/NoteEJB!ru.ezhov.ejb.book.test.NoteEJBRemote"));
            assertNotNull(
                    ctx.lookup("java:global/classes/NoteEJB!ru.ezhov.ejb.book.test.NoteEJB"));
            // Ищет EJB
            NoteEJB bookEJB = (NoteEJB)
                    ctx.lookup("java:global/classes/NoteEJB!ru.ezhov.ejb.book.test.NoteEJB");
            // Ищет все книги и убеждается, что их две (они добавлены
            // в базу с помощью DBPopulator)
            assertEquals(2, bookEJB.findAllNotes().size());
            // Создает книгу
            Note note = new Note("wow", false);
            // Сохраняет книгу в базе данных
            note = bookEJB.createNote(note);
            assertNotNull("ID не может быть пустым", note.getId());
            // Ищет все книги и убеждается, что их стало на одну больше
            assertEquals(3, bookEJB.findAllNotes().size());
            // Удаляет созданную книгу
            bookEJB.delete(note);
            // Ищет все книги и убеждается, что их стало на одну меньше
            assertEquals(2, bookEJB.findAllNotes().size());
        }
    }
}