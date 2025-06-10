package fr.dodo;

import fr.dodo.Functions.ReadFileLineByLineUsingFiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Définition des Listes...");
        List<String> listCal = ReadFileLineByLineUsingFiles.getCalorieLine(
                Main.class.getClassLoader().getResource("cal.txt").getPath());
        List<Integer> listTotal = new ArrayList<>();

        System.out.println("Lancement de la boucle de calcul...");
        int i = 0;
        for (String cal : listCal) {
            if (cal.isBlank()) {
                listTotal.add(i);
                i = 0;
            } else {
                i += Integer.parseInt(cal);
            }
        }
        // Fix: add the last group if file doesn't end with a blank line
        if (i != 0) {
            listTotal.add(i);
        }
        System.out.println("Calculs Terminés");

        System.out.println("Lancement de la recherche du plus grand stock...");
        int r = 0;
        int totalDesTrois = 0;
        while (r < 3 && !listTotal.isEmpty()) {
            int n = 0;
            for (Integer total : listTotal) {
                if (total > n) {
                    n = total;
                }
            }
            listTotal.remove(Integer.valueOf(n));
            System.out.println((r + 1) + ". plus grand : " + n);
            r++;
            totalDesTrois += n;
        }
        System.out.println("Le total des 3 plus grandes quantitée de calories : " + totalDesTrois);
        System.out.println("--------------------------------------------------------");
        System.out.println("Traitement Terminé");
        System.out.println("--------------------------------------------------------");
    }
}
