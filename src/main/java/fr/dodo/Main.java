package fr.dodo;

import fr.dodo.Functions.ReadFileLineByLineUsingFiles;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Définition des Listes...");
        List<String> listCal = ReadFileLineByLineUsingFiles.getCalorieLine(Main.class.getClassLoader().getResource("cal.txt").getPath().toString());
        List<Integer> listTotal = new ArrayList<Integer>();

        System.out.println("Lancement de la boucle de calcul...");
        Integer i = 0;
        for (String cal : listCal) {
            if (cal.equals("")) {
                listTotal.add(i);
                i = 0;
            } else {
                i = i + Integer.valueOf(cal);
            }
        }
        System.out.println("Calculs Terminés");

        System.out.println("Lancement de la recherche du plus grand stock...");
        Integer r = 0;
        while (r <= 2) {
            Integer n = 0;
            for (Integer total : listTotal) {
                if (total > n) {
                    n = total;
                }
            }
            listTotal.remove(n);
            System.out.println(r+1 + ". plus grand : " + n);
            r++;
        }

        System.out.println("-----------------------------------------------------------");
        System.out.println("Traitement Terminé");
        System.out.println("-----------------------------------------------------------");
    }
}