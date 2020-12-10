package ua.lviv.iot.view;

import ua.lviv.iot.controller.impl.*;
import ua.lviv.iot.model.entity.*;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyView {

    private static final Scanner SCANNER = new Scanner(System.in, StandardCharsets.UTF_8);
    private final ActorController actorController = new ActorController();
    private final CinemaController cinemaController =
            new CinemaController();
    private final CountryController countryController = new CountryController();
    private final FilmController filmController = new FilmController();
    private final HallController hallController = new HallController();
    private final ManController manController = new ManController();
    private final ReviewController reviewController = new ReviewController();
    private final SessionController sessionController = new SessionController();

    private final Map<String, Printable> menu = new LinkedHashMap<>();

    public MyView() {

        menu.put("11", this::getAllActor);
        menu.put("12", this::getActorById);
        menu.put("13", this::createActor);
        menu.put("14", this::updateActor);
        menu.put("15", this::deleteActor);

        menu.put("21", this::getAllCinema);
        menu.put("22", this::getCinemaById);
        menu.put("23", this::createCinema);
        menu.put("24", this::updateCinema);
        menu.put("25", this::deleteCinema);

        menu.put("31", this::getAllCountries);
        menu.put("32", this::getCountryById);
        menu.put("33", this::createCountry);
        menu.put("34", this::updateCountry);
        menu.put("35", this::deleteCountry);

        menu.put("41", this::getAllFilm);
        menu.put("42", this::getFilmById);
        menu.put("43", this::createFilm);
        menu.put("44", this::updateFilm);
        menu.put("45", this::deleteFilm);

        menu.put("51", this::getAllMan);
        menu.put("52", this::getManById);
        menu.put("53", this::createMan);
        menu.put("54", this::updateMan);
        menu.put("55", this::deleteMan);

        menu.put("61", this::getAllHall);
        menu.put("62", this::getHallById);
        menu.put("63", this::createHall);
        menu.put("64", this::updateHall);
        menu.put("65", this::deleteHall);

        menu.put("71", this::getAllReview);
        menu.put("72", this::getReviewById);
        menu.put("73", this::createReview);
        menu.put("74", this::updateReview);
        menu.put("75", this::deleteReview);

        menu.put("81", this::getAllSession);
        menu.put("82", this::getSessionById);
        menu.put("83", this::createSession);
        menu.put("84", this::updateSession);
        menu.put("85", this::deleteSession);
    }

    public void displayMenu() {
        System.out.println("=======================================================================");
        System.out.println("                 Enter XY to choose the option, where:");
        System.out.println("=======================================================================");
        System.out.println("X - entity number:                 |       Y - CRUD number:");
        System.out.println("  1 - actor                        |         1 - GET ALL");
        System.out.println("  2 - cinema                       |         2 - GET ONE");
        System.out.println("  3 - country                      |         3 - CREATE");
        System.out.println("  4 - film                         |         4 - UPDATE");
        System.out.println("  5 - man                          |         5 - DELETE");
        System.out.println("  6 - hall");
        System.out.println("  7 - review");
        System.out.println("  8 - session");
        System.out.println("E.G. actor (X=1) - get all (Y=1): 11");
        System.out.println("     country (X=3) - update (Y=4): 34");
        System.out.println("     film (X=4) - get one (Y=2): 42");
        System.out.println("=======================================================================");
    }

    public final void show() {
        String input;
        displayMenu();
        System.out.println("\nChoose your fighter:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }

    private void getAllActor() throws SQLException {
        System.out.println("\n[ACTOR / GET]");
        System.out.println(actorController.findAll() + "\n");
    }

    private void getActorById() throws SQLException {
        System.out.println("\n[ACTOR / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(actorController.findOne(id) + "\n");
    }

    private ActorEntity getActorInputs() {
        System.out.println("Enter education status (1 - online/0 - offline): ");
        int actingEducation = SCANNER.nextInt();
        if (actingEducation != 1) {
            actingEducation = 0;
        }
        System.out.println("Enter actor biography: ");
        String biography = SCANNER.next();
        System.out.println("Enter man ID: ");
        Integer manId = SCANNER.nextInt();
        ManEntity one = manController.findOne(manId);
        return new ActorEntity(actingEducation, biography, one);
    }

    private void createActor() throws SQLException {
        System.out.println("\n[ACTOR / CREATE]");
        ActorEntity account = getActorInputs();
        actorController.create(account);
        System.out.println("Actor successfully created\n");
    }

    private void updateActor() throws SQLException {
        System.out.println("\n[Actor / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        ActorEntity actorEntity = getActorInputs();

        actorController.update(id, actorEntity);
        System.out.println("Actor with ID=" + id + " successfully updated\n");
    }

    private void deleteActor() throws SQLException {
        System.out.println("\n[ACTOR / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        actorController.delete(id);
        System.out.println("Actor with ID=" + id + " successfully deleted\n");
    }


    private void getAllCinema() throws SQLException {
        System.out.println("\n[CINEMA / GET]");
        System.out.println(cinemaController.findAll() + "\n");
    }

    private void getCinemaById() throws SQLException {
        System.out.println("\n[CINEMA / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(cinemaController.findOne(id) + "\n");
    }

    private CinemaEntity getCinemaInputs() {
        System.out.println("Enter city: ");
        String city = SCANNER.next();
        System.out.println("Enter address: ");
        String address = SCANNER.next();
        System.out.println("Enter country ID: ");
        Integer countryId = SCANNER.nextInt();
        CountryEntity one = countryController.findOne(countryId);
        return new CinemaEntity( city, address, one);
    }

    private void createCinema() throws SQLException {
        System.out.println("\n[CINEMA / CREATE]");
        CinemaEntity cinemaEntity = getCinemaInputs();
        cinemaController.create(cinemaEntity);
        System.out.println("Cinema successfully created\n");
    }

    private void updateCinema() throws SQLException {
        System.out.println("\n[CINEMA / UPDATE]");
        CinemaEntity cinemaEntity = getCinemaInputs();

        cinemaController.update(cinemaEntity.getId(),
                cinemaEntity);
        System.out.println("Cinema with ID=" + cinemaEntity.getId()
                + " successfully updated\n");
    }

    private void deleteCinema() throws SQLException {
        System.out.println("\n[CINEMA / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        cinemaController.delete(id);
        System.out.println("Cinema with ID=" + id + " successfully deleted\n");
    }


    private void getAllCountries() throws SQLException {
        System.out.println("\n[COUNTRY / GET]");
        List<CountryEntity> all = countryController.findAll();
        for (CountryEntity country :
                all) {
            System.out.println(country.toString());
        }
    }

    private void getCountryById() throws SQLException {
        System.out.println("\n[COUNTRY / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        CountryEntity one = countryController.findOne(id);
        System.out.println(one.toString());
    }

    private CountryEntity getCountryInputs() {

        System.out.println("\nEnter country's population: ");
        Integer population = SCANNER.nextInt();
        System.out.println("\nEnter country's areaInSk: ");
        Double areaInSk = SCANNER.nextDouble();
        System.out.println("\nEnter country's name: ");
        Scanner scanner = new Scanner(System.in);
        String countryName = scanner.nextLine();
        System.out.println("\nEnter country's capital: ");
        String capital = scanner.nextLine();
        return new CountryEntity( capital, population, areaInSk, countryName);
    }

    private void createCountry() throws SQLException {
        System.out.println("\n[COUNTRY / CREATE]");
        CountryEntity countryEntity = getCountryInputs();
        countryController.create(countryEntity);
        System.out.println("Country successfully created\n");
    }

    private void updateCountry() throws SQLException {
        System.out.println("\n[COUNTRY / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        CountryEntity countryEntity = getCountryInputs();
        countryEntity.setId(id);

        countryController.update(countryEntity.getId(), countryEntity);
        System.out.println("Country with ID=" + id + " successfully updated\n");
    }

    private void deleteCountry() throws SQLException {
        System.out.println("\n[COUNTRY / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        countryController.delete(id);
        System.out.println("Country with ID=" + id + " successfully deleted\n");
    }


    private void getAllFilm() throws SQLException {
        System.out.println("\n[FILM / GET]");
        System.out.println(filmController.findAll() + "\n");
    }

    private void getFilmById() throws SQLException {
        System.out.println("\n[FILM / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(filmController.findOne(id) + "\n");
    }

    private FilmEntity getFilmInputs() {
        System.out.println("\nEnter move title : ");
        String moveTitle = SCANNER.next();
        System.out.println("Enter genre: ");
        String genre = SCANNER.next();
        System.out.println("Enter description: ");
        String description = SCANNER.next();
        System.out.println("Enter release date: ");
        String releaseDate = SCANNER.next();

        return new FilmEntity( moveTitle, genre, description, releaseDate);
    }

    private void createFilm() throws SQLException {
        System.out.println("\n[FILM / CREATE]");
        FilmEntity filmEntity = getFilmInputs();
        filmController.create(filmEntity);
        System.out.println("Film successfully created\n");
    }

    private void updateFilm() throws SQLException {
        System.out.println("\n[FILM / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        FilmEntity filmEntity = getFilmInputs();
        filmEntity.setId(id);

        filmController.update(filmEntity.getId(), filmEntity);
        System.out.println("Film with ID=" + id + " successfully updated\n");
    }

    private void deleteFilm() throws SQLException {
        System.out.println("\n[FILM / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        filmController.delete(id);
        System.out.println("Film with ID=" + id + " successfully deleted\n");
    }




    private void getAllHall() throws SQLException {
        System.out.println("\n[Hall / GET]");
        System.out.println(hallController.findAll() + "\n");
    }

    private void getHallById() throws SQLException {
        System.out.println("\n[HALL / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(hallController.findOne(id) + "\n");
    }

    private HallEntity getHallInputs() {
        System.out.println("\nEnter numb of seats: ");
        Integer numOfSeats = SCANNER.nextInt();
        System.out.println("\nEnter cinema ID: ");
        Integer cinemaId = SCANNER.nextInt();
        CinemaEntity one = cinemaController.findOne(cinemaId);
        return new HallEntity( numOfSeats, one);
    }

    private void createHall() throws SQLException {
        System.out.println("[HALL / CREATE]");
        HallEntity hallEntity = getHallInputs();
        hallController.create(hallEntity);
        System.out.println("Hall successfully created\n");
    }

    private void updateHall() throws SQLException {
        System.out.println("\n[Hall / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        HallEntity hallEntity = getHallInputs();
        hallEntity.setId(id);

        hallController.update(hallEntity.getId(), hallEntity);
        System.out.println("Hall with ID=" + id + " successfully updated\n");
    }

    private void deleteHall() throws SQLException {
        System.out.println("\n[Hall / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        hallController.delete(id);
        System.out.println("Hall with ID=" + id + " successfully deleted\n");
    }

    private void getAllReview() throws SQLException {
        System.out.println("\n[REVIEW / GET]");
        System.out.println(manController.findAll() + "\n");
    }

    private void getReviewById() throws SQLException {
        System.out.println("\n[REVIEW / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(manController.findOne(id) + "\n");
    }

    private ReviewEntity getReviewInputs() {
        System.out.println("\nEnter response: ");
        String response = SCANNER.next();
        System.out.println("\nEnter rating: ");
        Integer rating = SCANNER.nextInt();
        System.out.println("Enter recommended status (1 - online/0 - offline): ");
        int recommended = SCANNER.nextInt();
        if (recommended != 1) {
            recommended = 0;
        }
        System.out.println("\nEnter man id who write this review: ");
        Integer manId = SCANNER.nextInt();
        System.out.println("\nEnter film id which belong this review: ");
        Integer filmId = SCANNER.nextInt();
        ManEntity manEntity = manController.findOne(manId);
        FilmEntity filmEntity = filmController.findOne(filmId);
        return new ReviewEntity( response, rating, recommended, manEntity, filmEntity);
    }

    private void createReview() throws SQLException {
        System.out.println("[REVIEW / CREATE]");
        ReviewEntity reviewEntity = getReviewInputs();
        reviewController.create(reviewEntity);
        System.out.println("Review successfully created\n");
    }

    private void updateReview() throws SQLException {
        System.out.println("\n[REVIEW / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        ReviewEntity reviewEntity = getReviewInputs();
        reviewEntity.setId(id);

        reviewController.update(reviewEntity.getId(), reviewEntity);
        System.out.println("Review with ID=" + id + " successfully updated\n");
    }

    private void deleteReview() throws SQLException {
        System.out.println("\n[REVIEW / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        reviewController.delete(id);
        System.out.println("Review with ID=" + id + " successfully deleted\n");
    }


    private void getAllSession() throws SQLException {
        System.out.println("\n[SESSION / GET]");
        System.out.println(sessionController.findAll() + "\n");
    }

    private void getSessionById() throws SQLException {
        System.out.println("\n[SESSION / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(sessionController.findOne(id) + "\n");
    }

    private SessionEntity getSessionInputs() {
        System.out.println("Enter event time: ");
        String eventTime = SCANNER.next();
        System.out.println("Enter ticket price: ");
        Integer ticketPrice = SCANNER.nextInt();
        System.out.println("Enter ticket sold: ");
        Integer ticketSold = SCANNER.nextInt();
        System.out.println("Enter film ID: ");
        Integer filmId = SCANNER.nextInt();
        System.out.println("Enter hall ID:: ");
        Integer hallId = SCANNER.nextInt();
        HallEntity hallEntity = hallController.findOne(hallId);
        FilmEntity filmEntity = filmController.findOne(filmId);
        return new SessionEntity( eventTime, ticketPrice, ticketSold, filmEntity, hallEntity);
    }

    private void createSession() throws SQLException {
        System.out.println("[SESSION / CREATE]");
        SessionEntity sessionEntity = getSessionInputs();
        sessionController.create(sessionEntity);
        System.out.println("Session successfully created\n");
    }

    private void updateSession() throws SQLException {
        System.out.println("\n[SESSION / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        SessionEntity sessionEntity = getSessionInputs();
        sessionEntity.setId(id);

        sessionController.update(sessionEntity.getId(), sessionEntity);
        System.out.println("Session with ID=" + id + " successfully updated\n");
    }

    private void deleteSession() throws SQLException {
        System.out.println("\n[SESSION / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        sessionController.delete(id);
        System.out.println("Session with ID=" + id + " successfully deleted\n");
    }


    private void getAllMan() throws SQLException {
        System.out.println("\n[MAN / GET]");
        System.out.println(manController.findAll() + "\n");
    }

    private void getManById() throws SQLException {
        System.out.println("\n[SESSION / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(manController.findOne(id) + "\n");
    }

    private ManEntity getManInputs() {
        System.out.println("Enter first name: ");
        String firstName = SCANNER.next();
        System.out.println("Enter last name: ");
        String lastName = SCANNER.next();
        System.out.println("Enter gender: ");
        String gender = SCANNER.next();
        System.out.println("Enter age: ");
        Integer age = SCANNER.nextInt();
        return new ManEntity(-1, firstName, lastName, age, gender);
    }

    private void createMan() throws SQLException {
        System.out.println("[Man / CREATE]");
        ManEntity manEntity = getManInputs();
        manController.create(manEntity);
        System.out.println("Man successfully created\n");
    }

    private void updateMan() throws SQLException {
        System.out.println("\n[MAN / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        ManEntity manEntity = getManInputs();
        manEntity.setId(id);

        manController.update(manEntity.getId(), manEntity);
        System.out.println("Man with ID=" + id + " successfully updated\n");
    }

    private void deleteMan() throws SQLException {
        System.out.println("\n[MAN / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        manController.delete(id);
        System.out.println("MAN with ID=" + id + " successfully deleted\n");
    }
}
