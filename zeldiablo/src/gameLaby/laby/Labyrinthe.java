package gameLaby.laby;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * classe labyrinthe. represente un labyrinthe avec
 * <ul> des murs </ul>
 * <ul> un personnage (x,y) </ul>
 * <ul> des caisses </ul>
 * <ul> des arrivés </ul>
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
    public static final char GLACEE = 'G';
    public static final char ESCALIER = 'E';

    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";

    /**
     * array list de tous les fichier
     */
    private ArrayList<String> nomFichiers;

    /**
     * attribut du personnage
     */
    private Perso pj;

    /**
     * les murs du labyrinthe
     */
    private boolean[][] murs;

    /**
     * les caisses du labyrinthe
     */
    private Caisses caisses;

    /**
     * les emplacements pour les caisses du labyrinthe
     */
    private EmplacementsCaisse emplacementsCaisse;


    /**
     * les cases glacée du labyrinthe
     */
    private Glace glace;

    /**
     * L'escalier de l'etage
     */
    private Escalier escalier;

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
     * @param noms nom du fichier de labyrinthe
     * @throws IOException probleme a la lecture / ouverture
     */
    public Labyrinthe(ArrayList<String> noms) throws IOException {
        this.nomFichiers = noms;
        this.chargerNouveauLabyrinthe();
    }

    /**
     * charge un nouveau labyrinthe
     *
     * @throws IOException probleme a la lecture / ouverture
     */
    public void chargerNouveauLabyrinthe() throws IOException {
        String nom = this.nomFichiers.get(0);
        this.nomFichiers.remove(0);
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
        this.glace = new Glace(nbColonnes, nbLignes);
        this.emplacementsCaisse = new EmplacementsCaisse(nbColonnes, nbLignes);
        this.escalier = null;

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
                        break;
                    case GLACEE:
                        this.glace.ajouter(colonne, numeroLigne);
                        break;
                    case ESCALIER:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute escalier
                        this.escalier = new Escalier(colonne, numeroLigne);
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
    public void deplacerPerso(String action) throws IOException {
        //On repete le deplacement tant que la case sur laquelle le personnage se deplace est glacee (et non bloquée)
        boolean caseGlacee;
        do {
            // case courante
            int[] courante = {this.pj.x, this.pj.y};
            // calcule case suivante
            int[] suivante = getSuivant(courante[0], courante[1], action);
            caseGlacee = this.glace.etrePresent(suivante[0], suivante[1]);

            if (this.caisses.etrePresent(suivante[0], suivante[1])) {
                if (caseGlacee) {
                    //Si la case derriere la caisse est bloquée, on ne pourra pas pousser plus la caisse donc on ne glissera plus
                    caseGlacee = caseDisponible(getSuivant(suivante[0], suivante[1], action)[0], getSuivant(suivante[0], suivante[1], action)[1]);
                }
                // on a une caisse
                deplacerCaisse(suivante[0], suivante[1], action);
            }
            // si c'est pas un mur, on effectue le deplacement
            if (!this.murs[suivante[0]][suivante[1]] && !caisses.etrePresent(suivante[0], suivante[1])) {
                // on met a jour personnage
                this.pj.x = suivante[0];
                this.pj.y = suivante[1];
                // s il y a un escalier, si l escalier est affiche et si le perso est sur l escalier
                if (escalier != null) {
                    if (escalier.etreAffiche()) {
                        if (escalier.etrePresent(this.pj.getX(), this.pj.getY())) {
                            //On charge le laby suivant
                            this.chargerNouveauLabyrinthe();
                            caseGlacee = false;
                        }
                    }
                }
            }
        } while (caseGlacee);
        //s il y a un escalier
        if (escalier != null) {
            //Si le laby est fini on definit l affichage de l escalier
            if (this.emplacementsCaisse.etreFini(this.caisses)) {
                this.escalier.afficherEscalier();
            } else {
                this.escalier.cacherEscalier();
            }
        }
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
        int[] precedente = {x, y};
        boolean caseGlacee;
        do {
            // calcule case suivante
            caseGlacee = false;

            // si c'est pas un mur, on effectue le deplacement
            if (caseDisponible(suivante[0], suivante[1])) {
                caseGlacee = this.glace.etrePresent(suivante[0], suivante[1]);
                // on met a jour la caisse
                this.caisses.deplacer(precedente[0], precedente[1], suivante[0], suivante[1]);
            }
            precedente = suivante;
            suivante = getSuivant(suivante[0], suivante[1], direction);
        } while (caseGlacee);
    }

    /**
     * Propulser la caisse en fonction de la direction.
     *
     * @param direction Direction du personnage
     */
    public void propulserCaisse(String direction) {

        // case courante
        int[] courante = {this.pj.x, this.pj.y};
        // calcule case suivante
        int[] precedente = getSuivant(courante[0], courante[1], direction);
        int[] suivante = getSuivant(precedente[0], precedente[1], direction);


        if (this.caisses.etrePresent(precedente[0], precedente[1])) {
            // si c'est pas un mur, on effectue le deplacement
            while (caseDisponible(suivante[0], suivante[1])) {
                // on met a jour la caisse
                this.caisses.deplacer(precedente[0], precedente[1], suivante[0], suivante[1]);
                // calcule case suivante
                precedente = suivante;
                suivante = getSuivant(suivante[0], suivante[1], direction);
            }
        }
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
        return !this.murs[x][y] && !this.caisses.etrePresent(x, y);
    }


    /**
     * Methode qui renvoie si le jeu est fini
     *
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
     *
     * @param x Coordonnee x
     * @param y Coordonnee y
     * @return true si la case est une caisse
     */
    public boolean getCaisse(int x, int y) {
        return this.caisses.getPos()[x][y];
    }

    /**
     * Getter glace de la position (x,y)
     *
     * @param x Coordonnee x
     * @param y Coordonnee y
     * @return true si la case est glacee
     */
    public boolean getGlace(int x, int y) {
        return this.glace.etrePresent(x, y);
    }


    /**
     * Getter emplacementCaisse
     *
     * @return emplacementCaisse
     */
    public EmplacementsCaisse getEmplacementsCaisse() {
        return emplacementsCaisse;
    }

    /**
     * Getter personnage
     *
     * @return Perso
     */
    public Perso getPj() {
        return pj;
    }

    /**
     * Getter Escalier
     *
     * @return Escalier
     */
    public Escalier getEscalier() {
        return escalier;
    }

    /**
     * Getter des murs
     *
     * @return Les murs du labyrinthe
     */
    public boolean[][] getMurs() {
        return murs;
    }

    /**
     * Getter de l'escalier
     *
     * @return Si l'escalier est affiche
     */
    public boolean getEscalierAfficher() {
        return (escalier.etreAffiche());
    }
}
