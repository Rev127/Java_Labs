import java.util.HashSet;
import java.util.TreeSet;
import java.util.Comparator;

public class FilmRevenueContainer
{
    private HashSet<FilmRevenueDirectory> films;

    public FilmRevenueContainer()
    {
        this.films = new HashSet<>();
    }

    /**
     * Додає новий фільм до контейнера
     * @param film Фільм, який потрібно додати до контейнера.
     */
    public void addFilm(FilmRevenueDirectory film)
    {
        this.films.add(film);
    }

    /**
     * Видаляє конкретний фільм з контейнера
     * @param filmName Назва фільму, який потрібно видалити з контейнера.
     */
    public void removeFilm(String filmName)
    {
        for (FilmRevenueDirectory film : new HashSet<>(this.films))
        {
            if (film.getFilmName().equals(filmName))
            {
                this.films.remove(film);
            }
        }

    }

    /**
     * Знаходить необхідний фільм в контейнері по назві
     * @param filmName Назва фільму, який потрібно знайти в контейнері
     * @return Об'єкт FilmRevenueDirectory, який містить інформацію про фільм, або null, якщо фільм не знайдено.
     */
    public FilmRevenueDirectory findFilmByName(String filmName)
    {
        for (FilmRevenueDirectory film : this.films)
        {
            if (film.getFilmName().equals(filmName))
            {
                return film;
            }
        }
        return null;
    }

    /**
     * Отримує всі фільми, відсортовані за назвою у алфавітному порядку, та виводить їх на екран.
     */
    public void getAllFilms()
    {
        TreeSet<FilmRevenueDirectory> sortFilms = new TreeSet<>(Comparator.comparing(FilmRevenueDirectory::getFilmName));
        sortFilms.addAll(this.films);
        for (FilmRevenueDirectory film : sortFilms)
        {
            System.out.println(film.toString() + "\n");
        }
    }
}
