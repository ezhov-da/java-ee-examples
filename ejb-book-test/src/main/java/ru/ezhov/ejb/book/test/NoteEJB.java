package ru.ezhov.ejb.book.test;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.List;

@Stateless
@LocalBean
public class NoteEJB implements NoteEJBRemote {

    @Inject
    private EntityManager entityManager;

    public List<Note> findAllNotes() {
        TypedQuery<Note> noteTypedQuery = entityManager.createNamedQuery(Note.FIND_ALL, Note.class);
        return noteTypedQuery.getResultList();
    }

    public @NotNull
    Note createNote(@NotNull Note note) {
        entityManager.persist(note);
        return note;
    }

    public @NotNull
    Note updateNote(@NotNull Note note) {
        entityManager.merge(note);
        return note;
    }

    public @NotNull
    Note delete(@NotNull Note note) {
        entityManager.remove(entityManager.merge(note));
        return note;
    }
}
