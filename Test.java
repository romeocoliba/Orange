import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Telefonie_Mobila.Tarif;
import Telefonie_Mobila.Tarifs.Tarif130;
import Telefonie_Mobila.Tarifs.Tarif170;
import Telefonie_Mobila.Tarifs.Tarif190;
import Telefonie_Mobila.Tarifs.Tarif270;
import User.Abonat;



public class Test {

    public static void main(String args[]) {
        ArrayList<Abonat> abonatsList = new ArrayList<>();
        ArrayList<Tarif> tarifList = new ArrayList<>();

        try {
            Scanner reader130 = new Scanner(new FileReader("Telefonie_Mobila/TarifsDB/tarif130.in"));
            Scanner reader170 = new Scanner(new FileReader("Telefonie_Mobila/TarifsDB/tarif170.in"));
            Scanner reader190 = new Scanner(new FileReader("Telefonie_Mobila/TarifsDB/tarif190.in"));
            Scanner reader270 = new Scanner(new FileReader("Telefonie_Mobila/TarifsDB/tarif270.in"));

            String nameTarif;
            String minutes;
            String roumingMin;
            String internetGB;
            String roumingInterGB;
            String price;
            String description;

            nameTarif = reader130.nextLine();
            minutes = reader130.nextLine();
            roumingMin = reader130.nextLine();
            internetGB = reader130.nextLine();
            roumingInterGB = reader130.nextLine();
            price = reader130.nextLine();
            description = reader130.nextLine();

            Tarif130 tarif130 = new Tarif130(nameTarif,minutes, roumingMin, internetGB, roumingInterGB, price, description);

            nameTarif = reader170.nextLine();
            minutes = reader170.nextLine();
            roumingMin = reader170.nextLine();
            internetGB = reader170.nextLine();
            roumingInterGB = reader170.nextLine();
            price = reader170.nextLine();
            description = reader170.nextLine();

            Tarif170 tarif170 = new Tarif170(nameTarif, minutes, roumingMin, internetGB, roumingInterGB, price, description);

            nameTarif = reader190.nextLine();
            minutes = reader190.nextLine();
            roumingMin = reader190.nextLine();
            internetGB = reader190.nextLine();
            roumingInterGB = reader190.nextLine();
            price = reader190.nextLine();
            description = reader190.nextLine();

            Tarif190 tarif190 = new Tarif190(nameTarif, minutes, roumingMin, internetGB, roumingInterGB, price, description);

            nameTarif = reader270.nextLine();
            minutes = reader270.nextLine();
            roumingMin = reader270.nextLine();
            internetGB = reader270.nextLine();
            roumingInterGB = reader270.nextLine();
            price = reader270.nextLine();
            description = reader270.nextLine();

            Tarif270 tarif270 = new Tarif270(nameTarif, minutes, roumingMin, internetGB, roumingInterGB, price, description);

            reader130.close();
            reader170.close();
            reader190.close();
            reader270.close();

            tarifList.add(tarif130);
            tarifList.add(tarif170);
            tarifList.add(tarif190);
            tarifList.add(tarif270);

            Scanner readerAbonats = new Scanner(new FileReader("User/Abonat.in"));

            while (readerAbonats.hasNext()) {
                String name = readerAbonats.nextLine();
                String surname = readerAbonats.nextLine();
                String tarif = readerAbonats.nextLine();
                String balance = readerAbonats.nextLine();

                Abonat newAbonat = new Abonat(name, surname, tarif, balance);

                abonatsList.add(newAbonat);
            }

            readerAbonats.close();

        } catch (IOException error) {
            System.out.println("ERROR FISIERUL NU A FOST GASIT");
        } catch (NoSuchElementException error) {
            System.out.println("ERROR FISIERUL NU ESTE COMPLETAT CORECT");
        } catch (NumberFormatException error) {
            System.out.println("ERROARE IN FISIER, NUMERELE NU TREBUIE SA CONTINE VIRGULA (,)");
        }

        String alegere = "undefined";
        Scanner reader = new Scanner(System.in);

        do {

            System.out.println("\n\nMENU:\n");
            System.out.println("1. Sortare tarife in functie de plata.");
            System.out.println("2. Cautare Tarif.");
            System.out.println("3. Tarif intr-un diapazon anumit.");

            System.out.print("\nAlegeti optiunea dorita : ");
            alegere = reader.nextLine();

            switch (alegere) {
                case "1": {

                    int find130 = 0, find170 = 0, find190 = 0, find270 = 0;

                    for (Abonat abonat : abonatsList) {
                        String tarif = abonat.getTarif();

                        if (tarif.equals("TOP 130")) {
                            find130++;
                        } else if (tarif.equals("TOP 170")) {
                            find170++;
                        } else if (tarif.equals("TOP 190")) {
                            find190++;
                        } else if (tarif.equals("TOP 270")) {
                            find270++;
                        }
                    }

                    if (find130 == 0) {
                        tarifList.remove(0);
                    }
                    if (find170 == 0) {
                        tarifList.remove(1);
                    }
                    if (find190 == 0) {
                        tarifList.remove(2);
                    }
                    if (find270 == 0) {
                        tarifList.remove(3);
                    }

                    System.out.println("SORTAT CU SUCCES");

                    System.out.print("\nMenu/Exit \n\nIntroduceti : ");
                    alegere = reader.nextLine();
                    if (alegere.equals("Exit")) {
                        System.out.println("\n\nMultumesc ca ati folosit programul.");
                        System.exit(1);
                    }

                    for(Abonat abonat : abonatsList){
                        abonat.afisare_abonat();
                    }

                    for(Tarif tarif : tarifList){
                        tarif.afisare();
                    }
                    break;

                }
                case "2": {

                    System.out.print("\n\nIntroduceti un cuvant dupa care doriti sa faceti cautarea.\nSearch : ");
                    alegere = reader.nextLine();

                    ArrayList<Tarif> searchResult = new ArrayList<>();

                    try {
                        for (Tarif tarif : tarifList) {
                            if (tarif.getName().equals(alegere)) {
                                searchResult.add(tarif);
                                tarif.setSearchResult("A fost gasit cu ajutorul numelui tarifului");
                            }
                        }

                        for (Tarif tarif : tarifList) {
                            if (tarif.getRoumingMin().equals(alegere)) {
                                searchResult.add(tarif);
                                tarif.setSearchResult("A fost gasit cu ajutorul minutelor in rouming");
                            }
                            if (tarif.getInternetGB().equals(alegere)) {
                                searchResult.add(tarif);
                                tarif.setSearchResult("A fost gasit cu ajutorul cantitatii de GB");
                            }
                            if (tarif.getRoumingInterGB().equals(alegere)) {
                                searchResult.add(tarif);
                                tarif.setSearchResult("A fost gasit cu ajutorul cantitatii de GB in Rouming");
                            }
                            if (tarif.getPrice().equals(alegere)) {
                                searchResult.add(tarif);
                                tarif.setSearchResult("A fost gasit cu ajutorul pretului");
                            }

                        }

                        for (Tarif tarif : tarifList) {

                            if (tarif.getMinutes().equals(alegere)) {
                                searchResult.add(tarif);
                                tarif.setSearchResult("A fost gasit cu ajutorul minutelor");
                            }
                            if (tarif.getPrice().equals(alegere)) {
                                searchResult.add(tarif);
                                tarif.setSearchResult("A fost gasit cu ajutorul pretului");
                            }

                        }
                    } catch (NumberFormatException error) {
                        System.out.println("");
                    }

                    System.out.println("\n\n\nCAUTARE REZULTAT : \n");
                    if (searchResult.size() == 0) {
                        System.out.println("Nimic nu s-a gasit dupa ceea ce ati introdus -> [ " + alegere + " ]");
                    } else {
                        for (Tarif tarif : searchResult) {
                            tarif.afisare();
                            System.out.println("\n A fost gasit dupa : " + tarif.getSearchResult());
                        }
                    }

                    System.out.print("\nMenu/Exit \n\nIntroduceti : ");
                    alegere = reader.nextLine();
                    if (alegere.equals("Exit")) {
                        System.out.println("\n\nMultumesc ca ati folosit programul.");
                        System.exit(1);
                    }
                    break;
                }
                case "3": {
                    System.out.println("\n\nIntroduceti diapazonul : \n");
                    System.out.print("Inceput : ");
                    String start = reader.nextLine();
                    System.out.print("Sfarsit : ");
                    String end = reader.nextLine();

                    for (Tarif tarif : tarifList) {
                        int currentPrice = Integer.parseInt(tarif.getPrice());

                        if (currentPrice >= Integer.parseInt(start) && currentPrice <= Integer.parseInt(end)) {
                            tarif.afisare();
                        }
                    }

                    System.out.print("\nMenu/Exit \n\nIntroduceti : ");
                    alegere = reader.nextLine();
                    if (alegere.equals("Exit")) {
                        System.out.println("\n\nMultumesc ca ati folosit programul.");
                        System.exit(1);
                    }
                    break;
                }
                default: {
                    break;
                }
            }

        } while (!alegere.equals("0"));

        reader.close();

    }
}
