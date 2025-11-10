package jeu;

import java.util.HashMap;
import java.util.Map;

public class Regle {
    /**
     * Pour une tour:
      - choix du joueur recent du case qu il veut utiliser (reçois comme argument l'id du joueur et l'id du case)
      - sens du mouvement (selon ces choix)
      - gestion de Rotation circulaire des jetons (gestion des jetons que le joueur prend dans la case qu'il a choisi) 
         -> ajout d'une jeton dans la case qui suit celle du choix jusqu'à ce qu'il n'y a plus de jeton dans la main du joueur
         -> si dans la derniere case que le joueur ajout un jeton est vide alors son tour seras termine
     */

    /** 
      * apres avoir reçu les jetons on doit maintenant attribuet le sens du mouvement 
    */
    public static void chooseDirection(Joueur j,Joueur j2) {
        int[][] actu = j.getCases();
        // retour
        int[] result = new int[2];
        // ilay nosafidina
        int ligne = (int) j.getMap().get("ligne");
        int col = (int) j.getMap().get("col");

        // isan vato eny am tanany
        int enMain = j.getEnMain();
        if (enMain <= 1) {
            System.out.println("en main "+ enMain);
        } else {
            for (int i = 0; i < enMain; i++) {
                System.out.println("en main "+ i);
                // Ligne 0 : gauche -> droite
                if (ligne == 0) {
                    col++;
                    if (col > 3) {
                        ligne++;
                        actu[ligne][col-1]++;
                        System.out.println("ny col sup a 3: "+col);
                        System.out.println("nakao am ligne "+ ligne +" et col "+col+" point "+(actu[ligne][col-1]));
                        col = 3;
                    } else {
                        actu[ligne][col]++;
                        System.out.println("nakao am ligne "+ ligne +" et col "+col+" point "+(actu[ligne][col]));
                    }
                }
                // Ligne 1 : droite -> gauche
                else if (ligne == 1) {
                    // eto zany tonga de tretena le 2
                    col--;
                    if (col < 0) {
                        ligne--;
                        col = 0;
                        actu[ligne][col]++;
                        System.out.println("nakao am ligne "+ ligne +" et col "+col+" point "+(actu[ligne][col]));
                    } else {
                        actu[ligne][col]++;
                        System.out.println("nakao am ligne "+ ligne +" et col "+col+" point "+(actu[ligne][col]));
                    }
                }
                // System.out.println("------------------" + i);
                // actu[(int) j.getMap().get("ligne")][(int) j.getMap().get("col")] -= 1;
            }
            j.setCases(actu);
            
            // mbola afaka manohy izy eto
            if (actu[ligne][col] > 1) {
                System.out.println("Mbola afaka mihetsika");
                // j = Regle.getCase(j,ligne,col);
                j = Regle.minana(j,j2,ligne,col);
                Regle.chooseDirection(j,j2);
            }
        }

    }

    /**
     * maka anle premiere ligne meme col anle joueur hafa
     * @param j2
     * @param ligne
     * @param col
     */
    private static Joueur minana(Joueur j1,Joueur j2,int ligne,int col){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("ligne", ligne);
        map.put("col", col);
        j1.setMap(map);
        // ra oatra ka ts misy eo amle ligne volo zay vao mijery anle ligne manaraka
        int enMain = j1.getCases()[ligne][col];
        if (ligne == 0) {
            enMain = j1.getCases()[ligne][col]+j2.getCases()[0][col];
            j2.getCases()[0][col] = 0;
        }
        j1.setEnMain(enMain);

        j1.getCases()[ligne][col] = 0;
        return j1;
    }

    /**
     * ceci attribut le jeton dans la case dans la main du joueur
     * @param j
     * @param ligne,col
     */
    public static Joueur getCase(Joueur j,int ligne,int col){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("ligne", ligne);
        map.put("col", col);
        j.setMap(map);
        j.setEnMain(j.getCases()[ligne][col]);
        if (j.getCases()[ligne][col] <= 1 ) {
            return j;
        }
        j.getCases()[ligne][col] = 0;
        return j;
    }
    
}
