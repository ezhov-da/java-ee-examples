package ru.ezhov.persistence.one.assotiation.one.to.many.from.column.key;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**В итоге, что у нас получается.
 * Есть таблица с пользователями и таблица с записями Один ко многим.
 * И столбец с ключами для USER
 *
 * Берем таблицу с пользователями добавляем список записей и анатируем @JoinTable
 * Created by rrnezh on 28.10.2017.
 */
@Entity
@Table(name = "T_E_USERS")
public class UserToManyColumn {
    @Id
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String pass;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name ="ID_USER")
    private List<Note> notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "UserToManyColumn{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", notes=" + notes +
                '}';
    }

    public List<Note> getNotes() {
        return notes;
    }
}
