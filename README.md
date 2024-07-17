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

<h3>Employee Class</h3>
<p>This class is used to represent an employee. It contains an empty default constructor and a parametrized constructor in which all the required fields of an employee are declared, for example: ID, name, password, etc.</p>
    
<h3>GUI Class</h3>
<p>This class contains all the necessary methods and logic for the user interface. It includes the following methods:</p>
<ul>
  <li><strong>login():</strong> This method contains the logic for employee login. It uses variables of JFrame, JPanel, JTextField, JLabel, and JButton classes. After the user inputs their ID and password and clicks the login button, an ActionListener (`ac1`) is set up using `login_button.addActionListener(ac1)`. The code inside the action listener checks the ActionEvent (`e`). If it's from the login button, the input is passed to the `Auth()` method of the `Excel` class, which returns an `Employee` object stored in the variable `user`. If `user` is not null, their vaccination status is checked, and after the current frame is disposed, the next method is called accordingly. If the ActionEvent (`e`) is from the reset button, the input fields are cleared. If `e` is from the add new employee button (`add_new_e`), the frame is disposed, and the `add_new_emp()` method is called. </li>

  <li><strong>no_need_book(Employee user):</strong> This method is called by login() when the user has already booked a vaccination appoointment. A new frame "BOOKING PORTAL" is created and it displays information about the booking using the variables of class JLabel. Depending on which vaccination appointment the user had booked, appropriate text is shown to the user.</li>

  <li><strong>b_portal(Employee user):</strong> This method is called by login() when the user has not booked a vaccination appointment yet using the system. A new frame is created in which there are 2 fields: one asking the type of vaccine they have taken (Covishield/Covaccine/Sputnik) and the other asking the preferred date of booking. After inserting input in this field and clicking submit, it is checked how many vaccine doses the user has taken. If the user has taken no dose yet, they are asked to fill the preferred vaccine type. The booking date and present date are recorded and the difference between them is computed in miliseconds and converted to days. If the number of days is negative, then they user is notified that they have chosen an already passed date, else the user object is passed to the update() method of class excel. If the user has taken a dose already, then apart from checking if the date has passed already, it is also checked how many days are there between the 1st and the 2nd dose. Each vaccine has a maximum and minimum number of days between the 2 doses, therefore, if the duration between the 2 doses for the input date for 2nd dose isn't following the rule for the preferred vaccine type, then the user is notified about it.</li>
</ul>
