public class Main {
    public static void main(String[] args)
    {
        FilmRevenueContainer container = new FilmRevenueContainer();

        container.addFilm(new FilmRevenueDirectory("Шерлок Холмс", 1000000, "2023-05-15"));
        container.addFilm(new FilmRevenueDirectory("Месники", 2000000, "2024-02-20"));
        container.addFilm(new FilmRevenueDirectory("Зоряні війни", 3000000, "2022-12-25"));

        System.out.println("Виведення контейнера:");
        container.getAllFilms();

        FilmRevenueDirectory foundFilm = container.findFilmByName("Месники");
        if (foundFilm != null) {
            System.out.println("Знайдено фільм: " + foundFilm);
        } else {
            System.out.println("Фільм не знайдено!");
        }

        System.out.println("\nВиведення фільма з контейнера;" + "\n");
        container.removeFilm("Шерлок Холмс");

        System.out.println("Виведення контейнера:");
        container.getAllFilms();
    }
}