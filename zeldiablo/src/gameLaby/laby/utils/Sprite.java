package gameLaby.laby.utils;


import javafx.scene.image.Image;

public class Sprite {
  /**
   * Sprite de mur
   */
  public static Image IMAGE_MUR = new Image("file:resources/mur.png", 60, 60, false, false);

  /**
   * Sprite de caisse
   */
  public static Image IMAGE_CRATE = new Image("file:resources/crate.png", 50, 50, false, false);

  /**
   * Sprite de la glace
   */
  public static Image IMAGE_GLACE = new Image("file:resources/glace.png", 60, 60, false, false);

  /**
   * Sprite du personnage
   */
  public static Image IMAGE_PERSO = new Image("file:resources/personnage.png", 60, 60, true, false);

  /**
   * Sprite de la sortie
   */
  public static Image IMAGE_SORTIE = new Image("file:resources/sortie.png", 60, 60, false, false);

  /**
   * Sprite de l'escalier
   */
  public static Image IMAGE_ESCALIER = new Image("file:resources/escalier.png", 60, 60, false, false);
}
