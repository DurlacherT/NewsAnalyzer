package newsanalyzer.ui;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import newsanalyzer.ctrl.Controller;
import newsapi.NewsException;

public class UserInterface 
{

	private Controller ctrl = new Controller();

	public void getDataFromCtrl1(){
		try {
			System.out.println(ctrl.process("Wirtschaft"));
		} catch (NewsException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void getDataFromCtrl2(){
		try {
			System.out.println(ctrl.process("Apple"));
		} catch (NewsException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void getDataFromCtrl3(){
		try {
			System.out.println(ctrl.process("Microsoft"));
		} catch (NewsException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void getDataForCustomInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Suche nach Schlagwort: ");
		String q = scanner.next();
		try {
			System.out.println(ctrl.process(q));
		} catch (NewsException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}


	public void start() {
		Menu<Runnable> menu = new Menu<>("User Interface");
		menu.setTitel("Wählen Sie aus:");
		menu.insert("a", "Wirtschaft", this::getDataFromCtrl1);
		menu.insert("b", "Apple", this::getDataFromCtrl2);
		menu.insert("c", "Microsoft", this::getDataFromCtrl3);
		menu.insert("d", "Choice User Input:",this::getDataForCustomInput);
		menu.insert("q", "Quit", null);
		Runnable choice;
		while ((choice = menu.exec()) != null) {
			 choice.run();
		}
		System.out.println("Program finished");
	}


    protected String readLine() {
		String value = "\0";
		BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			value = inReader.readLine();
        } catch (IOException ignored) {
		}
		return value.trim();
	}

	protected Double readDouble(int lowerlimit, int upperlimit) 	{
		Double number = null;
        while (number == null) {
			String str = this.readLine();
			try {
				number = Double.parseDouble(str);
            } catch (NumberFormatException e) {
                number = null;
				System.out.println("Please enter a valid number:");
				continue;
			}
            if (number < lowerlimit) {
				System.out.println("Please enter a higher number:");
                number = null;
            } else if (number > upperlimit) {
				System.out.println("Please enter a lower number:");
                number = null;
			}
		}
		return number;
	}
}
