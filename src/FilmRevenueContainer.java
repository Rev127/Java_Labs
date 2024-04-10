import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.io.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class FilmRevenueContainer
{
    private static final String FILE_PATH = "File/films.json";
    private HashSet<FilmRevenueDirectory> films;

    public FilmRevenueContainer()
    {
        this.films = loadFromFile();
    }

    /**
     * Зберігає поточну колекцію фільмів у файл.
     * Використовує бібліотеку Gson для серіалізації фільмів у формат JSON та записує їх у вказаний шлях файлу.
     * Якщо під час запису в файл сталася IOException, вона буде перехоплена та виведена.
     */
    private void saveToFile() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(this.films, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Завантажує колекцію фільмів з файлу.
     * Зчитує JSON-дані з вказаного шляху файлу за допомогою бібліотеки Gson та десеріалізує їх у HashSet об'єктів FilmRevenueDirectory.
     * Якщо під час читання з файлу виникла IOException, вона буде перехоплена та виведена.
     * Повертає завантажену колекцію фільмів, якщо вдалося прочитати з файлу, інакше повертає пустий HashSet.
     *
     * @return HashSet об'єктів FilmRevenueDirectory, завантажених з файлу, або пустий HashSet, якщо завантаження не вдалося.
     */
    public HashSet<FilmRevenueDirectory> loadFromFile() {
        HashSet<FilmRevenueDirectory> loadedFilms = new HashSet<>();
        try (Reader reader = new FileReader(FILE_PATH)) {
            Gson gson = new GsonBuilder().create();
            Type setType = new TypeToken<HashSet<FilmRevenueDirectory>>(){}.getType();
            loadedFilms = gson.fromJson(reader, setType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedFilms != null ? loadedFilms : new HashSet<>();
    }

    /**
     * Додає новий фільм до контейнера та файлу
     * @param film Фільм, який потрібно додати до контейнера та файлу.
     */
    public void addFilm(FilmRevenueDirectory film)
    {
        boolean flag = false;

        for (FilmRevenueDirectory tempFilm : films) {
            if (tempFilm.getFilmName().equals(film.getFilmName())) {
                flag = true;
                break;
            }
        }

        if (!flag)
        {
            this.films.add(film);
            saveToFile();
        }
    }

    /**
     * Видаляє конкретний фільм з контейнера та файлу
     * @param filmName Назва фільму, який потрібно видалити з контейнера та файлу.
     */
    public void removeFilm(String filmName)
    {
        FilmRevenueDirectory filmToRemove = findFilmByName(filmName);
        if (filmToRemove != null)
        {
            this.films.remove(filmToRemove);
            saveToFile();
        }
    }

    /**
     * Знаходить необхідний фільм в контейнері та файлі по назві
     * @param filmName Назва фільму, який потрібно знайти в контейнері та файлі
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
     * Оновлює дохід фільму з вказаною назвою.
     * Шукає фільм у колекції за назвою та оновлює його дохід.
     * Після оновлення зберігає зміни у файлі, використовуючи метод saveToFile().
     * Якщо вказана назва фільму не знайдена в колекції, буде виведено повідомлення про відсутність фільму.
     *
     * @param filmName Назва фільму, доход якого потрібно оновити.
     * @param revenue Нове значення доходу, яке потрібно встановити для вказаного фільму.
     */
    public void updateFilmRevenue(String filmName, double revenue)
    {
        for (FilmRevenueDirectory film : films) {
            if (film.getFilmName().equals(filmName)) {
                film.setRevenue(revenue);
                saveToFile();
                return;
            }
        }
        System.out.println("Фільм з назвою " + filmName + " не знайдено.");
    }

    /**
     * Отримує всі фільми з файлу, відсортовані за назвою у алфавітному порядку, та виводить їх на екран.
     */
    public void getAllFilms()
    {
        HashSet<FilmRevenueDirectory> tempFilms = loadFromFile();
        TreeSet<FilmRevenueDirectory> sortFilms = new TreeSet<>(Comparator.comparing(FilmRevenueDirectory::getFilmName));
        sortFilms.addAll(tempFilms);
        for (FilmRevenueDirectory film : sortFilms)
        {
            System.out.println(film.toString() + "\n");
        }
    }
}
