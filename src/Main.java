public class Main {
    public static void main(String[] args)
    {
        FilmRevenueContainer container = new FilmRevenueContainer();

        container.addFilm(new FilmRevenueDirectory("Шерлок Холмс", 1000000, "2023-05-15"));
        container.addFilm(new FilmRevenueDirectory("Месники", 2000000, "2024-02-20"));
        container.addFilm(new FilmRevenueDirectory("Зоряні війни", 3000000, "2022-12-25"));
        container.addFilm(new FilmRevenueDirectory("Гаррі Поттер і філософський камінь", 1500000, "2001-11-16"));
        container.addFilm(new FilmRevenueDirectory("Титанік", 2500000, "1997-12-19"));
        container.addFilm(new FilmRevenueDirectory("Аватар", 3500000, "2009-12-18"));
        container.addFilm(new FilmRevenueDirectory("Хоббіт: Неочікувана подорож", 2000000, "2012-12-14"));
        container.addFilm(new FilmRevenueDirectory("Джентльмени", 1800000, "2019-12-03"));
        container.addFilm(new FilmRevenueDirectory("Інтерстеллар", 2800000, "2014-11-07"));
        container.addFilm(new FilmRevenueDirectory("Джокер", 3200000, "2019-10-04"));
        container.addFilm(new FilmRevenueDirectory("Темний лицар", 2700000, "2008-07-18"));
        container.addFilm(new FilmRevenueDirectory("Матриця", 2200000, "1999-03-31"));
        container.addFilm(new FilmRevenueDirectory("Інтерв'ю з вампіром", 1900000, "1994-11-11"));
        container.addFilm(new FilmRevenueDirectory("Гаррі Поттер і таємна кімната", 1200000, "2002-11-15"));
        container.addFilm(new FilmRevenueDirectory("Індіана Джонс: У пошуках втраченого ковчега", 1800000, "1981-06-12"));
        container.addFilm(new FilmRevenueDirectory("Форсаж 5", 2200000, "2011-04-29"));
        container.addFilm(new FilmRevenueDirectory("Титанік", 2800000, "1997-12-19"));
        container.addFilm(new FilmRevenueDirectory("Гладіатор", 1500000, "2000-05-05"));
        container.addFilm(new FilmRevenueDirectory("Володар перснів: Братство кільця", 2000000, "2001-12-19"));
        container.addFilm(new FilmRevenueDirectory("Той, що біжить по лезу 2049", 2300000, "2017-10-06"));
        container.addFilm(new FilmRevenueDirectory("Воно", 2700000, "2017-09-08"));
        container.addFilm(new FilmRevenueDirectory("Ігри голоду", 1900000, "2012-03-23"));
        container.addFilm(new FilmRevenueDirectory("Пернатий крадіжник", 1400000, "2014-08-01"));
        container.addFilm(new FilmRevenueDirectory("Пірати Карибського моря: Прокляття Чорної перлини", 2500000, "2003-07-09"));
        container.addFilm(new FilmRevenueDirectory("Крокодил Данді", 1600000, "1986-04-30"));
        container.addFilm(new FilmRevenueDirectory("Месники: Війна нескінченності", 3200000, "2018-04-27"));
        container.addFilm(new FilmRevenueDirectory("Судна ніч", 1800000, "2013-07-19"));
        container.addFilm(new FilmRevenueDirectory("Падіння Олімпу", 2000000, "2013-03-22"));
        container.addFilm(new FilmRevenueDirectory("Гра Престолів: Старт", 2900000, "2011-04-17"));
        container.addFilm(new FilmRevenueDirectory("Аліта: Бойовий ангел", 2100000, "2019-02-14"));
        container.addFilm(new FilmRevenueDirectory("Потяг на Пусан", 1700000, "2016-07-20"));
        container.addFilm(new FilmRevenueDirectory("Роботи з гонки", 2300000, "2013-05-24"));

        System.out.println("Виведення контейнера:");
        container.getAllFilms();

        FilmRevenueDirectory foundFilm = container.findFilmByName("Джокер");
        if (foundFilm != null) {
            System.out.println("\n\n\n\nЗнайдено фільм: " + foundFilm);
        } else {
            System.out.println("\n\n\n\nФільм не знайдено!");

        }

        System.out.println("\n\n\n\nОновлення даних про фільм;\n\n\n\n");
        container.updateFilmRevenue("Шерлок Холмс", 4000000);

        System.out.println("Виведення контейнера:");
        container.getAllFilms();

        System.out.println("\n\n\n\nВиведення фільма з контейнера;\n\n\n\n");
        container.removeFilm("Шерлок Холмс");

        System.out.println("Виведення контейнера:");
        container.getAllFilms();
    }
}