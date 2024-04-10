public class FilmRevenueDirectory
{
    private String filmName;
    private double revenue;
    private String releaseDate;

    public FilmRevenueDirectory(String filmName, double revenue, String releaseDate)
    {
        this.filmName = filmName;
        this.revenue = revenue;
        this.releaseDate = releaseDate;
    }

    /**
     * Повертає назву фільму.
     * @return Назва фільму.
     */
    public String getFilmName() {
        return  this.filmName;
    }

    /**
     * Повертає касові збори фільму.
     * @return Касові збори фільму.
     */
    public double getRevenue() {
        return  this.revenue;
    }

    /**
     * Повертає дату виходу фільму.
     * @return Дата виходу фільму.
     */
    public String getReleaseDate() {
        return  this.releaseDate;
    }

    /**
     * Встановлює нове значення касових зборів для фільму.
     * @param revenue Нове значення касових зборів.
     */
    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    /**
     * Перевизначений метод toString, який повертає рядкове представлення об'єкта FilmRevenueDirectory.
     * @return Рядкове представлення об'єкта FilmRevenueDirectory.
     */
    @Override
    public String toString() {
        return "Фільм: " + this.filmName + ", Касові збори: " + this.revenue + ", Дата виходу: " + this.releaseDate;
    }
}
