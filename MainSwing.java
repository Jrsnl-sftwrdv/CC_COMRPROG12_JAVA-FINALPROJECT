    import javax.swing.*;
    import javax.swing.border.CompoundBorder;
    import javax.swing.border.EmptyBorder;
    import javax.swing.border.LineBorder;
    import java.awt.*;

    public class MainSwing {

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                applyModernDarkTheme();

                EnrollmentSystem system = new EnrollmentSystem();

                // sample data
                Section sec1 = new Section(101, "1A", "Programming 1", "MON 9-11", 2);
                system.addSection(sec1);
                
                JFrame frame = new JFrame("Enrollment System");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel root = new JPanel();
                root.setBorder(new EmptyBorder(18, 18, 18, 18));
                root.setLayout(new BorderLayout(0, 14));

                JLabel title = new JLabel("Enrollment System");
                title.setFont(new Font("Segoe UI", Font.BOLD, 20));
                title.setForeground(new Color(0xE8E8E8));
                root.add(title, BorderLayout.NORTH);

                JPanel form = new JPanel(new GridBagLayout());
                form.setOpaque(false);

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.insets = new Insets(0, 0, 10, 10);
                gbc.anchor = GridBagConstraints.WEST;
                gbc.fill = GridBagConstraints.NONE;

                JLabel nameLabel = new JLabel("Student Name");
                styleLabel(nameLabel);
                form.add(nameLabel, gbc);

                gbc.gridx = 1;
                gbc.weightx = 1.0;
                gbc.fill = GridBagConstraints.HORIZONTAL;

                JTextField nameField = new JTextField();
                styleTextField(nameField);
                form.add(nameField, gbc);

                gbc.gridx = 0;
                gbc.gridy++;
                gbc.weightx = 0.0;
                gbc.fill = GridBagConstraints.NONE;
                gbc.insets = new Insets(0, 0, 10, 10);

                JLabel sectionLabel = new JLabel("Section");
                styleLabel(sectionLabel);
                form.add(sectionLabel, gbc);

                gbc.gridx = 1;
                gbc.weightx = 1.0;
                gbc.fill = GridBagConstraints.HORIZONTAL;

                JTextField sectionField = new JTextField();
                styleTextField(sectionField);
                form.add(sectionField, gbc);

                root.add(form, BorderLayout.CENTER);

                JPanel bottom = new JPanel(new BorderLayout(0, 10));
                bottom.setOpaque(false);

                JButton enrollButton = new JButton("Enroll");
                stylePrimaryButton(enrollButton);

                JPanel buttonRow = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
                buttonRow.setOpaque(false);
                buttonRow.add(enrollButton);
                bottom.add(buttonRow, BorderLayout.NORTH);

                JLabel output = new JLabel("Status: ");
                output.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                output.setForeground(new Color(0xCFCFCF));
                output.setBorder(new EmptyBorder(8, 10, 8, 10));
                output.setOpaque(true);
                output.setBackground(new Color(0x161A22));
                output.setBorder(new CompoundBorder(
                        new LineBorder(new Color(0x2A3142), 1, true),
                        new EmptyBorder(8, 10, 8, 10)
                ));
                bottom.add(output, BorderLayout.SOUTH);

                root.add(bottom, BorderLayout.SOUTH);

                enrollButton.addActionListener(e -> {
                    String name = nameField.getText().trim();
                    String sectionInput = sectionField.getText().trim();

                    if (name.isEmpty() || sectionInput.isEmpty()) {
                        output.setText("Status: Fill all fields!");
                        return;
                    }

                    Section section = system.findSection(sectionInput);

                    if (section == null) {
                        output.setText("Status: Section not found!");
                        return;
                    }

                    Student student = new Student(name, system.getNextId(), sectionInput);
                    system.addStudent(student);
                    String status = system.tryEnrollStudent(student, section);

                    if ("Enrollment successful!".equals(status)) {
                        output.setText("Status: Enrolled " + name);
                    } else {
                        output.setText("Status: " + status);
                    }
                });

                frame.setContentPane(root);
                frame.setMinimumSize(new Dimension(620, 360)); // widened + a bit taller
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            });
        }

        private static void applyModernDarkTheme() {
            try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception ignored) {
                // If Nimbus isn't available, fall back to default.
            }

            Color bg = new Color(0x0F1116);
            Color surface = new Color(0x121621);
            Color text = new Color(0xE6E6E6);
            Color muted = new Color(0xAEB6C2);

            UIManager.put("control", bg);
            UIManager.put("info", bg);
            UIManager.put("nimbusBase", new Color(0x2A3142));
            UIManager.put("nimbusBlueGrey", new Color(0x1A1F2B));
            UIManager.put("nimbusLightBackground", surface);
            UIManager.put("text", text);

            UIManager.put("Label.foreground", muted);
            UIManager.put("Panel.background", bg);
            UIManager.put("TextField.background", new Color(0x0E1320));
            UIManager.put("TextField.foreground", text);
            UIManager.put("TextField.caretForeground", text);
            UIManager.put("Button.foreground", text);
        }

        private static void styleLabel(JLabel label) {
            label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            label.setForeground(new Color(0xAEB6C2));
        }

        private static void styleTextField(JTextField field) {
            field.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            field.setForeground(new Color(0xE6E6E6));
            field.setCaretColor(new Color(0xE6E6E6));
            field.setBackground(new Color(0x0E1320));
            field.setBorder(new CompoundBorder(
                    new LineBorder(new Color(0x2A3142), 1, true),
                    new EmptyBorder(8, 10, 8, 10)
            ));
            field.setColumns(18);
        }

        private static void stylePrimaryButton(JButton button) {
            button.setFont(new Font("Segoe UI", Font.BOLD, 13));
            button.setFocusPainted(false);
            button.setBackground(new Color(0x2D6AE3));
            button.setForeground(new Color(0xFFFFFF));
            button.setBorder(new CompoundBorder(
                    new LineBorder(new Color(0x244FAE), 1, true),
                    new EmptyBorder(8, 14, 8, 14)
            ));
        }
    }