package gameLaby.laby.utils;


import javafx.scene.image.Image;

/**
 * classse Sprite qui permet d initialiser les images utilisees dans le labyrinthe
 */
public class Sprite {
  /**
   * Sprite de mur
   */
  public static Image MUR = new Image("file:resources/mur.png", 60, 60, false, false);

  /**
   * Sprite de caisse
   */
  public static Image CAISSE = new Image("file:resources/crate.png", 50, 50, false, false);

  /**
   * Sprite de la glace
   */
  public static Image GLACE = new Image("file:resources/glace.png", 60, 60, false, false);

  /**
   * Sprite du personnage
   */
  public static Image PERSO = new Image("file:resources/personnage.png", 60, 60, true, false);

  /**
   * Sprite de la sortie
   */
  public static Image SORTIE = new Image("file:resources/sortie.png", 55, 55, false, false);

  /**
   * Sprite de l'escalier
   */
  public static Image ESCALIER = new Image("file:resources/escalier.png", 60, 60, false, false);
}
