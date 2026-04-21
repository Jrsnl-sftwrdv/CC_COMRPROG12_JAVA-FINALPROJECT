    import javax.swing.*;
    import java.awt.*;

    public class MainSwing {

        public static void main(String[] args) {

            EnrollmentSystem system = new EnrollmentSystem();

            // sample data
            Section sec1 = new Section(101, "1A", "Programming 1", "MON 9-11", 2);
            system.addSection(sec1);

            JFrame frame = new JFrame("Enrollment System");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(5, 1));

            JTextField nameField = new JTextField();
            JTextField sectionField = new JTextField();

            JButton enrollButton = new JButton("Enroll");

            JLabel output = new JLabel("Status: ");

            frame.add(new JLabel("Student Name:"));
            frame.add(nameField);

            frame.add(new JLabel("Section:"));
            frame.add(sectionField);

            frame.add(enrollButton);
            frame.add(output);

            enrollButton.addActionListener(e -> {

                String name = nameField.getText();
                String sectionInput = sectionField.getText();

                if (name.isEmpty() || sectionInput.isEmpty()) {
                    output.setText("Fill all fields!");
                    return;
                }

                Section section = system.findSection(sectionInput);

                if (section == null) {
                    output.setText("Section not found!");
                    return;
                }

                Student student = new Student(name, system.getNextId(), sectionInput);
                system.addStudent(student);

                system.enrollStudent(student, section);

                output.setText("Enrolled: " + name);
            });

            frame.setVisible(true);
        }
    }