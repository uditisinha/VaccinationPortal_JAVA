# VaccinationPortal_JAVA

Welcome to the vaccination booking portal, specifically designed for the employees of an organization. This system enables you to easily book your vaccination appointments. This is a simple system created using JAVA, Swing and uses Excel sheet for storing data.

<h2>The key features are:</h2>    
<ul>
  <li><strong>Adding Employees:</strong> Employees can be added to the Excel sheet and only these employees can log in and book vaccination appointments.</li>
  <li><strong>Login:</strong> Employees can log in after providing their ID number and password.</li>
  <li><strong>Book Vaccination:</strong> Users can book their first or second dose after choosing which vaccine they wish to receive (if this is their first dose).</li>
</ul>

<h2>Details:</h2>
<h3>class Employee:</h3>
This class is used to represent an employee. It contains an empty default constructor and a parametrized constructor in which all the required fields of an employee are declared, for example: ID, name, password, etc.

<h3>class GUI:</h3>
This class contains all the necessary methods and logic for the user interface. It contains the following methods:
login(): This method contains the logic of log in of employee. It uses variables of JFrame, JPanel, JTextField, JLabel and JButton classes. After user has put input for the user_ID field, password field and clicked on the login button, a listening ac1 is set up using 'login_button.addActionListener(ac1)' and the code inside the action listener is executed. Since the ActionEvent e is 'login_button', the input that user put is passed to the Auth() method of class excel, which returns the user object of class Employee which is then stored in the variable user. If user is not null, then their vaccination status is checked and the next method is called accordingly.
