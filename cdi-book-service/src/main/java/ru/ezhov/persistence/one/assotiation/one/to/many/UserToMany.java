package ru.ezhov.persistence.one.assotiation.one.to.many;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**В итоге, что у нас получается.
 * Есть таблица с пользователями и таблица с записями Один ко многим.
 * И промежуточная таблица с ключами
 *
 * Берем таблицу с пользователями добавляем список записей и анатируем @JoinTable
 * Created by rrnezh on 28.10.2017.
 */
@Entity
@Table(name = "T_E_USERS")
public class UserToMany {
    @Id
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String pass;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "T_E_LINK_USER_NOTE",
            joinColumns = @JoinColumn(name ="ID_USER"),
            inverseJoinColumns = @JoinColumn(name = "ID_NOTE"))
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
