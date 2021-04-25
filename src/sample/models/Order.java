package sample.models;

public class Order {
    public Integer id; //id
    public String name; // Название
    public String author; // Автор
    public String publisher; // Издатель
    public String genre; // Жанр
    public String type; // Тип
    public Integer section; // Секция




    public Order(Integer id, String name, String author, String publisher, String genre, String type, Integer section ) {
        this.setId(id);
        this.setAuthor(author);
        this.setName(name);
        this.setPublisher(publisher);
        this.setSection(section);
        this.setGenre(genre);
        this.setType(type);
    }

    public Order(String name, String author, String publisher, String genre, String type, Integer section ) {
        this.setId(100);
        this.setAuthor(author);
        this.setName(name);
        this.setPublisher(publisher);
        this.setSection(section);
        this.setGenre(genre);
        this.setType(type);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}