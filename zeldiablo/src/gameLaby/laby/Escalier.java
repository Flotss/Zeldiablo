package gameLaby.laby;

public class Escalier {
    /**
     * position en x et y de l escalier
     */
    private int x, y;
    /**
     * boolean qui indique si l escalier est affiche ou non
     */
    private boolean affiche;

    /**
     * constructeur de la classe escalier qui initialise sa position
     * et indique que l escalier n est pas affiche
     * @param x position en x de l'escalier
     * @param y position en y de l'escalier
     */
    public Escalier(int x, int y) {
        this.x = x;
        this.y = y;
        this.affiche = false;
    }

    /**
     * Methode qui verifie si l'escalier est sur les coordonnees
     *
     * @param x coordonnee en x
     * @param y coordonnee en y
     * @return true si l'escalier est sur les coordonnees
     */
    public boolean etrePresent(int x, int y) {
        return this.x == x && this.y == y;
    }

    /**
     * Methode qui affiche l escalier
     */
    public void afficherEscalier() {
        this.affiche = true;
    }

    /**
     * Methode qui cache l escalier
     */
    public void cacherEscalier() {
        this.affiche = false;
    }

    /**
     * Methode qui verifie si l escalier est affiche
     *
     * @return true si l escalier est affiche
     */
    public boolean etreAffiche() {
        return this.affiche;
    }

    /**
     * retourne la coordonnee x
     *
     * @return
     */
    public int getX() {
        return this.x;
    }

    /**
     * retourne la coordonnee y
     *
     * @return
     */
    public int getY() {
        return this.y;
    }


}
