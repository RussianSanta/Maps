import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {
    private File file;
    private JLabel label;
    private Image image;
    int panelSize = 600;

    public ImagePanel() {
        setBounds(20,40,panelSize,panelSize);
        label = new JLabel("Здесь будет ваше изображение");

        add(label);
        setVisible(true);
    }

    public void setImage(File file) {
        this.file = file;
        image = new ImageIcon(file.getPath()).getImage();
        double height = image.getHeight(this);
        double width = image.getWidth(this);
        System.out.println("h-" + height + "/// w-" + width);
        System.out.println(width/height);


        if (height > width) {
            width = (width/height)*panelSize;
            height = panelSize;
        } else {
            height = (height/width)*panelSize;
            width = panelSize;
        }

        System.out.println("h-" + height + "/// w-" + width);

        Graphics g = getGraphics();
        g.clearRect(0,0,panelSize,panelSize);
        g.drawImage(image, (int) ((panelSize-width)/2),(int) ((panelSize-height)/2), (int)width, (int)height,null);
    }
}
