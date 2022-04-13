import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {
    private final Container container;
    private final JButton loadImageButton;
    private final JFileChooser fileChooser;
    private final ImagePanel imagePanel;

    public MainPage() throws HeadlessException {
        super("MAPS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        container = getContentPane();
        loadImageButton = new JButton("Загрузить");
        fileChooser = new JFileChooser();
        imagePanel = new ImagePanel();

        addFileChooserButtons();
        container.add(loadImageButton);
        container.add(imagePanel);

        setSize(655, 700);
        setLayout(null);
        setVisible(true);
    }

    private void addFileChooserButtons() {
        loadImageButton.addActionListener(e -> {
            fileChooser.setDialogTitle("Выбор директории");
            int result = fileChooser.showOpenDialog(MainPage.this);
            if (result == JFileChooser.APPROVE_OPTION)
                imagePanel.setImage(fileChooser.getSelectedFile());
        });
        loadImageButton.setBounds(275, 10, 100, 20);
    }
}
