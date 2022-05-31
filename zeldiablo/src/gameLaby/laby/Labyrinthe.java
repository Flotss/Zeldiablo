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
    public static final char glacee = 'G';

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
    public Caisses caisses;

    /**
     * les emplacements pour les caisses du labyrinthe
     */
    public EmplacementsCaisse emplacementsCaisse;


    /**
     * les cases glacée du labyrinthe
     */
    public boolean[][] glace;

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
        return new int[]{x, y};
    }



    /**
     * charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
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
        this.caisses = new Caisses(nbColonnes, nbLignes);
        this.pj = null;
        this.glace = new boolean[nbColonnes][nbLignes];
        this.emplacementsCaisse = new EmplacementsCaisse(nbColonnes, nbLignes);

        // lecture des cases
        String ligne = bfRead.readLine();

        // stocke les indices courants
        int numeroLigne = 0;


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
                        this.caisses.ajouter(colonne, numeroLigne);
                        break;
                    case EMPLACEMENT_CAISSE:
                        this.emplacementsCaisse.ajouter(colonne, numeroLigne);
                        break;
                    case VIDE:
                        this.murs[colonne][numeroLigne] = false;
                        break;
                    case PJ:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute PJ
                        this.pj = new Perso(colonne, numeroLigne);
                    case glacee:
                        this.glace[colonne][numeroLigne] = true;
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
        //On repete le deplacement tant que la case sur laquelle le personnage se deplace est glacee (et non bloquée)
        boolean caseGlacee;
        do {
            // case courante
            int[] courante = {this.pj.x, this.pj.y};
            // calcule case suivante
            int[] suivante = getSuivant(courante[0], courante[1], action);
            caseGlacee = this.glace[suivante[0]][suivante[1]];

            if (this.caisses.pos[suivante[0]][suivante[1]]) {
                if (caseGlacee){
                    //Si la case derriere la caisse est bloquée, on ne pourra pas pousser plus la caisse donc on ne glissera plus
                    caseGlacee = caseDisponible(getSuivant(suivante[0], suivante[1], action)[0], getSuivant(suivante[0], suivante[1], action)[1]);
                }
                // on a une caisse
                deplacerCaisse(suivante[0], suivante[1], action);
            }
            // si c'est pas un mur, on effectue le deplacement
            if (!this.murs[suivante[0]][suivante[1]] && !caisses.pos[suivante[0]][suivante[1]]) {
                // on met a jour personnage
                this.pj.x = suivante[0];
                this.pj.y = suivante[1];
            }
        } while (caseGlacee);
    }

    /**
     * Deplace la caisse en fonction de la direction.
     *
     * @param x         Coordonnee x de la caisse
     * @param y         Coordonnee y de la caisse
     * @param direction Direction du personnage
     */
    public void deplacerCaisse(int x, int y, String direction) {
        int[] suivante = getSuivant(x, y, direction);
        int[] precedente = {x,y};
        boolean caseGlacee;
        do {
            // calcule case suivante
            caseGlacee = false;

            // si c'est pas un mur, on effectue le deplacement
            if (caseDisponible(suivante[0], suivante[1])) {
                caseGlacee = this.glace[suivante[0]][suivante[1]];
                // on met a jour la caisse
                this.caisses.deplacer(precedente[0], precedente[1], suivante[0], suivante[1]);
            }
            precedente = suivante;
            suivante = getSuivant(suivante[0],suivante[1],direction);
        } while (caseGlacee);
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
        return !this.murs[x][y] && !this.caisses.etrePresent(x,y);
    }


    /**
     * Methode qui renvoie si le jeu est fini
     * @return vrai si toutes les caisses sont sur les emplacements de caisse
     */
    public boolean etreFini() {
        return this.emplacementsCaisse.etreFini(this.caisses);
    }

    // ##################################
    // GETTER
    // ##################################

    /**
     * Getter Taille du labyrinthe verticale
     *
     * @return taille en vertical
     */
    public int getLengthY() {
        return murs[0].length;
    }

    /**
     * Getter Taille du labyrinthe horizontal
     *
     * @return taille en horizontal
     */
    public int getLength() {
        return murs.length;
    }

    /**
     * Getter mur de la position (x,y)
     *
     * @param x Coordonnee x
     * @param y Coordonnee y
     * @return boolean de la position
     */
    public boolean getMur(int x, int y) {
        // utilise le tableau de boolean
        return this.murs[x][y];
    }

    /**
     * Getter Caisse de la position (x,y)
     * @param x Coordonnee x
     * @param y Coordonnee y
     * @return true si la case est une caisse
     */
    public boolean getCaisse(int x, int y) {
        return this.caisses.pos[x][y];
    }

    /**
     * Getter glace de la position (x,y)
     * @param x Coordonnee x
     * @param y Coordonnee y
     * @return true si la case est glacee
     */
    public boolean getGlace(int x, int y) {
        return this.glace[x][y];
    }


    /**
     * Getter emplacementCaisse
     * @return emplacementCaisse
     */
    public EmplacementsCaisse getEmplacementsCaisse() {
        return emplacementsCaisse;
    }
}
