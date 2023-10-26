package practicals.pr17;

/*Computer Graphics P17: Write a Graphic program for Cohen-Sutherland
 * Line Clipping Algorithm.
 */
import java.awt.*;
import java.awt.event.*;

public class P17Frame extends Frame implements ActionListener {

    Label lblXYCoord, lblWinMin, lblWinMax;
    TextField tfx, tfy, tfxwmn, tfywmn, tfxwmx, tfywmx;
    Button btnDraw, btnClip;
    Panel p;
    P17Canvas can = new P17Canvas();

    public P17Frame() {

        super("Practical:17 Cohen-Sutherland Line Clipping...");

        lblXYCoord = new Label("Co-Ordinate X[0..n] and Y[0..n] : ");
        lblWinMin = new Label("Window Min-points (X,Y) : ");
        lblWinMax = new Label("Window Max-points (X,Y) : ");

        tfx = new TextField(3);
        tfy = new TextField(3);

        tfxwmn = new TextField(3);
        tfywmn = new TextField(3);
        tfxwmx = new TextField(3);
        tfywmx = new TextField(3);

        btnDraw = new Button("Draw Window");
        btnClip = new Button("Clip Line");

        p = new Panel(new GridLayout(4, 3));

        p.add(lblWinMin);
        p.add(tfxwmn);
        p.add(tfywmn);

        p.add(lblWinMax);
        p.add(tfxwmx);
        p.add(tfywmx);

        p.add(lblXYCoord);
        p.add(tfx);
        p.add(tfy);

        p.add(btnDraw);
        p.add(btnClip);

        setSize(600, 600);
        setVisible(true);
        setLayout(new BorderLayout());
        add(can, "Center");
        add(p, "South");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        btnDraw.addActionListener(this);
        btnClip.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String X = tfx.getText();
        String Y = tfy.getText();

        if (ae.getSource() == btnDraw) {
            double xwmn = Double.parseDouble(tfxwmn.getText());
            double ywmn = Double.parseDouble(tfywmn.getText());
            double xwmx = Double.parseDouble(tfxwmx.getText());
            double ywmx = Double.parseDouble(tfywmx.getText());

            can.drawWindow(X, Y, xwmn, ywmn, xwmx, ywmx);
        }

        if (ae.getSource() == btnClip) {

            can.clipLine();
        }
    }
}
