package Telefonie_Mobila;

public class Tarif {
    private String name;
    private String minutes;
    private String roumingMin;

    private String internetGB;
    private String roumingInterGB;

    private String price;
    private String description;

    private String searchResult = "NEDEFINIT";

    public Tarif(String name, String minutes, String roumingMin, String internetGB, String roumingInterGB, String price,
            String description) {
        this.name = name;
        this.minutes = minutes;
        this.roumingMin = roumingMin;
        this.internetGB = internetGB;
        this.roumingInterGB = roumingInterGB;
        this.price = price;
        this.description = description;
    }

    public String getSearchResult() {
        return this.searchResult;
    }

    public void setSearchResult(String searchResult) {
        this.searchResult = searchResult;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMinutes() {
        return this.minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public String getRoumingMin() {
        return this.roumingMin;
    }

    public void setRoumingMin(String roumingMin) {
        this.roumingMin = roumingMin;
    }

    public String getInternetGB() {
        return this.internetGB;
    }

    public void setInternetGB(String internetGB) {
        this.internetGB = internetGB;
    }

    public String getRoumingInterGB() {
        return this.roumingInterGB;
    }

    public void setRoumingInterGB(String roumingInterGB) {
        this.roumingInterGB = roumingInterGB;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void afisare() {
        System.out.println();
        System.out.println("Nume Tarif : " + getName());
        System.out.println("Minute in retea : " + getMinutes());
        if (Double.parseDouble(getRoumingMin()) > 0) {
            System.out.println("Minute in Rouming : " + getRoumingMin());
        }
        System.out.println("Internet : " + getInternetGB() + "GB");
        if (Double.parseDouble(getRoumingInterGB()) > 0) {
            System.out.println("Internet Rouming : " + getRoumingInterGB() + "GB");
        }
        System.out.println("Descrierea : " + getDescription());
        System.out.println("Pretul : " + getPrice());
    }

}