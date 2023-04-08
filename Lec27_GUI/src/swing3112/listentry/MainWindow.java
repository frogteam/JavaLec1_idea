package swing3112.listentry;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

/* 리스트의 아이템 변경
	

 */

// 참조 : http://esus.com/how-do-i-create-a-jlist-with-icons-and-text/
public class MainWindow
{
   public static void main(String args[]) {
      JFrame frame = new JFrame("JList ImageIcon Demonstration");
  
      DefaultListModel dlm = new DefaultListModel();
      dlm.addElement(new ListEntry("Audio\nhello", new ImageIcon("images/icon1.png")));
      dlm.addElement(new ListEntry("Control Panel", new ImageIcon("images/icon2.png")));
      dlm.addElement(new ListEntry("Folder", new ImageIcon("images/icon3.png")));
      dlm.addElement(new ListEntry("Local Disk (C:)", new ImageIcon("images/icon4.png")));
      dlm.addElement(new ListEntry("doc on '192.168.0.1' (Z:)", new ImageIcon("images/apple.jpg")));
  
      JList list = new JList(dlm);
      list.setCellRenderer(new ListEntryCellRenderer());
          
      frame.getContentPane().add(BorderLayout.CENTER, new JScrollPane(list));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
  
class ListEntry
{
   private String value;
   private ImageIcon icon;
  
   public ListEntry(String value, ImageIcon icon) {
      this.value = value;
      this.icon = icon;
   }
  
   public String getValue() {
      return value;
   }
  
   public ImageIcon getIcon() {
      return icon;
   }
  
   public String toString() {
      return value;
   }
}
  
class ListEntryCellRenderer
 extends JLabel implements ListCellRenderer
{
   private JLabel label;
  
   public Component getListCellRendererComponent(JList list, Object value,
                                                 int index, boolean isSelected,
                                                 boolean cellHasFocus) {
      ListEntry entry = (ListEntry) value;
  
      setText(value.toString());
      setIcon(entry.getIcon());
   
      if (isSelected) {
         setBackground(list.getSelectionBackground());
         setForeground(list.getSelectionForeground());
      }
      else {
         setBackground(list.getBackground());
         setForeground(list.getForeground());
      }
  
      setEnabled(list.isEnabled());
      setFont(list.getFont());
      setOpaque(true);
  
      return this;
   }
}