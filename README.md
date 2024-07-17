# VaccinationPortal_JAVA

Welcome to the vaccination booking portal, specifically designed for the employees of an organization. This system enables you to easily book your vaccination appointments. This is a simple system created using JAVA, Swing and uses Excel sheet for storing data.

<h2>The key features are:</h2>    
<ul>
  <li><strong>Adding Employees:</strong> Employees can be added to the Excel sheet and only these employees can log in and book vaccination appointments.</li>
  <li><strong>Login:</strong> Employees can log in after providing their ID number and password.</li>
  <li><strong>Book Vaccination:</strong> Users can book their first or second dose after choosing which vaccine they wish to receive (if this is their first dose).</li>
</ul>

<h2>Details:</h2>
class Employee:
This class is used to represent an employee. It contains an empty default constructor and a parametrized constructor in which all the required fields of an employee are declared, for example: ID, name, password, etc.

<h2>Employee Class</h2>
<p>This class is used to represent an employee. It contains an empty default constructor and a parametrized constructor in which all the required fields of an employee are declared, for example: ID, name, password, etc.</p>
    
<h2>GUI Class</h2>
<p>This class contains all the necessary methods and logic for the user interface. It includes the following methods:</p>
<ul>
  <li><strong>login():</strong> This method contains the logic for employee login. It uses variables from JFrame, JPanel, JTextField, JLabel, and JButton classes. After the user inputs their ID and password and clicks the login button, an ActionListener (`ac1`) is set up using `login_button.addActionListener(ac1)`. The code inside the action listener checks the ActionEvent (`e`). If it's from the login button, the input is passed to the `Auth()` method of the `Excel` class, which returns an `Employee` object stored in the variable `user`. If `user` is not null, their vaccination status is checked, and after the current frame is disposed, the next method is called accordingly. If the ActionEvent (`e`) is from the reset button, the input fields are cleared. If `e` is from the add new employee button (`add_new_e`), the frame is disposed, and the `add_new_emp()` method is called. </li></ul>
