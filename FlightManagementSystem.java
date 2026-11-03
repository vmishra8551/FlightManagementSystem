import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class FlightManagementSystem extends JFrame {
    private HashMap<Integer, String> reservations = new HashMap<>();
    private JTextArea displayArea;

    public FlightManagementSystem() {
        // Set up the frame
        setTitle("Flight Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Set Background Color for Frame
        getContentPane().setBackground(new Color(230, 230, 250));  // Lavender color

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(72, 61, 139));  // Dark Slate Blue
        JLabel headerLabel = new JLabel("Flight Management System");
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Button Panel with GridLayout
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.setBackground(new Color(230, 230, 250));  // Match the frame's background

        JButton bookButton = createStyledButton("Book Flight");
        JButton cancelButton = createStyledButton("Cancel Booking");
        JButton manageButton = createStyledButton("View All Reservations");
        JButton viewSpecificButton = createStyledButton("View Specific Reservation");
        JButton clearButton = createStyledButton("Clear Display");

        // Add buttons to the panel
        buttonPanel.add(bookButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(manageButton);
        buttonPanel.add(viewSpecificButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.WEST);

        // Display Area
        displayArea = new JTextArea(15, 40);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        displayArea.setEditable(false);
        displayArea.setBackground(Color.WHITE);
        displayArea.setBorder(BorderFactory.createLineBorder(new Color(72, 61, 139), 2));
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);

        // Button Actions
        bookButton.addActionListener(e -> bookFlight());
        cancelButton.addActionListener(e -> cancelBooking());
        manageButton.addActionListener(e -> manageReservations());
        viewSpecificButton.addActionListener(e -> viewSpecificReservation());
        clearButton.addActionListener(e -> clearDisplay());
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));  // Larger font
        button.setBackground(new Color(135, 206, 235));  // Light Sky Blue
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(200, 50));  // Set a consistent size
        return button;
    }

    private void bookFlight() {
        String passengerName = JOptionPane.showInputDialog(this, "Enter Passenger Name:");
        if (passengerName != null && !passengerName.trim().isEmpty()) {
            int ticketNumber = reservations.size() + 1;
            reservations.put(ticketNumber, passengerName);
            displayArea.append("Booking Successful! Ticket Number: " + ticketNumber + " | Passenger: " + passengerName + "\n");
            JOptionPane.showMessageDialog(this, "Booking Successful!\nTicket Number: " + ticketNumber, "Booking Confirmation", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Booking Cancelled: Name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelBooking() {
        String ticketStr = JOptionPane.showInputDialog(this, "Enter Ticket Number to Cancel:");
        try {
            int ticketNumber = Integer.parseInt(ticketStr);
            if (reservations.containsKey(ticketNumber)) {
                String passengerName = reservations.remove(ticketNumber);
                displayArea.append("Booking Cancelled for Ticket Number: " + ticketNumber + " | Passenger: " + passengerName + "\n");
                JOptionPane.showMessageDialog(this, "Booking Cancelled for Ticket Number: " + ticketNumber, "Cancellation Confirmation", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Ticket Number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a numeric Ticket Number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void manageReservations() {
        if (reservations.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No Reservations Available.", "Information", JOptionPane.INFORMATION_MESSAGE);
            displayArea.append("No Reservations Available.\n");
        } else {
            StringBuilder sb = new StringBuilder("Current Reservations:\n");
            reservations.forEach((ticketNumber, passengerName) -> {
                sb.append("Ticket Number: ").append(ticketNumber).append(" | Passenger: ").append(passengerName).append("\n");
            });
            displayArea.append(sb.toString());
            JOptionPane.showMessageDialog(this, sb.toString(), "Reservations", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void viewSpecificReservation() {
        String ticketStr = JOptionPane.showInputDialog(this, "Enter Ticket Number to View:");
        try {
            int ticketNumber = Integer.parseInt(ticketStr);
            if (reservations.containsKey(ticketNumber)) {
                String passengerName = reservations.get(ticketNumber);
                JOptionPane.showMessageDialog(this, "Ticket Number: " + ticketNumber + "\nPassenger: " + passengerName, "Reservation Details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No reservation found for Ticket Number: " + ticketNumber, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a numeric Ticket Number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearDisplay() {
        displayArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FlightManagementSystem app = new FlightManagementSystem();
            app.setVisible(true);
        });
    }
}




