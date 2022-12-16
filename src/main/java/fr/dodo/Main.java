package fr.dodo;

import fr.dodo.Functions.ReadFileLineByLineUsingFiles;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Définition des Listes...");
        List<String> listCombinaison = ReadFileLineByLineUsingFiles.getCalorieLine(Main.class.getClassLoader().getResource("combinaison.txt").getPath().toString());

        // Pierre
        Integer A = 1;
        // Papier
        Integer B = 2;
        // Ciseaux
        Integer C = 3;

        // Pierre
        Integer X = 1;
        // Papier
        Integer Y = 2;
        // Ciseaux
        Integer Z = 3;

        Integer PREMIER = 0;
        Integer DERNIER = 0;

        System.out.println("Début du traitement des matchs...");
        Integer total = 0;
        Integer total2 = 0;
        for (String combinaison : listCombinaison) {
            if (combinaison.startsWith("A")) {
                PREMIER = A;
            } else if (combinaison.startsWith("B")) {
                PREMIER = B;
            } else if (combinaison.startsWith("C")) {
                PREMIER = C;
            }
            if (combinaison.endsWith("X")) {
                DERNIER = X;
            } else if (combinaison.endsWith("Y")) {
                DERNIER = Y;
            } else if (combinaison.endsWith("Z")) {
                DERNIER = Z;
            }

            Integer résultat = 0;
            if (PREMIER == DERNIER) {
                résultat = 3;
            }else if (DERNIER == 1 && PREMIER == 3) {
                résultat = 6;
            } else if (DERNIER == 2 && PREMIER == 1) {
                résultat = 6;
            } else if (DERNIER == 3 && PREMIER == 2) {
                résultat = 6;
            } else {
                résultat = 0;
            }
            total = total + résultat + DERNIER;

            if (DERNIER == 1 && PREMIER == 1) {
                DERNIER = 3;
                résultat = 0;
            }else if (DERNIER == 1 && PREMIER == 2) {
                DERNIER = 1;
                résultat = 0;
            } else if (DERNIER == 1 && PREMIER == 3) {
                DERNIER = 2;
                résultat = 0;
            } else if (DERNIER == 2) {
                DERNIER = PREMIER;
                résultat = 3;
            } else if (DERNIER == 3 && PREMIER == 1) {
                DERNIER = 2;
                résultat = 6;
            } else if (DERNIER == 3 && PREMIER == 2) {
                DERNIER = 3;
                résultat = 6;
            } else if (DERNIER == 3 && PREMIER == 3) {
                DERNIER = 1;
                résultat = 6;
            }
            total2 = total2 + résultat + DERNIER;
        }
        System.out.println("------------------------------------------------");
        System.out.println("Partie 1 : Le résultat de tout les score additionné est : " + total);
        System.out.println("Partie 2 : Le résultat de tout les score additionné est : " + total2);
    }
}