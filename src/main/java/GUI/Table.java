package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.RaumverwaltungsController;

public class Table extends JFrame {
	
	public Table(JTable table) {

    JScrollPane scrollPane = new JScrollPane(table);
    table.setFillsViewportHeight(true);
    add(table.getTableHeader());
    add(table);
    
    
    
}

}
