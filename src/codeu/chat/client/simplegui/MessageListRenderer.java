package codeu.chat.client.simplegui;

import javax.swing.*;
import java.awt.*;

public class MessageListRenderer extends DefaultListCellRenderer {

  @Override
  public Component getListCellRendererComponent(
      JList list, Object value, int index,
      boolean isSelected, boolean cellHasFocus) {

    JLabel label = (JLabel) value;
    return label;
  }
}