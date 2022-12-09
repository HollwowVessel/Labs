import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class MyForm extends JFrame {
    public MyForm() {
        super("Лаба 4, задание 2");
        setBounds(100, 50, 380, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel xLabel = new JLabel("Положение по x:");
        xLabel.setBounds(10, 10, 350, 30);
        add(xLabel);
        JTextField xText = new JTextField();
        xText.setBounds(10, 50, 350, 30);
        add(xText);

        JLabel yLabel = new JLabel("Положение по y:");
        yLabel.setBounds(10, 90, 350, 30);
        add(yLabel);
        JTextField yText = new JTextField();
        yText.setBounds(10, 130, 350,30);
        add(yText);

        JLabel widthLabel = new JLabel("Ширина:");
        widthLabel.setBounds(10, 170, 350, 30);
        add(widthLabel);
        JTextField widthText = new JTextField();
        widthText.setBounds(10, 210, 350, 30);
        add(widthText);

        JLabel lengthLabel = new JLabel("Длина:");
        lengthLabel.setBounds(10, 250, 350, 30);
        add(lengthLabel);
        JTextField lengthText = new JTextField();
        lengthText.setBounds(10, 290, 350,30);
        add(lengthText);

        JLabel layoutLabel = new JLabel("Менеджер размещения компонентов:");
        layoutLabel.setBounds(10, 330, 350, 30);
        add(layoutLabel);
        JTextField layoutText = new JTextField();
        layoutText.setBounds(10, 370, 350, 30);
        add(layoutText);

        JLabel buttonsLabel = new JLabel("Количество кнопок: ");
        buttonsLabel.setBounds(10, 410, 350, 30);
        add(buttonsLabel);
        JTextField buttonsText = new JTextField();
        buttonsText.setBounds(10, 450, 350, 30);
        add(buttonsText);

        JLabel textLabel = new JLabel("Количество текстовых полей: ");
        textLabel.setBounds(10, 490, 350, 30);
        add(textLabel);
        JTextField textText = new JTextField();
        textText.setBounds(10, 530, 350, 30);
        add(textText);

        JButton createButton = new JButton("Создать форму");
        createButton.setBounds(60, 570, 250, 30);

        createButton.addActionListener(
                new CreateButtonHandler(
                        xText,
                        yText,
                        widthText,
                        lengthText,
                        layoutText,
                        buttonsText,
                        textText
                )
        );
        add(createButton);
        validate();
        setVisible(true);
    }
}

class CreatedForm extends JFrame{

    public LayoutManager layoutSet(String layout){
        switch (layout) {
            case "Flow" -> {
                return (new FlowLayout());
            }
            case "Grid" -> {
                return (new GridLayout());
            }
            case "Border" -> {
                return (new BorderLayout());
            }
            case "GridBag" -> {
                return (new GridBagLayout());
            }
            case "CardLayout" -> {
                return (new CardLayout());
            }
            case "Spring" -> {
                return (new SpringLayout());
            }
        }
        return new FlowLayout();

    }
    public CreatedForm(int x, int y, int width, int height, String layout, int buttons, int textField){
        super("Созданная форма");
        setBounds(x,y,width, height);
        setLayout(layoutSet(layout));
        setVisible(true);
        int tempX = 20;
        int tempY = 20;
        for(int i = 0; i < buttons; i++){
            JButton tempButton = new JButton();
            tempButton.setBounds(tempX, tempY, 20, 20);
            tempY += 20;
            add(tempButton);
        }

        for(int i = 0; i < textField; i++){
            JTextField tempField = new JTextField();
            tempField.setBounds(tempX, tempY + 1, 100 , 20);
            tempY += 30;
            add(tempField);
        }
    }
}
class CreateButtonHandler implements ActionListener {
    private JTextField x, y, width, length, layout, buttons, fields;
    public CreateButtonHandler(JTextField f1, JTextField f2, JTextField f3, JTextField f4, JTextField f5,  JTextField f6,  JTextField f7) {
        this.x = f1;
        this.y = f2;
        this.width = f3;
        this.length = f4;
        this.layout = f5;
        this.buttons = f6;
        this.fields = f7;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            int xValue = Integer.parseInt(x.getText());
            int yValue = Integer.parseInt(y.getText());
            int widthValue = Integer.parseInt(width.getText());
            int lengthValue = Integer.parseInt(length.getText());
            String layoutValue = layout.getText();
            int buttonsValue = Integer.parseInt(buttons.getText());
            int fieldsValue = Integer.parseInt(fields.getText());


            new CreatedForm(xValue, yValue, widthValue, lengthValue, layoutValue, buttonsValue, fieldsValue);
        } catch(NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Неверное число");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new MyForm();
    }
}