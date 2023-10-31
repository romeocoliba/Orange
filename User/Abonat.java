package User;

public class Abonat {
    private String name;
    private String surname;
    private String tarif;
    private String balance;

    public Abonat(String name, String surname, String tarif, String balance) {
        this.name = name;
        this.surname = surname;
        this.tarif = tarif;
        this.balance = balance;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTarif() {
        return this.tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getBalance() {
        return this.balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public void afisare_abonat() {
        System.out.println("");
        System.out.println("Prenume : " + name);
        System.out.println("Nume : " + surname);
        System.out.println("Tarif : " + tarif);
        System.out.println("Bani pe cont : " + balance);
    }

}
