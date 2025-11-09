package jeu;

import java.util.HashMap;
import java.util.Map;

public class Joueur {
    int enMain; // lors de son choix le joueur prends le jeton dans la case choisie
    int nbJeton; // total pour faciliter le comptage
    int[][] cases = new int[2][4]; // 0 front , 1 back
    int[] casesFront = new int[4];
    int[] casesBack = new int[4];
    Map<String,Integer> map;
    boolean actif; // pour verifier si le joueur est actif

    
    public Joueur(int nbJeton, boolean actif,Map<String,Integer> map) {
        this.setNbJeton(nbJeton);
        this.setActif(actif);
        this.setCases(this.setPointsCase());
        this.setEnMain(0);
        this.setMap(map);
    }
    public Joueur(int nbJeton, int[] casesBack, int[] casesFront,int[][] cases,boolean actif) {
        this.setNbJeton(nbJeton);
        this.setActif(actif);
        this.setCasesBack(casesBack);
        this.setCasesFront(casesFront);
        this.setCases(cases);
        this.setEnMain(nbJeton);
    }
    public int getNbJeton() {
        return nbJeton;
    }
    public void setNbJeton(int nbJeton) {
        this.nbJeton = nbJeton;
    }
    public boolean isActif() {
        return actif;
    }
    public void setActif(boolean actif) {
        this.actif = actif;
    }
    public int[] getCasesFront() {
        return casesFront;
    }
    public void setCasesFront(int[] casesFront) {
        this.casesFront = casesFront;
    }
    public int[] getCasesBack() {
        return casesBack;
    }
    public void setCasesBack(int[] casesBack) {
        this.casesBack = casesBack;
    }
    public int getEnMain() {
        return enMain;
    }
    public void setEnMain(int enMain) {
        this.enMain = enMain;
    }
    public int[][] getCases() {
        return cases;
    }
    public void setCases(int[][] cases) {
        this.cases = cases;
    }
    public Map<String,Integer> getMap() {
        return map;
    }
    public void setMap(Map<String,Integer> map) {
        this.map = map;
    }

    private static int[][] setPointsCase(){
        int[][] cases = new int[2][4];
        cases[0][0] = 2;
        cases[0][1] = 2;
        cases[0][2] = 2;
        cases[0][3] = 2;

        cases[1][0] = 2;
        cases[1][1] = 2;
        cases[1][2] = 2;
        cases[1][3] = 2;

        return cases;
    }

    
}
