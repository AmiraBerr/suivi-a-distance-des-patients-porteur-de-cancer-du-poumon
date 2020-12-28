/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package public_var;

import Espace_Admin.Admin_accueil1;
import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author pc
 */
public class fonctions {

    
    
     public static void HeureSystem( JLabel Hlabel) {
   
        Thread clock;
        clock = new Thread() {
            public void run() {
                for (;;) {
                    Calendar Cal = new GregorianCalendar();

                    int sconde = Cal.get(Calendar.SECOND);
                    int minute = Cal.get(Calendar.MINUTE);
                    int heure = Cal.get(Calendar.HOUR);
                    int AM_PM = Cal.get(Calendar.AM_PM);  
                    String pa;
                    if(AM_PM==1){
                        pa="PM";
                    }else{
                        pa="AM";
                    }
                    
                    
                   Hlabel.setText( + heure + ":" + (minute) + ":" + sconde +" "+pa  );
                }

            }

        };
    clock.start();
    }
    
     
     
     
     public static void HeureSystemsec( JTextField Htext) {
   
        Thread clock;
        clock = new Thread() {
            public void run() {
                for (;;) {
                    Calendar Cal = new GregorianCalendar();

                    int sconde = Cal.get(Calendar.SECOND);
                    int minute = Cal.get(Calendar.MINUTE);
                    int heure = Cal.get(Calendar.HOUR);
                    int AM_PM = Cal.get(Calendar.AM_PM);  
                    String pa;
                    if(AM_PM==1){
                        pa="PM";
                    }else{
                        pa="AM";
                    }
                    
                    
                   Htext.setText( + heure + ":" + (minute) + ":00 "+pa  );
                }

            }

        };
    clock.start();
    }
    
     
      public  static void DateSystem(JTextField Dtext) {
        Thread clock = new Thread() {
            public void run() {
                for (;;) {
                 Calendar Cal = new GregorianCalendar();

                    
                    
                 int mois = Cal.get(Calendar.MONTH);
                    int annee = Cal.get(Calendar.YEAR);
                    int jour = Cal.get(Calendar.DAY_OF_MONTH);

                    Dtext.setText( + annee + "-" + (mois+1) + "-" + jour);              
                    
                    
                    try {
                        sleep(1000);

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Calendar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        };
        
clock.start();
    }
    
    
}
