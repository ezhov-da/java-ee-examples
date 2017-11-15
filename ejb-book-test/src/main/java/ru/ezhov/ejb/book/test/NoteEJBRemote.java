package ru.ezhov.ejb.book.test;

import javax.ejb.Remote;
import javax.validation.constraints.NotNull;
import java.util.List;

@Remote
public interface NoteEJBRemote {
    List<Note> findAllNotes();

    @NotNull
    Note createNote(@NotNull Note note);

    @NotNull
    Note updateNote(@NotNull Note note);

    @NotNull
    Note delete(@NotNull Note note);
}
