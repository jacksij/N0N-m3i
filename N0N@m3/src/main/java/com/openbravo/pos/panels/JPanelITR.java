//    Chromis POS  - The New Face of Open Source POS
//    Copyright (c) (c) 2015-2016
//    http://www.chromis.co.uk
//
//    This file is part of Chromis POS
//
//     Chromis POS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Chromis POS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Chromis POS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.panels;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.Session;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.AppUser;
import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.forms.BeanFactoryApp;
import com.openbravo.pos.forms.BeanFactoryException;
import com.openbravo.pos.forms.DataLogicSystem;
import com.openbravo.pos.forms.JPanelView;
import com.openbravo.pos.printer.TicketParser;




/**
 *
 * @author adrianromero
 */
public class JPanelITR extends JPanel implements JPanelView, BeanFactoryApp {
    
    private AppView m_App;
    private DataLogicSystem m_dlSystem;    
    private PaymentsModel m_PaymentsToClose = null;      
    private TicketParser m_TTP;
    private final DateFormat df= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");       
    private Session s;
    private Connection con;  
    private Statement stmt;
    private Integer result;
    private String SQL;
    private ResultSet rs;
    
    private AppUser m_User;
    
    /** Creates new form JPanelCloseMoney */
    public JPanelITR() {
        
        initComponents();                   
    }
    
    /**
     *
     * @param app
     * @throws BeanFactoryException
     */
    @Override
    public void init(AppView app) throws BeanFactoryException {
        
        m_App = app;        
        m_dlSystem = (DataLogicSystem) m_App.getBean("com.openbravo.pos.forms.DataLogicSystem");        
    }
    
    /**
     *
     * @return
     */
    @Override
    public Object getBean() {
        return this;
    }
    
    /**
     *
     * @return
     */
    @Override
    public JComponent getComponent() {
        return this;
    }

    /**
     *
     * @return
     */
    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.ITR");
    }

    /**
     *
     * @throws BasicException
     */
    @Override
    public void activate() throws BasicException {
       
    }

    /**
     *
     * @return
     */
    @Override
    public boolean deactivate() {
        // se me debe permitir cancelar el deactivate   
        return true;
    }  
    
   

   
    private void initComponents() {

      
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
       
        jPanel1.setLayout(new java.awt.BorderLayout());
        
        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/ok.png"))); // NOI18N
        jButton1.setText(AppLocal.getIntString("Button.Itr")); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("pos_messages"); // NOI18N
        jButton1.setToolTipText(bundle.getString("button.executereport")); // NOI18N
        jPanel1.add(jButton1);
        
        
        jPanel2  = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
       
        jPanel2.setLayout(new java.awt.BorderLayout());
        
        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/ok.png"))); // NOI18N
        jButton2.setText(AppLocal.getIntString("Button.Itr2")); // NOI18N
        jButton2.setToolTipText(bundle.getString("button.executereport")); // NOI18N
        jPanel2.add(jButton2);
        
        
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
       
        jPanel3.setLayout(new java.awt.BorderLayout());
        
        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/ok.png"))); // NOI18N
        jButton3.setText(AppLocal.getIntString("Button.Itr1")); // NOI18N
        
        jButton3.setToolTipText(bundle.getString("button.executereport")); // NOI18N
        jPanel3.add(jButton3);
        
        
        
        add(jPanel1, java.awt.BorderLayout.SOUTH);
        add(jPanel2, java.awt.BorderLayout.CENTER);
        add(jPanel3, java.awt.BorderLayout.NORTH);
        
        
        
        
    }// </editor-fold>//GEN-END:initComponents

    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jButton1;
    
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jButton2;
    
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jButton3;
}
