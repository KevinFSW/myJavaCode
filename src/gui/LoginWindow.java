package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow {
    public static final int TITLE_HEIGHT = 40;
    JFrame mainFrame = new JFrame("登录或注册");
    JPanel jPanel = new JPanel();
    JLabel lableTitle = new JLabel("考试系统");
    JLabel labelUser = new JLabel("账号：");
    JTextField textFieldUser = new JTextField();
    JLabel labelPasswd = new JLabel("密码：");
    JPasswordField passwordField = new JPasswordField();
    JLabel labelPasswdConfirm = new JLabel("确认密码：");
    JPasswordField passwordConfirmField = new JPasswordField();
    JButton buttonLogin = new JButton("登录");
    JButton buttonAdd = new JButton("注册");

    private abstract class ButtonAction{
        public abstract void buttonActionDeal();
    }

    private void buttonAddActionListener(JButton button, ButtonAction buttonAction) {
        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                buttonAction.buttonActionDeal();
            }
            
        };

        button.addActionListener(actionListener);
    }

    public LoginWindow(int x, int y, int width, int height){
        mainFrame.setLayout(null);
        mainFrame.setBounds(x, y, width, height);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jPanel.setLayout(null);
        x = mainFrame.getWidth()/50;
        y = mainFrame.getHeight()/50;
        width = width - 2*mainFrame.getWidth()/50;
        height = height - 2*mainFrame.getHeight()/50;
        jPanel.setBounds(0, 0, width, height);

        width = jPanel.getWidth()/2;
        height = 40;
        x = (jPanel.getWidth() - width)/2;
        y = jPanel.getHeight()/50;
        lableTitle.setBounds(x, y, width, height);
        lableTitle.setFont(new Font("黑体", Font.BOLD, 20));
        lableTitle.setHorizontalAlignment(JLabel.CENTER);

        x = 3*jPanel.getWidth()/50;
        y = lableTitle.getY() + lableTitle.getHeight() + jPanel.getHeight()/50;
        width = 50;
        height = 30;
        labelUser.setBounds(x, y, width, height);
        labelUser.setFont(new Font("黑体", Font.BOLD, 15));
        
        x = labelUser.getX() + labelUser.getWidth();
        y = labelUser.getY();
        width = jPanel.getWidth() - x - 3*jPanel.getWidth()/50;
        height = labelUser.getHeight();
        textFieldUser.setBounds(x, y, width, height);

        x = 3*jPanel.getWidth()/50;
        y = labelUser.getY() + labelUser.getHeight() + jPanel.getHeight()/50;
        width = 50;
        height = 30;
        labelPasswd.setBounds(x, y, width, height);
        labelPasswd.setFont(new Font("黑体", Font.BOLD, 15));

        x = labelPasswd.getX() + labelPasswd.getWidth();
        y = labelPasswd.getY();
        width = jPanel.getWidth() - x - 3*jPanel.getWidth()/50;
        height = labelPasswd.getHeight();
        passwordField.setBounds(x, y, width, height);

        x = 3*jPanel.getWidth()/50;
        y = labelPasswd.getY() + labelPasswd.getHeight() + jPanel.getHeight()/50;
        width = 80;
        height = 30;
        labelPasswdConfirm.setBounds(x, y, width, height);
        labelPasswdConfirm.setFont(new Font("黑体", Font.BOLD, 15));
        labelPasswdConfirm.setVisible(false);

        x = labelPasswdConfirm.getX() + labelPasswdConfirm.getWidth();
        y = labelPasswdConfirm.getY();
        width = jPanel.getWidth() - x - 3*jPanel.getWidth()/50;
        height = labelPasswdConfirm.getHeight();
        passwordConfirmField.setBounds(x, y, width, height);
        passwordConfirmField.setVisible(false);

        width = 80;
        height = 30;
        x = (jPanel.getWidth() - 2*width - jPanel.getWidth()/50)/2;
        y = jPanel.getHeight() - height - TITLE_HEIGHT;
        buttonLogin.setBounds(x, y, width, height);
        buttonAddActionListener(buttonLogin, new ButtonAction(){

            @Override
            public void buttonActionDeal() {
                // TODO Auto-generated method stub
                LoginWindow.this.labelPasswdConfirm.setVisible(false);
                LoginWindow.this.passwordConfirmField.setVisible(false);

                String user = LoginWindow.this.textFieldUser.getText();
                String passwd = new String(LoginWindow.this.passwordField.getPassword());
                JOptionPane.showMessageDialog(LoginWindow.this.mainFrame, user+"-"+passwd);
            }
            
        });

        width = 80;
        height = 30;
        x = buttonLogin.getX() + buttonLogin.getWidth() + jPanel.getWidth()/50;
        y = jPanel.getHeight() - height - TITLE_HEIGHT;
        buttonAdd.setBounds(x, y, width, height);
        buttonAddActionListener(buttonAdd, new ButtonAction(){

            @Override
            public void buttonActionDeal() {
                // TODO Auto-generated method stub
                LoginWindow.this.labelPasswdConfirm.setVisible(true);
                LoginWindow.this.passwordConfirmField.setVisible(true);
            }
            
        });

        jPanel.add(lableTitle);
        jPanel.add(labelUser);
        jPanel.add(textFieldUser);
        jPanel.add(labelPasswd);
        jPanel.add(passwordField);
        jPanel.add(labelPasswdConfirm);
        jPanel.add(passwordConfirmField);
        jPanel.add(buttonLogin);
        jPanel.add(buttonAdd);
        mainFrame.add(jPanel);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
    }

}