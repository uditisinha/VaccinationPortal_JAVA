package vacc_portal;
import java.text.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class Employee{
	int e_id;
	String e_name;
	String e_pass;
	int vacc_status;
	String date1;
	String date2;
	String vacc_type;
	int b_status;
	int r_num;
	Employee()
	{
		
	}
	Employee(int e_id,String e_name,String e_pass,int vacc_status,String date1,String date2,String vacc_type,int b_status,int r_num)
	{
		this.e_id = e_id;
		this.e_name = e_name;
		this.e_pass = e_pass;
		this.vacc_status = vacc_status;
		this.date1 = date1;
		this.date2 = date2;
		this.vacc_type = vacc_type;
		this.b_status = b_status;
		this.r_num = r_num;
	}
}
class GUI {
	static private JFrame frame;
	static private JPanel panel;
	static private JLabel user_id;
	static private JLabel Heading;
	static private JTextField userid_text;
	static private JLabel password;
	static private JPasswordField password_text;
	static private JButton login_button;
	static private JButton reset;
	static private JButton Add_new_e;
	static void login() 
	{
		panel = new JPanel();
		frame = new JFrame("LOGIN PAGE");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        frame.add(panel);
        panel.setLayout(null);
        
        Heading = new JLabel("EMPLOYEE VACCINE BOOKING PORTAL");
        Heading.setFont(new Font("Verdana",Font.BOLD,40));
        Heading.setBounds(350,20,1200,40);
        panel.add(Heading);
        
        user_id = new JLabel("User ID:");
        user_id.setFont(new Font("Verdana",Font.BOLD,20));
        user_id.setBounds(625,300,200,25);
        panel.add(user_id);
        
        userid_text = new JTextField(25);
        userid_text.setFont(new Font("Verdana",Font.PLAIN,20));
        userid_text.setBounds(725,303,200,25);
        panel.add(userid_text);
        
        password = new JLabel("Password :");
        password.setFont(new Font("Verdana",Font.BOLD,20));
        password.setBounds(600,400,200,25);
        panel.add(password);
        
        password_text = new JPasswordField(25);
        password_text.setFont(new Font("Verdana",Font.PLAIN,20));
        password_text.setBounds(725,403,200,25);
        panel.add(password_text);
        
        login_button =  new JButton("Login");
        login_button.setFont(new Font("Verdana",Font.PLAIN,25));
        login_button.setBounds(600,450,140,35);
        
        reset =  new JButton("reset");
        reset.setFont(new Font("Verdana",Font.PLAIN,25));
        reset.setBounds(780,450,140,35);
        
        Add_new_e =  new JButton("Add New Employee");
        Add_new_e.setFont(new Font("Verdana",Font.PLAIN,25));
        Add_new_e.setBounds(600,550,320,35);
        
        
        ActionListener ac1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==login_button)
				{
					int id= Integer.parseInt(userid_text.getText());
					String pass = new String(password_text.getPassword());
					Employee user = new Employee();
					try {
						user = excel.Auth(id,pass);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(user!=null)
					{
						if(user.b_status == 0) {
							frame.dispose();
							b_portal(user);
						}
						else 
						{
							frame.dispose();
							no_need_book(user);
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(frame,"Invalid ID or Password","Error",JOptionPane.ERROR_MESSAGE);
						clear();
					}
				}
				else if(e.getSource()==reset)
				{
					clear();
				}
				else if(e.getSource()==Add_new_e)
				{
					try {
						frame.dispose();
						add_new_emp();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
        };
        login_button.addActionListener(ac1);
        reset.addActionListener(ac1);
        Add_new_e.addActionListener(ac1);
        panel.add(login_button);
        panel.add(reset);
        panel.add(Add_new_e);
        
        frame.setVisible(true);
	}
	static void no_need_book(Employee user)
	{
		JPanel p2 = new JPanel();
		
		JFrame f2 = new JFrame();
		f2= new JFrame("BOOKING PORTAL");
		f2.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.add(p2);
        
        p2.setLayout(null);
        
        JLabel Head_b2 = new JLabel("USER INFORMATION");
        Head_b2.setFont(new Font("Verdana",Font.BOLD,40));
        Head_b2.setBounds(550,10,1200,40);
        p2.add(Head_b2);
        
        JLabel EMP_ID_b2 = new JLabel("USER ID :");
        EMP_ID_b2.setFont(new Font("Verdana",Font.BOLD,20));
        EMP_ID_b2.setBounds(50,100,150,40);
        p2.add(EMP_ID_b2);
        
        JLabel ID_text_b2 = new JLabel(Integer.toString(user.e_id));
        ID_text_b2.setFont(new Font("Verdana",Font.BOLD,20));
        ID_text_b2.setBounds(200,100,50,40);
        p2.add(ID_text_b2);
        
        JLabel u_name_b2 = new JLabel("NAME :");
        u_name_b2.setFont(new Font("Verdana",Font.BOLD,20));
        u_name_b2.setBounds(50,150,150,40);
        p2.add(u_name_b2);
        
        JLabel uname_text_b2 = new JLabel(user.e_name);
        uname_text_b2.setFont(new Font("Verdana",Font.BOLD,20));
        uname_text_b2.setBounds(140,150,200,40);
        p2.add(uname_text_b2);
        
        JLabel vacc_s_b2 = new JLabel("NO OF DOSES :");
        vacc_s_b2.setFont(new Font("Verdana",Font.BOLD,20));
        vacc_s_b2.setBounds(50,200,200,40);
        p2.add(vacc_s_b2);
        
        JLabel vacc_stext_b2 = new JLabel(Integer.toString(user.vacc_status));
        vacc_stext_b2.setFont(new Font("Verdana",Font.BOLD,20));
        vacc_stext_b2.setBounds(220,200,100,40);
        p2.add(vacc_stext_b2);
        
        JLabel d1d_b2 = new JLabel("Dose 1 Date :");
        d1d_b2.setFont(new Font("Verdana",Font.BOLD,20));
        d1d_b2.setBounds(50,250,250,40);
        p2.add(d1d_b2);
        
        JLabel d1d_text_b2 = new JLabel(user.date1);
        d1d_text_b2.setFont(new Font("Verdana",Font.BOLD,20));
        d1d_text_b2.setBounds(300,250,350,40);
        p2.add(d1d_text_b2);
        
        JLabel d2d_b2 = new JLabel("Dose 2 Date :");
        d2d_b2.setFont(new Font("Verdana",Font.BOLD,20));
        d2d_b2.setBounds(50,300,250,40);
        p2.add(d2d_b2);
        
        JLabel d2d_text_b2 = new JLabel(user.date2);
        d2d_text_b2.setFont(new Font("Verdana",Font.BOLD,20));
        d2d_text_b2.setBounds(300,300,350,40);
        p2.add(d2d_text_b2);
        
        JLabel vacc_type_b2 = new JLabel("Vaccine TYPE :");
        vacc_type_b2.setFont(new Font("Verdana",Font.BOLD,20));
        vacc_type_b2.setBounds(50,350,200,40);
        p2.add(vacc_type_b2);
        
        JLabel vt_text_b2 = new JLabel(user.vacc_type);
        vt_text_b2.setFont(new Font("Verdana",Font.BOLD,20));
        vt_text_b2.setBounds(250,350,350,40);
        p2.add(vt_text_b2);
        
        String s0,s1,s2,disp;
        s0 = "1st dose is already booked on "+ user.date1;
        s1 = "2st dose is already booked on "+ user.date2;
        s2 = "You have already taken 2 dose";
        if(user.vacc_status == 0)
        {
        	disp=s0;
        }
        else if(user.vacc_status == 1)
        {
        	disp = s1;
        }
        else {
        	disp=s2;
        }
        JLabel m1 =  new JLabel(disp);
        m1.setFont(new Font("Verdana",Font.BOLD,30));
        m1.setBounds(600,450,1000,40);
        p2.add(m1);
        
        JLabel m2 =  new JLabel("So no need to book more");
        m2.setFont(new Font("Verdana",Font.BOLD,30));
        m2.setBounds(600,500,500,40);
        p2.add(m2);
        
        f2.setVisible(true);
        
	}
	static void clear() {
		userid_text.setText(null);
		password_text.setText(null);
	}
	static void clear1() {
		uname_text.setText(null);
		n_vaccs_text.setText(null);
		n_pass_text.setText(null);
		d1d_text.setText(null);
		d2d_text.setText(null);
		vacct_text.setText(null);
	}
	static private JPanel p;
	static private JFrame f; 
	static private JTextField vt_textf,b_date_text;
	static void b_portal(Employee user) {
		p = new JPanel();
		
		f = new JFrame();
		f = new JFrame("BOOKING PORTAL");
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p);
        p.setLayout(null);
        
        JLabel Head1 = new JLabel("USER INFORMATION");
        Head1.setFont(new Font("Verdana",Font.BOLD,40));
        Head1.setBounds(550,10,1200,40);
        p.add(Head1);
        
        JLabel Head2 = new JLabel("INSTRUCTIONS");
        Head2.setFont(new Font("Verdana",Font.BOLD,40));
        Head2.setBounds(900,300,1200,40);
        p.add(Head2);
        
        JLabel covi = new JLabel("1] 2nd dose of Covishield shoud be taken at min 84 days");
        covi.setFont(new Font("Verdana",Font.BOLD,20));
        covi.setBounds(700,400,1000,40);
        p.add(covi);
        
        JLabel cov1 = new JLabel("and at max 112 days after 1st dose ");
        cov1.setFont(new Font("Verdana",Font.BOLD,20));
        cov1.setBounds(700,450,1000,40);
        p.add(cov1);
        
        JLabel covacc = new JLabel("2] 2nd dose of Covaccine shoud be taken at min 28 days ");
        covacc.setFont(new Font("Verdana",Font.BOLD,20));
        covacc.setBounds(700,500,1000,40);
        p.add(covacc);
        
        JLabel covacc1 = new JLabel("and at max 42 days after 1st dose ");
        covacc1.setFont(new Font("Verdana",Font.BOLD,20));
        covacc1.setBounds(700,550,1000,40);
        p.add(covacc1);
        
        JLabel sput = new JLabel("3] 2nd dose of Covishield shoud be taken at min 21 days ");
        sput.setFont(new Font("Verdana",Font.BOLD,20));
        sput.setBounds(700,600,1000,40);
        p.add(sput);
        
        JLabel sput1 = new JLabel("and at max 84 days after 1st dose ");
        sput1.setFont(new Font("Verdana",Font.BOLD,20));
        sput1.setBounds(700,650,1000,40);
        p.add(sput1);
        
        JLabel EMP_ID = new JLabel("USER ID");
        EMP_ID.setFont(new Font("Verdana",Font.BOLD,20));
        EMP_ID.setBounds(10,100,100,40);
        p.add(EMP_ID);
        
        JLabel ID_text = new JLabel(Integer.toString(user.e_id));
        ID_text.setFont(new Font("Verdana",Font.BOLD,20));
        ID_text.setBounds(20,150,50,40);
        p.add(ID_text);
        
        JLabel u_name = new JLabel("NAME ");
        u_name.setFont(new Font("Verdana",Font.BOLD,20));
        u_name.setBounds(120,100,150,40);
        p.add(u_name);
        
        JLabel uname_text = new JLabel(user.e_name);
        uname_text.setFont(new Font("Verdana",Font.BOLD,20));
        uname_text.setBounds(120,150,200,40);
        p.add(uname_text);
        
        JLabel vacc_s = new JLabel("NO OF DOSES");
        vacc_s.setFont(new Font("Verdana",Font.BOLD,20));
        vacc_s.setBounds(250,100,200,40);
        p.add(vacc_s);
        
        JLabel vacc_stext = new JLabel("          "+user.vacc_status);
        vacc_stext.setFont(new Font("Verdana",Font.BOLD,20));
        vacc_stext.setBounds(250,150,100,40);
        p.add(vacc_stext);
        
        JLabel d1d = new JLabel("Dose 1 Date");
        d1d.setFont(new Font("Verdana",Font.BOLD,20));
        d1d.setBounds(450,100,250,40);
        p.add(d1d);
        
        JLabel d1d_text = new JLabel(user.date1);
        d1d_text.setFont(new Font("Verdana",Font.BOLD,20));
        d1d_text.setBounds(450,150,350,40);
        p.add(d1d_text);
        
        JLabel d2d = new JLabel("Dose 2 Date");
        d2d.setFont(new Font("Verdana",Font.BOLD,20));
        d2d.setBounds(625,100,250,40);
        p.add(d2d);
        
        JLabel d2d_text = new JLabel(user.date2);
        d2d_text.setFont(new Font("Verdana",Font.BOLD,20));
        d2d_text.setBounds(625,150,350,40);
        p.add(d2d_text);
        
        JLabel vacc_type = new JLabel("Vaccine TYPE");
        vacc_type.setFont(new Font("Verdana",Font.BOLD,20));
        vacc_type.setBounds(790,100,200,40);
        p.add(vacc_type);
        
        JLabel vt_text = new JLabel(user.vacc_type);
        vt_text.setFont(new Font("Verdana",Font.BOLD,20));
        vt_text.setBounds(790,150,350,40);
        p.add(vt_text);
        
        JLabel b_date = new JLabel("Booking date :");
        b_date.setFont(new Font("Verdana",Font.BOLD,20));
        b_date.setBounds(100,350,200,40);
        p.add(b_date);
        
        b_date_text = new JTextField(25);
        b_date_text.setFont(new Font("Verdana",Font.PLAIN,20));
        b_date_text.setBounds(275,350,200,40);
        p.add(b_date_text);
        
        JButton b1 =  new JButton("BOOK");
        b1.setFont(new Font("Verdana",Font.BOLD,25));
        b1.setBounds(100,450,200,35);
        
        JButton b2 =  new JButton("clear");
        b2.setFont(new Font("Verdana",Font.BOLD,25));
        b2.setBounds(400,450,200,35);
        
        JLabel ins1 = new JLabel("Enter Vaccination type only if this is your 1st dose");
        ins1.setFont(new Font("Verdana",Font.BOLD,20));
        ins1.setBounds(100,200,700,40);
        p.add(ins1);
        
        JLabel vt = new JLabel("Vaccination type(*) :");
        vt.setFont(new Font("Verdana",Font.BOLD,20));
        vt.setBounds(100,250,350,40);
        p.add(vt);
            
        vt_textf = new JTextField(25);
        vt_textf.setFont(new Font("Verdana",Font.PLAIN,20));
        vt_textf.setBounds(350,250,200,40);
        p.add(vt_textf);
            
     
        
        ActionListener ac3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == b2)
				{
					clear2();
				}
				else if(e.getSource() == b1) 
				{
					if(user.vacc_status == 0)
					{
						user.date1 = b_date_text.getText();
						if(user.vacc_status == 0) {user.vacc_type = vt_textf.getText();}
						String bd = b_date_text.getText();
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						int  pa=0;
						try {
							Date dc = sdf.parse(bd);
							Date cd = new Date();
							pa = (int)(TimeUnit.DAYS.convert(dc.getTime()-cd.getTime(), TimeUnit.MILLISECONDS));
						}catch(Exception ei) {
							ei.printStackTrace();
						}
						if(pa<=0)
						{
							clear2();
							JOptionPane.showMessageDialog(f,"Selected date has already passed","Error",JOptionPane.ERROR_MESSAGE);
						}
						else {
						frame.dispose();
						try {
							excel.update(user);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						b_done(user);
						}
					}
					else
					{
						String bd = b_date_text.getText();
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						int  n_days=0,past=0;
						try {
							Date di = sdf.parse(user.date1);
							Date dc = sdf.parse(bd);
							Date cd = new Date();
							past = (int)(TimeUnit.DAYS.convert(dc.getTime()-cd.getTime(), TimeUnit.MILLISECONDS));
							n_days = (int)(TimeUnit.DAYS.convert(dc.getTime()-di.getTime(), TimeUnit.MILLISECONDS));
						}catch(Exception ei) {
							ei.printStackTrace();
						}
						if(past<=0)
						{
							clear2();
							JOptionPane.showMessageDialog(f,"Selected date has already passed","Error",JOptionPane.ERROR_MESSAGE);
						}
						else {
						if(user.vacc_type.equals("Covishield"))
						{
							//84-112
							if(n_days>=84 && n_days<=112)
							{
								user.date2 = bd;
								frame.dispose();
								try {
									excel.update(user);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								b_done(user);
							}
							else
							{
								clear2();
								JOptionPane.showMessageDialog(f,"Invalid date according to criteria","Error",JOptionPane.ERROR_MESSAGE);
							}
						}
						else if(user.vacc_type.equals("Covaccine"))
						{
							//28-42
							if(n_days>=28 && n_days<=42)
							{
								user.date2 = bd;
								frame.dispose();
								try {
									excel.update(user);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								b_done(user);
							}
							else
							{
								clear2();
								JOptionPane.showMessageDialog(f,"Invalid date according to criateria","Error",JOptionPane.ERROR_MESSAGE);
							}
						}
						else if(user.vacc_type.equals("Sputnik"))
						{
							//21-84
							if(n_days>=21 && n_days<=84)
							{
								user.date2 = bd;
								frame.dispose();
								try {
									excel.update(user);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								b_done(user);
							}
							else
							{
								clear2();
								JOptionPane.showMessageDialog(f,"Invalid date according to criateria","Error",JOptionPane.ERROR_MESSAGE);
							}
						}
						}
					}
				}
				
			}
        };
        b1.addActionListener(ac3);
        b2.addActionListener(ac3);
        
        p.add(b1);
        p.add(b2);
        
        f.setVisible(true);
        
	}
	static void clear2()
	{
		vt_textf.setText(null);
		b_date_text.setText(null);
	}
	static private JFrame f3;
	static private JPanel p3;
	static void b_done(Employee user)
	{
		p3 = new JPanel();
		
		f3 = new JFrame();
		f3 = new JFrame("BOOKING PORTAL");
		f3.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f3.add(p3);
        p3.setLayout(null);
        
        JLabel Head_b2 = new JLabel("USER INFORMATION");
        Head_b2.setFont(new Font("Verdana",Font.BOLD,40));
        Head_b2.setBounds(550,10,1200,40);
        p3.add(Head_b2);
        
        JLabel EMP_ID_b2 = new JLabel("USER ID :");
        EMP_ID_b2.setFont(new Font("Verdana",Font.BOLD,20));
        EMP_ID_b2.setBounds(50,100,150,40);
        p3.add(EMP_ID_b2);
        
        JLabel ID_text_b2 = new JLabel(Integer.toString(user.e_id));
        ID_text_b2.setFont(new Font("Verdana",Font.BOLD,20));
        ID_text_b2.setBounds(200,100,50,40);
        p3.add(ID_text_b2);
       
        JLabel u_name_b2 = new JLabel("NAME :");
        u_name_b2.setFont(new Font("Verdana",Font.BOLD,20));
        u_name_b2.setBounds(50,150,150,40);
        p3.add(u_name_b2);
        
        JLabel uname_text_b2 = new JLabel(user.e_name);
        uname_text_b2.setFont(new Font("Verdana",Font.BOLD,20));
        uname_text_b2.setBounds(140,150,200,40);
        p3.add(uname_text_b2);
        
        JLabel vacc_s_b2 = new JLabel("NO OF DOSES :");
        vacc_s_b2.setFont(new Font("Verdana",Font.BOLD,20));
        vacc_s_b2.setBounds(50,200,200,40);
        p3.add(vacc_s_b2);
        
        JLabel vacc_stext_b2 = new JLabel(Integer.toString(user.vacc_status));
        vacc_stext_b2.setFont(new Font("Verdana",Font.BOLD,20));
        vacc_stext_b2.setBounds(220,200,100,40);
        p3.add(vacc_stext_b2);
        
        JLabel d1d_b2 = new JLabel("Dose 1 Date :");
        d1d_b2.setFont(new Font("Verdana",Font.BOLD,20));
        d1d_b2.setBounds(50,250,250,40);
        p3.add(d1d_b2);
        
        JLabel d1d_text_b2 = new JLabel(user.date1);
        d1d_text_b2.setFont(new Font("Verdana",Font.BOLD,20));
        d1d_text_b2.setBounds(300,250,350,40);
        p3.add(d1d_text_b2);
        
        JLabel d2d_b2 = new JLabel("Dose 2 Date :");
        d2d_b2.setFont(new Font("Verdana",Font.BOLD,20));
        d2d_b2.setBounds(50,300,250,40);
        p3.add(d2d_b2);
        
        JLabel d2d_text_b2 = new JLabel(user.date2);
        d2d_text_b2.setFont(new Font("Verdana",Font.BOLD,20));
        d2d_text_b2.setBounds(300,300,350,40);
        p3.add(d2d_text_b2);
        
        JLabel vacc_type_b2 = new JLabel("Vaccine TYPE :");
        vacc_type_b2.setFont(new Font("Verdana",Font.BOLD,20));
        vacc_type_b2.setBounds(50,350,200,40);
        p3.add(vacc_type_b2);
        
        JLabel vt_text_b2 = new JLabel(user.vacc_type);
        vt_text_b2.setFont(new Font("Verdana",Font.BOLD,20));
        vt_text_b2.setBounds(250,350,350,40);
        p3.add(vt_text_b2);
        
        String b1,b2,disp;
        b1 = "1st dose booking is done on "+user.date1;
        b2 = "2nd dose booking is done on " +user.date2;
        if(user.vacc_status == 0)
        {
        	disp = b1; 
        }
        else
        {
        	disp = b2;
        }
        JLabel m1 =  new JLabel(disp);
        m1.setFont(new Font("Verdana",Font.BOLD,30));
        m1.setBounds(500,450,1000,40);
        p3.add(m1);
        
        
        
        f3.setVisible(true);
	}
	static private JFrame f1;
	static private JPanel p1;
	static private JTextField uname_text,n_vaccs_text,d1d_text,d2d_text,vacct_text;
	static private JLabel Ins1,Head,u_name,u_id,n_vacc_status,n_pass,vacc_s_info,d1d,d2d,vacc_type;
	static private JPasswordField n_pass_text;
	static private JButton Submit,erase;
	
	static void add_new_emp() throws IOException {
		p1 = new JPanel();
		
		f1 = new JFrame();
		f1 = new JFrame("ADD NEW EMPLOYEE");
		f1.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.add(p1);
        
        Head = new JLabel("NEW EMPLOYEE INFO");
        Head.setFont(new Font("Verdana",Font.BOLD,40));
        Head.setBounds(550,10,1200,40);
        p1.add(Head);
        
        Ins1 = new JLabel("NOTE: Enter '-' in all unnecessary fields. Date format dd/mm/yyyy");
        Ins1.setFont(new Font("Verdana",Font.BOLD,30));
        Ins1.setBounds(250,50,1200,40);
        p1.add(Ins1);
        
        int id = (excel.n_id()+101);
        u_id = new JLabel("EMPLOYEE ID "+Integer.toString(id));
        u_id.setFont(new Font("Verdana",Font.BOLD,20));
        u_id.setBounds(100,100,300,25);
        p1.add(u_id);
        
        u_name = new JLabel("EMP NAME:");
        u_name.setFont(new Font("Verdana",Font.BOLD,20));
        u_name.setBounds(100,140,150,25);
        p1.add(u_name);
        
        uname_text = new JTextField(25);
        uname_text.setFont(new Font("Verdana",Font.PLAIN,20));
        uname_text.setBounds(250,140,200,25);
        p1.add(uname_text);
        
        n_pass = new JLabel("Password :");
        n_pass.setFont(new Font("Verdana",Font.BOLD,20));
        n_pass.setBounds(100,180,200,25);
        p1.add(n_pass);
        
        n_pass_text = new JPasswordField(25);
        n_pass_text.setFont(new Font("Verdana",Font.PLAIN,20));
        n_pass_text.setBounds(250,180,200,25);
        p1.add(n_pass_text);
        
        n_vacc_status = new JLabel("Vaccination status:");
        n_vacc_status.setFont(new Font("Verdana",Font.BOLD,20));
        n_vacc_status.setBounds(100,220,250,25);
        p1.add(n_vacc_status);
        
        vacc_s_info = new JLabel("Enter number of doses taken range [0,2]");
        vacc_s_info.setFont(new Font("Verdana",Font.PLAIN,15));
        vacc_s_info.setBounds(100,243,350,25);
        p1.add(vacc_s_info);
        
        n_vaccs_text = new JTextField(25);
        n_vaccs_text.setFont(new Font("Verdana",Font.PLAIN,20));
        n_vaccs_text.setBounds(320,220,200,25);
        p1.add(n_vaccs_text);
        
        d1d = new JLabel("Dose 1 Date(Only If taken):");
        d1d.setFont(new Font("Verdana",Font.BOLD,20));
        d1d.setBounds(100,280,350,25);
        p1.add(d1d);
        
        d1d_text = new JTextField(25);
        d1d_text.setFont(new Font("Verdana",Font.PLAIN,20));
        d1d_text.setBounds(425,280,200,25);
        p1.add(d1d_text);
        
        d2d = new JLabel("Dose 2 Date(Only If taken):");
        d2d.setFont(new Font("Verdana",Font.BOLD,20));
        d2d.setBounds(100,320,350,25);
        p1.add(d2d);
        
        d2d_text = new JTextField(25);
        d2d_text.setFont(new Font("Verdana",Font.PLAIN,20));
        d2d_text.setBounds(425,320,200,25);
        p1.add(d2d_text);
        
        vacc_type = new JLabel("Vaccination type(Eg Covishield):");
        vacc_type.setFont(new Font("Verdana",Font.BOLD,20));
        vacc_type.setBounds(100,380,400,25);
        p1.add(vacc_type);
        
        vacct_text = new JTextField(25);
        vacct_text.setFont(new Font("Verdana",Font.PLAIN,20));
        vacct_text.setBounds(475,380,200,25);
        p1.add(vacct_text);
        
        Submit =  new JButton("SUBMIT");
        Submit.setFont(new Font("Verdana",Font.PLAIN,25));
        Submit.setBounds(600,550,220,35);
        
        erase =  new JButton("RESET");
        erase.setFont(new Font("Verdana",Font.PLAIN,25));
        erase.setBounds(900,550,220,35);
        
        ActionListener ac2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==Submit)
				{
					Employee user = new Employee();
					user.e_id = id;
					user.e_pass = new String(n_pass_text.getPassword());
					user.e_name = new String(uname_text.getText());
					user.vacc_status = Integer.parseInt(n_vaccs_text.getText());
					user.date1 = new String(d1d_text.getText());
					user.date2 = new String(d2d_text.getText());
					user.vacc_type = new String(vacct_text.getText());
					if(user.vacc_status == 1 || user.vacc_status == 0)
					{
						user.b_status = 0;
					}
					else
					{
						user.b_status = 1;
					}
					try {
						excel.Insert(user);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JLabel finish = new JLabel("Information added successfully");
			        finish.setFont(new Font("Verdana",Font.BOLD,40));
			        finish.setBounds(550,600,1200,40);
			        p1.add(finish);
				}
				else if(e.getSource() == erase)
				{
					clear1();
				}
			}
        };   
        Submit.addActionListener(ac2);
        erase.addActionListener(ac2);
        p1.add(Submit);
        p1.add(erase);
        p1.setLayout(null);
		f1.setVisible(true);
	}
}
class excel extends Employee{
	static void update(Employee c_user) throws IOException {
		String f_path = "vacc_portal/data/office_data1.xlsx";
		FileInputStream in_stream = new FileInputStream(f_path);
		XSSFWorkbook workbook = new XSSFWorkbook(in_stream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Cell c4,c5,c7,c6;
		//++c_user.vacc_status;
		//c3 = sheet.getRow(c_user.r_num).getCell(3);
		c4 = sheet.getRow(c_user.r_num).getCell(4);
		c5 = sheet.getRow(c_user.r_num).getCell(5);
		c6 = sheet.getRow(c_user.r_num).getCell(6);
		c7 = sheet.getRow(c_user.r_num).getCell(7);
		if(c_user.vacc_status == 0)
		{
			c6.setCellValue(c_user.vacc_type);
			c4.setCellValue(c_user.date1);
			c7.setCellValue(1);
		}
		else if(c_user.vacc_status == 1)
		{
			//c3.setCellValue(c_user.vacc_status);
			c5.setCellValue(c_user.date2);
			c7.setCellValue(1);
		}
		in_stream.close();
		FileOutputStream out_stream = new FileOutputStream(f_path);
		workbook.write(out_stream);
		out_stream.close();
		workbook.close();
		System.out.println("File updated");
	}
	static int n_id() throws IOException {
		String f_path = "vacc_portal/data/office_data1.xlsx";
		FileInputStream in_stream = new FileInputStream(f_path);
		XSSFWorkbook workbook = new XSSFWorkbook(in_stream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		workbook.close();
		int id =sheet.getLastRowNum();
		return id;
	}
	static void Insert(Employee n_user) throws IOException{
		int insl = n_user.e_id-100;//insl-insert location
		String f_path = "vacc_portal/data/office_data1.xlsx";
		FileInputStream in_stream = new FileInputStream(f_path);
		XSSFWorkbook workbook = new XSSFWorkbook(in_stream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow n_row = sheet.createRow(insl);
		for(int i=0;i<8;i++)
		{
			switch(i)
			{
			case 0:{
				n_row.createCell(0).setCellValue(n_user.e_id);
				break;
			}
			case 1:{
				n_row.createCell(1).setCellValue(n_user.e_name);
				break;
			}
			case 2:{
				n_row.createCell(2).setCellValue(n_user.e_pass);
				break;
			}
			case 3:{
				n_row.createCell(3).setCellValue(n_user.vacc_status);
				break;
			}
			case 4:{
				n_row.createCell(4).setCellValue(n_user.date1);
				break;
			}
			case 5:{
				n_row.createCell(5).setCellValue(n_user.date2);
				break;
			}
			case 6:{
				n_row.createCell(6).setCellValue(n_user.vacc_type);
				break;
			}
			case 7:{
				n_row.createCell(7).setCellValue(n_user.b_status);
				break;
			}
			default:
			{
				break;
			}
			}
		}
		in_stream.close();
		FileOutputStream out_stream = new FileOutputStream(f_path);
		workbook.write(out_stream);
		out_stream.close();
		workbook.close();
		System.out.println("File updated");
	}
	static Employee Auth(int id,String pass) throws IOException
	{
		String f_path = "vacc_portal/data/office_data1.xlsx";
		FileInputStream in_stream = new FileInputStream(f_path);
		XSSFWorkbook workbook = new XSSFWorkbook(in_stream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String e_name = null,e_pass = null,date1 = null,date2 = null,vacc_type = null;
		int e_id = 0,vacc_status = 0,b_status = 0;
		int rows,cols;
		rows = sheet.getLastRowNum();
		cols = sheet.getRow(1).getLastCellNum();
		for(int r=0;r<=rows;r++)
		{
			XSSFRow row = sheet.getRow(r);
			if(r==0)continue;
			for(int c=0;c<cols;c++)
			{
				XSSFCell cell = row.getCell(c);
				switch(c)
				{
				case 0:
				{
					e_id = (int) cell.getNumericCellValue();
					break;
				}
				case 1:
				{
					e_name = cell.getStringCellValue();
					break;
				}
				case 2:
				{
					e_pass = cell.getStringCellValue();
					break;
				}
				case 3:
				{
					vacc_status = (int) cell.getNumericCellValue();
					
					break;
				}
				case 4:
				{
					date1 = cell.getStringCellValue();
					break;
				}
				case 5:
				{
					date2 = cell.getStringCellValue();
					break;
				}
				case 6:
				{
					vacc_type = cell.getStringCellValue();
					break;
				}
				case 7:
				{
					b_status = (int)cell.getNumericCellValue();
					break;
				}
				default:
				{
					break;
				}
				}
			}
			if(e_id==id && e_pass.equals(pass))
			{
				Employee user = new Employee(e_id,e_name,e_pass,vacc_status,date1,date2,vacc_type,b_status,r);
				workbook.close();
				return user;	
			}	
		}	
		workbook.close();
		Employee user = null;
		return user;
 	}
}
public class Main 
{
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		GUI.login();
	}
}
//why is this comment here u may be wondering its the same way I wonder why do we have to make this shit project
//answer to the above question is to complete a 1000 lines of code.

