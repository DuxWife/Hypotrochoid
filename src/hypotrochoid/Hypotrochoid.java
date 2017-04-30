package hypotrochoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Hypotrochoid extends javax.swing.JFrame {
 public ActionListener task = new ActionListener() {
       @Override
       public void actionPerformed (ActionEvent evt) {
           draw(g);
       } 
    };
   private Timer timer = new Timer (1000, task);
    public Hypotrochoid() {
        super("Гипотрохоида R=1, r=1/3, h=1");
        initComponents();        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(700, 600));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private Graphics g;
int R1 = 1;
double r = 1./3;
int h = 1;
double t = 0;
double dt = 0.001;
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        g=jPanel1.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
        //координатная сетка
        g.setColor(Color.LIGHT_GRAY);        
        for (int i=1;i<=7;i++) {
            g.drawLine(i*100-50, 0, i*100-50, 600);
            g.drawLine(0, i*100, 700, i*100);
        }
        g.setColor(Color.BLACK);
        //ось х и стрелки
        g.drawLine(0, 300, 700, 300);
        g.drawLine(690, 295, 700, 300);
        g.drawLine(690, 305, 700, 300);
        //ось у и стрелки
        g.drawLine(350, 0, 350, 600);
        g.drawLine(350, 0, 345, 10);
        g.drawLine(350, 0, 355, 10);
        
        timer.setDelay(0);
        timer.start();
        
    }//GEN-LAST:event_formWindowOpened

    private void draw(Graphics g) {
        g=jPanel1.getGraphics();
        g.setColor(Color.RED);
        double x = (R1-r)*Math.cos(r/R1*t)+h*Math.cos(t-r/R1*t);
        double y = (R1-r)*Math.sin(r/R1*t)-h*Math.sin(t-r/R1*t);
        g.fillOval((int) Math.round(350+x*100), (int) Math.round(300-y*100), 2, 2);
        t = t+dt;
        if (t>6.5*Math.PI) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
            //координатная сетка
            g.setColor(Color.LIGHT_GRAY);
            for (int i=1;i<=7;i++) {
                g.drawLine(i*100-50, 0, i*100-50, 600);
                g.drawLine(0, i*100, 700, i*100);       
            }
            g.setColor(Color.BLACK);
            //ось х и стрелки
            g.drawLine(0, 300, 700, 300);
            g.drawLine(690, 295, 700, 300);
            g.drawLine(690, 305, 700, 300);
            //ось у и стрелки
            g.drawLine(350, 0, 350, 600);
            g.drawLine(350, 0, 345, 10);
            g.drawLine(350, 0, 355, 10);
            t=0;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Hypotrochoid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hypotrochoid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hypotrochoid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hypotrochoid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hypotrochoid().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void PutPixel(Graphics graphics, long round, long round0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
