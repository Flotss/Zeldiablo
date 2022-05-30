package gameLaby.laby;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * classe labyrinthe. represente un labyrinthe avec
 * <ul> des murs </ul>
 * <ul> un personnage (x,y) </ul>
 */
public class Labyrinthe {

    /**
     * Constantes char
     */
    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char VIDE = '.';
    public static final char CAISSE = 'C';
    public static final char EMPLACEMENT_CAISSE = 'O';

    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";

    /**
     * attribut du personnage
     */
    public Perso pj;

    /**
     * les murs du labyrinthe
     */
    public boolean[][] murs;

    /**
     * les caisses du labyrinthe
     */
    public boolean[][] caisses;

    /**
     * les emplacements pour les caisses du labyrinthe
     */
    public ArrayList<int[]> emplacementCaisse;


    /**
     * retourne la case suivante selon une actions
     *
     * @param x      case depart
     * @param y      case depart
     * @param action action effectuee
     * @return case suivante
     */
    static int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT:
                // on monte une ligne
                y--;
                break;
            case BAS:
                // on descend une ligne
                y++;
                break;
            case DROITE:
                // on augmente colonne
                x++;
                break;
            case GAUCHE:
                // on augmente colonne
                x--;
                break;
            default:
                throw new Error("action inconnue");
        }
        int[] res = {x, y};
        return res;
    }

    /**
     * charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
     * @return labyrinthe cree
     * @throws IOException probleme a la lecture / ouverture
     */
    public Labyrinthe(String nom) throws IOException {
        // ouvrir fichier
        FileReader fichier = new FileReader(nom);
        BufferedReader bfRead = new BufferedReader(fichier);

        int nbLignes, nbColonnes;
        // lecture nblignes
        nbLignes = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        nbColonnes = Integer.parseInt(bfRead.readLine());

        // creation labyrinthe vide
        this.murs = new boolean[nbColonnes][nbLignes];
        this.caisses = new boolean[nbColonnes][nbLignes];
        this.pj = null;

        // lecture des cases
        String ligne = bfRead.readLine();

        // stocke les indices courants
        int numeroLigne = 0;

        //initialisation de l'arraylist emplacement caisse
        this.emplacementCaisse = new ArrayList<>();

        // parcours le fichier
        while (ligne != null) {

            // parcours de la ligne
            for (int colonne = 0; colonne < ligne.length(); colonne++) {
                char c = ligne.charAt(colonne);
                switch (c) {
                    case MUR:
                        this.murs[colonne][numeroLigne] = true;
                        break;
                    case CAISSE:
                        this.caisses[colonne][numeroLigne] = true;
                        break;
                    case EMPLACEMENT_CAISSE:
                        this.emplacementCaisse.add(new int[]{colonne, numeroLigne});
                        break;
                    case VIDE:
                        this.murs[colonne][numeroLigne] = false;
                        break;
                    case PJ:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute PJ
                        this.pj = new Perso(colonne, numeroLigne);
                        break;


                    default:
                        throw new Error("caractere inconnu " + c);
                }
            }

            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }

        // ferme fichier
        bfRead.close();
    }


    /**
     * deplace le personnage en fonction de l'action.
     * gere la collision avec les murs
     *
     * @param action une des actions possibles
     */
    public void deplacerPerso(String action) {
        // case courante
        int[] courante = {this.pj.x, this.pj.y};

        // calcule case suivante
        int[] suivante = getSuivant(courante[0], courante[1], action);
        if (caisses[suivante[0]][suivante[1]]) {
            // on a une caisse
            deplacerCaisse(suivante[0], suivante[1], action);
            if(etreFini()){
                System.out.println("Bravo, vous avez finis");
            }
        }
        // si c'est pas un mur, on effectue le deplacement
        if (!this.murs[suivante[0]][suivante[1]] && !caisses[suivante[0]][suivante[1]]) {
            // on met a jour personnage
            this.pj.x = suivante[0];
            this.pj.y = suivante[1];
        }

    }

    /**
     * Deplace la caisse en fonction de la direction.
     *
     * @param x         Coordonnee x de la caisse
     * @param y         Coordonnee y de la caisse
     * @param direction Direction du personnage
     * @return Si la caisse a ete deplacee
     */
    public boolean deplacerCaisse(int x, int y, String direction) {

        // calcule case suivante
        int[] suivante = getSuivant(x, y, direction);

        // si c'est pas un mur, on effectue le deplacement
        if (caseDisponible(suivante[0], suivante[1])) {
            // on met a jour la caisse
            this.caisses[x][y] = false;
            this.caisses[suivante[0]][suivante[1]] = true;
            // on renvoie true si la caisse a ete deplacee
            return true;
        }
        return false;
    }

    /**
     * Test si la case est disponible
     * Pour une caisse ou un personnage ou un mur
     *
     * @param x Coordonnee x de la case
     * @param y Coordonnee y de la case
     * @return true si la case est disponible
     */
    public boolean caseDisponible(int x, int y) {
        return !this.murs[x][y] && !this.caisses[x][y];
    }


    /**
     * @return fin du jeu
     */
    public boolean etreFini() {
        boolean finis = true;
        for (int i = 0; i < emplacementCaisse.size(); i++) {
            if(!this.caisses[emplacementCaisse.get(i)[0]][emplacementCaisse.get(i)[1]]){
                finis = false;
                break;
            }

        }
        return finis;
    }

    // ##################################
    // GETTER
    // ##################################

    /**
     * return taille selon Y
     *
     * @return
     */
    public int getLengthY() {
        return murs[0].length;
    }

    /**
     * return taille selon X
     *
     * @return
     */
    public int getLength() {
        return murs.length;
    }

    /**
     * return mur en (i,j)
     *
     * @param x
     * @param y
     * @return
     */
    public boolean getMur(int x, int y) {
        // utilise le tableau de boolean
        return this.murs[x][y];
    }

    public boolean getCaisse(int x, int y) {
        return this.caisses[x][y];
    }

    public ArrayList<int[]> getEmplacementCaisse() {
        return emplacementCaisse;
    }


}
