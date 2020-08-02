package client.configs;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ImageLoader {
    private static ImageLoader imageLoader;
    private GUIConfigLoader guiConfigLoader = new GUIConfigLoader("directories");

    private ImageLoader() {
        cardImages=new HashMap<>();
        minionImages=new HashMap<>();
        heroImages=new HashMap<>();
        weaponImages=new HashMap<>();
        powerImages=new HashMap<>();
        backGroundImages=new HashMap<>();
        loadHashMaps();
    }

    public static ImageLoader getInstance() {
        if (imageLoader == null)
            imageLoader = new ImageLoader();
        return imageLoader;
    }

    private HashMap<String, BufferedImage> cardImages, minionImages, heroImages, weaponImages, powerImages, backGroundImages;

    private void loadHashMaps() {
        loadImages(guiConfigLoader.getString("backgroundImages_path"), backGroundImages);
        loadImages(guiConfigLoader.getString("minionImages_path"), minionImages);
        loadImages(guiConfigLoader.getString("weaponImages_path"), weaponImages);
        loadImages(guiConfigLoader.getString("heroImages_path"), heroImages);
        loadImages(guiConfigLoader.getString("heroPowerImages_path"), powerImages);
        loadImages(guiConfigLoader.getString("cardImages_path"), cardImages);
    }

    private void loadImages(String directory, HashMap imageMap) {
        File file = new File(directory);
        for (File image : file.listFiles()) {
            try {
                BufferedImage fileImage = ImageIO.read(image);
                imageMap.put(image.getName(), fileImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public BufferedImage getCardImage(String name) {
        return cardImages.get(name + ".png");
    }

    public BufferedImage getMinionImage(String name) {
        return minionImages.get(name + ".png");
    }

    public BufferedImage getHeroImage(String name) {
        return heroImages.get(name + ".png");
    }

    public BufferedImage getWeaponImage(String name) {
        return weaponImages.get(name + ".png");
    }

    public BufferedImage getPowerImage(String name ) {
        return powerImages.get(name + ".png");
    }
    public BufferedImage getBackgroundImage(String name){
        return backGroundImages.get(name + ".jpg");
    }
}
